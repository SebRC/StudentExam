package com.administration.StudentAdministration.Services.StudentServices;

import com.administration.StudentAdministration.Models.RoleModels.RoleModel;
import com.administration.StudentAdministration.Models.StudentModels.StudentModel;
import com.administration.StudentAdministration.Repositories.StudentRepo;
import com.administration.StudentAdministration.Services.RoleServices.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//service implementation used for database interaction having to do with students
@Service
public class StudentServiceImpl implements StudentService
{
    //repos for interacting with database and passwordencoder
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private RoleServiceImpl roleService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //methods for interacting with database
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
    public void deleteFromDatabase(int id) { studentRepo.deleteById(id); }

    //method for consuming students from webservice endpoint
    @Override
    public void consumeWebService()
    {
        String devURL = "http://18.185.40.91/student";

        RestTemplate restTemplate = new RestTemplate();

        StudentModel[] studentModelsArray = restTemplate.getForObject(devURL, StudentModel[].class);

        List<StudentModel> studentModels = Arrays.asList(studentModelsArray);

        for(StudentModel studentModel : studentModels)
        {
            studentModel.setPassword(bCryptPasswordEncoder.encode(studentModel.getPassword()));

            studentModel.setEnabled(1);

            //studentModel.setRoles(new HashSet<RoleModel>(Arrays.asList(studentRoles)));

            studentModel.setRoles(new HashSet<RoleModel>());

            studentModel.getRoles().add(roleService.findOne(0));
        }

        studentRepo.saveAll(studentModels);
    }
}
