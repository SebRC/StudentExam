package com.administration.demo.Services;

import com.administration.demo.Models.Course;
import com.administration.demo.Models.FajsalModel;
import com.administration.demo.Repositories.CourseRepo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService
{
    @Autowired
    private CourseRepo courseRepo;

    public List<Course> getCourses()
    {
        return courseRepo.findAll();
    }

    public void saveCourse()
    {
        Course course1 = new Course("SWC3");

        Course course2 = new Course("SWD3");

        Course course3 = new Course("ITO");

        courseRepo.save(course1);
        courseRepo.save(course2);
        courseRepo.save(course3);

    }

    //TO DO
    //testklasse
    public FajsalModel testJson() throws IOException
    {
        RestTemplate restTemplate = new RestTemplate();

        String devURL = "http://18.185.40.91/course/1";

        /*ResponseEntity<String> responseEntity =
                restTemplate.getForEntity(devURL + "/1", String.class);

        //assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.OK));

        ObjectMapper mapper = new ObjectMapper();

        JsonNode root = mapper.readTree(responseEntity.getBody());

        JsonNode name = root.path("name");

        //assertThat(name.asText(), notNullValue());*/

        FajsalModel fajsalModel =
                restTemplate.getForObject(devURL, FajsalModel.class);

        //assertThat(course.getCourseNameDanish(), notNullValue());
        //assertThat(course.getCourseID(), is(0));

        System.out.println(fajsalModel.getName() + "     hejhejhejehejejherjekfjdbfgjkdbgjk");

        return fajsalModel;

    }
}
