package com.administration.StudentAdministration.Services.StudentServices;

import com.administration.StudentAdministration.Models.StudentModels.StudentModel;
import com.administration.StudentAdministration.Repositories.RoleRepo;
import com.administration.StudentAdministration.Repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


import java.util.Arrays;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService
{

    private StudentRepo studentRepo;
    private RoleRepo roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo, RoleRepo roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder)
    {
        this.studentRepo = studentRepo;
        this.roleRepository = roleRepository;
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

        RestTemplate restTemplate = new RestTemplate();

        StudentModel[] studentModelsArray = restTemplate.getForObject(devURL, StudentModel[].class);

        List<StudentModel> studentModels = Arrays.asList(studentModelsArray);

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
}
