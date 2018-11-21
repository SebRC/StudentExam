package com.administration.demo.Services;

import com.administration.demo.Models.CourseModel;
import com.administration.demo.Models.FajsalModel;
import com.administration.demo.Repositories.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService
{
    @Autowired
    private CourseRepo courseRepo;

    public List<CourseModel> getCourses()
    {
        return courseRepo.findAll();
    }

    //TO DO
    //testklasse
    public CourseModel testJson() throws IOException
    {
        RestTemplate restTemplate = new RestTemplate();

        String devURL = "http://18.185.40.91/course/1";

        FajsalModel fajsalModel =
                restTemplate.getForObject(devURL, FajsalModel.class);

        CourseModel courseModel = new CourseModel(fajsalModel.getId(), fajsalModel.getName(), "Software Construction",
                fajsalModel.getSemester(),"WD-2018-32", fajsalModel.getStudyprogramme(),
                fajsalModel.getEcts(), fajsalModel.getLanguage(), 15, 30, 50, "Java and sql", "Learn java and sql again",
                "Java and coding", "Laern stuff", "Written exam", fajsalModel.isMandatory());

        return courseModel;

    }
}
