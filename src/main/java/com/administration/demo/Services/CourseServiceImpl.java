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

    public CourseModel findOne(int id)
    {
        return courseRepo.getOne(id);
    }

    public void saveOne(CourseModel courseModel)
    {
        courseRepo.save(courseModel);
    }
    public void consumeWebService()
    {
        String devURL = "http://18.185.40.91/course";

        RestTemplate restTemplate = new RestTemplate();

        CourseWebModel[] courseWebModelsArray = restTemplate.getForObject(devURL, CourseWebModel[].class);

        List<CourseModel> localCoursesList = new ArrayList<>();

        for (CourseWebModel courseWebModel : courseWebModelsArray)
        {
            CourseModel courseModel = new CourseModel(courseWebModel.getId(), courseWebModel.getNamedanish(), courseWebModel.getName(),
                    courseWebModel.getSemester(), courseWebModel.getStudyprogramme(),
                    courseWebModel.getEcts(), courseWebModel.getLanguage(), courseWebModel.getDescription(), courseWebModel.isMandatory());


            localCoursesList.add(courseModel);
        }

        courseRepo.saveAll(localCoursesList);
    }

    public void update()
    {
        String devURL = "http://18.185.40.91/course";

        RestTemplate restTemplate = new RestTemplate();

        CourseWebModel[] courseWebModelsArray = restTemplate.getForObject(devURL, CourseWebModel[].class);

        List<CourseModel> localCoursesList = courseRepo.findAll();

        for (int i = 1; i < courseWebModelsArray.length; i++)
        {
            localCoursesList.get(i).setCourseNameDanish(courseWebModelsArray[i].getNamedanish());
            localCoursesList.get(i).setCourseNameEnglish(courseWebModelsArray[i].getName());
            localCoursesList.get(i).setCourseSemester(courseWebModelsArray[i].getSemester());
            localCoursesList.get(i).setCourseECTS(courseWebModelsArray[i].getEcts());
            localCoursesList.get(i).setCourseStudyProgramme(courseWebModelsArray[i].getStudyprogramme());
            localCoursesList.get(i).setCourseLanguage(courseWebModelsArray[i].getLanguage());
            localCoursesList.get(i).setCourseContent(courseWebModelsArray[i].getDescription());
        }

        courseRepo.saveAll(localCoursesList);
    }


}
