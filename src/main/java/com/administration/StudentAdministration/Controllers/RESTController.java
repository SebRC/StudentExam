package com.administration.StudentAdministration.Controllers;

import com.administration.StudentAdministration.Models.CourseModels.CourseWebModel;
import com.administration.StudentAdministration.Services.CourseServices.CourseRestServiceImpl;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//controller meant to be used for pushing data to webservice
//not yet working
@RestController
public class RESTController
{
    @Autowired
    private CourseRestServiceImpl courseRestServiceImpl;

    @GetMapping("/push")
    public String push()
    {
        return "Courses/test";
    }

    //postmapping used to try and push to webservice
    @PostMapping("/push")
    public void postToWeb()
    {

    }


}
