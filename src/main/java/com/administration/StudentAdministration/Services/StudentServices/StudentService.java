package com.administration.StudentAdministration.Services.StudentServices;

import com.administration.StudentAdministration.Models.StudentModels.StudentModel;
import java.util.List;

//interface of service used for database interaction having to do with students
public interface StudentService
{
    List<StudentModel> getAllStudentsFromDatabase();

    StudentModel findOne(int id);

    void save(StudentModel studentModel);

    void consumeWebService();

    void deleteFromDatabase(int id);
}

