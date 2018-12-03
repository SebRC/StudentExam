package com.administration.demo.Services;

import com.administration.demo.Models.CourseModel;
import com.administration.demo.Models.CourseWebModel;
import com.administration.demo.Repositories.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService
{
    @Autowired
    private CourseRepo courseRepo;


    //  gets a list of all courses from local database
    public List<CourseModel> getAllCoursesFromDatabase()
    {
        return courseRepo.findAll();
    }


    //  gets one specific course from local database
    public CourseModel findOne(int id)
    {
        return courseRepo.getOne(id);
    }

    //  used in create and edit. saves info from form
    public void save(CourseModel courseModel)
    {
        courseRepo.save(courseModel);
    }

    //  Used only once if local database is unpopulated, gets info from legacy system (web) and saves locally
    public void consumeWebService()
    {
        //  endpoint for courses
        String devURL = "http://18.185.40.91/course";

        RestTemplate restTemplate = new RestTemplate();

        //  Temporary list to store legacy courses for saving
        CourseWebModel[] courseWebModelsArray = restTemplate.getForObject(devURL, CourseWebModel[].class);

        List<CourseModel> localCoursesList = new ArrayList<>();

        //  converts legacy courses to our model
        for (CourseWebModel courseWebModel : courseWebModelsArray)
        {
            CourseModel courseModel = new CourseModel(courseWebModel.getId(), courseWebModel.getNamedanish(), courseWebModel.getName(),
                    courseWebModel.getSemester(), courseWebModel.getStudyprogramme(),
                    courseWebModel.getEcts(), courseWebModel.getLanguage(), courseWebModel.getDescription(), courseWebModel.isMandatory());


            localCoursesList.add(courseModel);
        }

        //  saves the converted models in local database
        courseRepo.saveAll(localCoursesList);
    }

    //  uses an iterator to go through the attributes of our models from local database, and overwrites values to the updated values from legacy system
    public void updateFromWebservice()
    {
        String devURL = "http://18.185.40.91/course";

        RestTemplate restTemplate = new RestTemplate();

        CourseWebModel[] courseWebModelsArray = restTemplate.getForObject(devURL, CourseWebModel[].class);

        List<CourseModel> localCoursesList = courseRepo.findAll();

        Iterator<CourseModel> courseModelIterator = localCoursesList.iterator();

        List<CourseWebModel> courseWebModels = Arrays.asList(courseWebModelsArray);

        // TODO:  if statement hvis den ikke har next så skal den adde til local courses
        for (CourseWebModel courseWebModel : courseWebModels)
        {
            if(!courseModelIterator.hasNext())
            {
                CourseModel newCourseModel = new CourseModel();
            }


            CourseModel courseModel = courseModelIterator.next();

            courseModel.setCourseNameDanish(courseWebModel.getNamedanish());
            courseModel.setCourseNameEnglish(courseWebModel.getName());
            courseModel.setCourseSemester(courseModel.getCourseSemester());
            courseModel.setCourseStudyProgramme(courseModel.getCourseStudyProgramme());
            courseModel.setCourseECTS(courseModel.getCourseECTS());
            courseModel.setCourseLanguage(courseModel.getCourseLanguage());
            courseModel.setCourseLearningOutcome(courseModel.getCourseLearningOutcome());
            courseModel.setCourseMandatory(courseModel.getCourseMandatory());
        }

        courseRepo.saveAll(localCoursesList);
    }

    //  deletes specific course
    public void deleteFromDatabase(int id)
    {
        courseRepo.deleteById(id);
    }
}
