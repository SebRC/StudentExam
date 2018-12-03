package com.administration.StudentAdministration.Services.TeacherServices;

import com.administration.StudentAdministration.Models.TeacherModels.TeacherModel;

import java.util.List;

public interface TeacherService
{
    List<TeacherModel> getAllTeachersFromDatabase();

    TeacherModel findOne(int id);

    void save(TeacherModel teacherModel);

    void consumeWebService();

    void updateFromWebservice();

    void deleteFromDatabase(int id);
}
