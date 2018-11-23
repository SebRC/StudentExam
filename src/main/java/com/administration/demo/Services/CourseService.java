package com.administration.demo.Services;


import com.administration.demo.Models.CourseModel;
import java.util.List;

public interface CourseService
{
    List<CourseModel> getAllCoursesFromDatabase();
}
