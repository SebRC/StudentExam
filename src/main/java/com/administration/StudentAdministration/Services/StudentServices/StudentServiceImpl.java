package com.administration.StudentAdministration.Services.StudentServices;

import com.administration.StudentAdministration.Models.StudentModels.StudentModel;
import com.administration.StudentAdministration.Repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService
{
    @Autowired
    private StudentRepo studentRepo;

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
