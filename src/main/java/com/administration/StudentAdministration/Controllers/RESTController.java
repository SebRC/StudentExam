package com.administration.StudentAdministration.Controllers;

import com.administration.StudentAdministration.Services.CourseServices.CourseRestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

//controller meant to be used for pushing data to webservice
//not yet working
@RestController
public class RESTController
{
    @Autowired
    private CourseRestServiceImpl courseRestServiceImpl;

    //postmapping used to try and push to webservice
    @PostMapping("/push")
    public String pushToWeb()
    {
        courseRestServiceImpl.addCourseToLegacy();

        return "Courses/course";
    }
}
