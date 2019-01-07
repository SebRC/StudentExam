package com.administration.StudentAdministration.Services.TeacherServices;

import com.administration.StudentAdministration.Models.TeacherModels.TeacherModel;
import java.util.List;

//interface of service used for database interaction having to do with teachers
public interface TeacherService
{
    List<TeacherModel> getAllTeachersFromDatabase();

    TeacherModel findOne(int id);

    void save(TeacherModel teacherModel);

    void consumeWebService();

    void deleteFromDatabase(int id);
}


