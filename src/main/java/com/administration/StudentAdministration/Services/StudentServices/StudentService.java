package com.administration.StudentAdministration.Services.StudentServices;
import com.administration.StudentAdministration.Models.StudentModels.StudentModel;
import java.util.List;

public interface StudentService
{
    List<StudentModel> getAllStudentsFromDatabase();

    StudentModel findOne(int id);

    void save(StudentModel studentModel);

    void consumeWebService();

    void updateFromWebservice();

    void deleteFromDatabase(int id);
}

