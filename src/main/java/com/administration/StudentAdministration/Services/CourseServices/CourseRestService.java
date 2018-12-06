package com.administration.StudentAdministration.Services.CourseServices;

import com.administration.StudentAdministration.Models.CourseModels.CourseModel;
import com.administration.StudentAdministration.Models.CourseModels.CourseWebModel;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class CourseRestService
{
    public void addCourseToLegacy()
    {
        //  endpoint for courses
        String devURL = "http://18.185.40.91/course";

        RestTemplate restTemplate = new RestTemplate();

        //restTemplate.postForLocation(devURL, new CourseWebModel())
    }
}
