package com.administration.StudentAdministration.Services.CourseServices;


import com.administration.StudentAdministration.Models.Course;
import com.administration.StudentAdministration.Models.CourseModels.CourseWebModel;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

//service implementation used to push courses to webservice, not yet working
//TODO: actually implement som working functionality
@Service
public class CourseRestServiceImpl
{
    //method for pushing course to webservice
    public CourseWebModel courseToAddToLegacy()
    {

        return new CourseWebModel(300,1,"Seb's test",
                "Datamatiker","ST1","10","This is a description",
                true,1,"Danish");

       /* String devURL = "http://18.185.40.91/course";
        HttpEntity<CourseWebModel> request = new HttpEntity<>(new CourseWebModel(300,1,"Seb's test",
                "Datamatiker","ST1","10","This is a description",
                true,1,"Danish"));

        //  endpoint for courses

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<CourseWebModel> response = restTemplate
                .exchange(devURL, HttpMethod.POST, request, CourseWebModel.class);

        System.out.println("STATUS CODE IS: " + response.getStatusCode());

        System.out.println();

        System.out.println("STATUS CODE VALUE IS: " + response.getStatusCodeValue());



        return response.getBody();
        */

    }

}
