package com.administration.StudentAdministration.Services.StudentServices;

import com.administration.StudentAdministration.Models.StudentModels.StudentModel;
import com.administration.StudentAdministration.Repositories.RoleRepo;
import com.administration.StudentAdministration.Repositories.StudentRepo;
import com.administration.StudentAdministration.Role;
import com.administration.StudentAdministration.Services.ActiveUserServices.ActiveUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.security.Principal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService
{


    private StudentRepo studentRepo;

    private RoleRepo roleRepo;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private ActiveUserServiceImpl activeUserService;

    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo, RoleRepo roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder)
    {
        this.studentRepo = studentRepo;
        this.roleRepo = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public List<StudentModel> getAllStudentsFromDatabase()
    {
        return studentRepo.findAll();
    }

    @Override
    public StudentModel findOne(int id)
    {
        return studentRepo.getOne(id);
    }

    @Override
    public void save(StudentModel studentModel)
    {
        studentRepo.save(studentModel);
    }

    @Override
    public void consumeWebService()
    {
        String devURL = "http://18.185.40.91/student";

        Role studentRoles = roleRepo.getOne(0);

        System.out.println(studentRoles.getRole_name());

        RestTemplate restTemplate = new RestTemplate();

        StudentModel[] studentModelsArray = restTemplate.getForObject(devURL, StudentModel[].class);

        List<StudentModel> studentModels = Arrays.asList(studentModelsArray);

        for(StudentModel studentModel : studentModels)
        {
            studentModel.setPassword(bCryptPasswordEncoder.encode(studentModel.getPassword()));

            studentModel.setEnabled(1);

            //studentModel.setRoles(new HashSet<Role>(Arrays.asList(studentRoles)));

            studentModel.setRoles(new HashSet<Role>());

            studentModel.getRoles().add(studentRoles);
        }

        studentRepo.saveAll(studentModels);
    }

    @Override
    public void updateFromWebservice()
    {

    }

    @Override
    public void deleteFromDatabase(int id)
    {

    }

    //@Query("select s.username, r.role_name from students s inner join students_roles sr on(s.id=sr.id) inner join roles r on(sr.role_id=r.role_id) where username = " +  )
    //public String getActiveUserRole();
}
