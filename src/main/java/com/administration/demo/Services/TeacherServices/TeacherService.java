package com.administration.demo.Services.TeacherServices;

import com.administration.demo.Models.TeacherModel;

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
