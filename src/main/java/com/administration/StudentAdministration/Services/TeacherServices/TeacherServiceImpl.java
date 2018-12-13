package com.administration.StudentAdministration.Services.TeacherServices;

import com.administration.StudentAdministration.Models.TeacherModels.TeacherWebModel;
import com.administration.StudentAdministration.Models.TeacherModels.TeacherModel;
import com.administration.StudentAdministration.Repositories.TeacherRepo;
import com.administration.StudentAdministration.Services.RoleServices.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService
{
    //repos for interacting with database and passwordencoder
    @Autowired
    private TeacherRepo teacherRepo;

    @Autowired
    private RoleServiceImpl roleService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //methods for interacting with database
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
    public void deleteFromDatabase(int id)
    {
        teacherRepo.deleteById(id);
    }

    //method for consuming teacher endpoint of webservice
    @Override
    public void consumeWebService()
    {
        String devURL = "http://18.185.40.91/teacher";

        RestTemplate restTemplate = new RestTemplate();

        TeacherWebModel[] teacherWebModelsArrray = restTemplate.getForObject(devURL, TeacherWebModel[].class);

        List<TeacherModel> localTeacherList = new ArrayList<>();

        for (TeacherWebModel teacherWebModel: teacherWebModelsArrray)
        {
            TeacherModel teacherModel = new TeacherModel(teacherWebModel.getName(), teacherWebModel.getEmail(),
                    teacherWebModel.getEmail(), bCryptPasswordEncoder.encode("1234"), 1);

            teacherModel.setRoles(new HashSet<>());

            teacherModel.getRoles().add(roleService.findOne(1));

            localTeacherList.add(teacherModel);
        }

        teacherRepo.saveAll(localTeacherList);
    }

}
