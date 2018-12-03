package com.administration.demo.Services.TeacherServices;

import com.administration.demo.Models.TeacherModel;
import com.administration.demo.Repositories.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService
{
    @Autowired
    private TeacherRepo teacherRepo;

    public TeacherServiceImpl(){}

    @Override
    public List<TeacherModel> getAllTeachersFromDatabase()
    {
        return teacherRepo.findAll();
    }

    @Override
    public TeacherModel findOne(int id)
    {
        return teacherRepo.getOne(id);
    }

    @Override
    public void save(TeacherModel teacherModel)
    {
        teacherRepo.save(teacherModel);
    }

    @Override
    public void consumeWebService()
    {
        String devURL = "http://18.185.40.91/teacher";

        RestTemplate restTemplate = new RestTemplate();

        TeacherModel[] teacherModelsArrray = restTemplate.getForObject(devURL, TeacherModel[].class);

        List<TeacherModel> teacherModels = Arrays.asList(teacherModelsArrray);

        teacherRepo.saveAll(teacherModels);
    }

    @Override
    public void updateFromWebservice()
    {

    }

    @Override
    public void deleteFromDatabase(int id)
    {
        teacherRepo.deleteById(id);
    }
}
