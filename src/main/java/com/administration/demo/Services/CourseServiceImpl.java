package com.administration.demo.Services;

import com.administration.demo.Models.CourseModel;
import com.administration.demo.Models.CourseWebModel;
import com.administration.demo.Repositories.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService
{
    @Autowired
    private CourseRepo courseRepo;

    public List<CourseModel> getAllCoursesFromDatabase()
    {
        return courseRepo.findAll();
    }

    //TO DO
    //testklasse

    /*
    public CourseModel testJson() throws IOException
    {
        RestTemplate restTemplate = new RestTemplate();

        String devURL = "http://18.185.40.91/course/1";

        CourseWebModel courseWebModel = restTemplate.getForObject(devURL, CourseWebModel.class);

        CourseModel courseModel = new CourseModel(courseWebModel.getId(), courseWebModel.getName(), "Software Construction",
                courseWebModel.getSemester(),"WD-2018-32", courseWebModel.getStudyprogramme(),
                courseWebModel.getEcts(), courseWebModel.getLanguage(), 15, 30, 50, "Java and sql", "Learn java and sql again",
                "Java and coding", "Laern stuff", "Written exam", courseWebModel.isMandatory());

        return courseModel;

    }
    */

    public void getAllCoursesFromWebservice()
    {
        String devURL = "http://18.185.40.91/course/";

        RestTemplate restTemplate = new RestTemplate();

        List<CourseWebModel> courseWebModels = new ArrayList<>();

        for (int i = 1; i < 21; i++)
        {
            CourseWebModel courseWebModel = restTemplate.getForObject(devURL + i, CourseWebModel.class);

            courseWebModels.add(courseWebModel);

        }


        List<CourseModel> localCoursesList = new ArrayList<>();


        for (CourseWebModel courseWebModel : courseWebModels)
        {
            CourseModel courseModel = new CourseModel(courseWebModel.getId(), courseWebModel.getNamedanish(), courseWebModel.getName(),
                    courseWebModel.getSemester(), courseWebModel.getStudyprogramme(),
                    courseWebModel.getEcts(), courseWebModel.getLanguage(), courseWebModel.getDescription(), courseWebModel.isMandatory());


            localCoursesList.add(courseModel);
        }

        courseRepo.saveAll(localCoursesList);
    }


}
