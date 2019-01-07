package com.administration.StudentAdministration.Controllers;

import com.administration.StudentAdministration.Models.CourseModels.CourseModel;
import com.administration.StudentAdministration.Services.CourseServices.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RESTController
{
    @Autowired
    private CourseServiceImpl courseService;

    //test rest used for hitting own endpoint
    //always returns the same course
    //is used by HomeController when accessing endpoint /home/rest
    @RequestMapping("/rest-course")
    public CourseModel getFullCourseById()
    {
        return courseService.findOne(45);
    }

}

