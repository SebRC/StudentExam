package com.administration.StudentAdministration.Services.CourseServices;


import com.administration.StudentAdministration.Models.CourseModels.CourseModel;

import java.util.List;

//
public interface CourseService
{
    List<CourseModel> getAllCoursesFromDatabase();

    CourseModel findOne(int id);

    void save(CourseModel courseModel);

    void consumeWebService();

    void updateFromWebservice();

    void deleteFromDatabase(int id);
}
