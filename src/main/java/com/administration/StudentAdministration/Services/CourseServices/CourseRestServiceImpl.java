package com.administration.StudentAdministration.Services.CourseServices;

import com.administration.StudentAdministration.Models.CourseModels.CourseWebModel;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



//service implementation used to push courses to webservice, not yet working
//TODO: actually implement som working functionality
@Service
public class CourseRestServiceImpl
{
    public CourseWebModel postCourseLegacy(CourseWebModel course)
    {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<CourseWebModel> request = new HttpEntity<>(course);

        String courseURL = "http://18.185.40.91/course";

        ResponseEntity<CourseWebModel> response =
                restTemplate.postForEntity(courseURL, request, CourseWebModel.class);

        if(!response.getStatusCode().isError())
        {
            System.out.println(response.getStatusCode());
            return response.getBody();
        }
        return null;
    }
}
