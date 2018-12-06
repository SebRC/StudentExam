package com.administration.StudentAdministration.Controllers;

import com.administration.StudentAdministration.Models.CourseModels.CourseWebModel;
import com.administration.StudentAdministration.Services.CourseServices.CourseRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTController
{
    @Autowired
    private CourseRestService courseRestService;



    @PostMapping("/push")
    public String pushToWeb()
    {
        courseRestService.addCourseToLegacy();

        return "Courses/course";
    }
}
