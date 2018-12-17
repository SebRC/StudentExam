package com.administration.StudentAdministration.Services.CourseServices;


import com.administration.StudentAdministration.Models.CourseModels.CourseModel;
import org.springframework.data.domain.Pageable;

import java.util.List;

//interface of service used for database interaction having to do with courses
public interface CourseService
{
    List<CourseModel> getAllCoursesFromDatabase();

    CourseModel findOne(int id);

    void save(CourseModel courseModel);

    void consumeWebService();

    void updateFromWebservice();

    void deleteFromDatabase(int id);
}
