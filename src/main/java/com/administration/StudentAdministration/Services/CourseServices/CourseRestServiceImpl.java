package com.administration.StudentAdministration.Services.CourseServices;


import com.administration.StudentAdministration.Models.CourseModels.CourseWebModel;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//service implementation used to push courses to webservice, not yet working
//TODO: actually implement som working functionality
@Service
public class CourseRestServiceImpl
{
    //method for pushing course to webserice
    public void addCourseToLegacy()
    {
        //  endpoint for courses
        String devURL = "http://18.185.40.91/course";

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.postForLocation(devURL, new CourseWebModel(0,1,"jackies test",
                "","","","",true,1,""));

    }
}
