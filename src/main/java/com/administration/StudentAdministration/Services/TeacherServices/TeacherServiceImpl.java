package com.administration.StudentAdministration.Services.TeacherServices;

import com.administration.StudentAdministration.Models.TeacherModels.TeacherWebModel;
import com.administration.StudentAdministration.Models.TeacherModels.TeacherModel;
import com.administration.StudentAdministration.Repositories.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
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

        TeacherWebModel[] teacherWebModelsArrray = restTemplate.getForObject(devURL, TeacherWebModel[].class);

        List<TeacherModel> localTeacherList = new ArrayList<>();

        for (TeacherWebModel teacherWebModel: teacherWebModelsArrray)
        {
            TeacherModel teacherModel = new TeacherModel(teacherWebModel.getName(), teacherWebModel.getEmail());
            localTeacherList.add(teacherModel);
        }

        teacherRepo.saveAll(localTeacherList);
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
