package com.administration.demo.Services.CourseServices;


import com.administration.demo.Models.CourseModel;
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
