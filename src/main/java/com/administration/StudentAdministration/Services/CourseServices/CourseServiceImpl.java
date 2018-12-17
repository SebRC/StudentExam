package com.administration.StudentAdministration.Services.CourseServices;

import com.administration.StudentAdministration.Models.CourseModels.CourseModel;
import com.administration.StudentAdministration.Repositories.CourseRepo;
import com.administration.StudentAdministration.Models.CourseModels.CourseWebModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

//service implementation used for database interaction having to do with courses
@Service
public class CourseServiceImpl implements CourseService
{
    //repo used for interacting with database
    @Autowired
    private CourseRepo courseRepo;

    //  gets a list of all courses from local database
    public List<CourseModel> getAllCoursesFromDatabase()
    {
        return courseRepo.findAll();
    }

    public Page<CourseModel> courseModelPage(Pageable pageable)
    {
        return courseRepo.findAll(pageable);
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
                    courseWebModel.getEcts(), courseWebModel.getLanguange(), courseWebModel.getDescription(), courseWebModel.isMandatory());


            localCoursesList.add(courseModel);
        }

        //  saves the converted models in local database
        courseRepo.saveAll(localCoursesList);
    }

    //  uses an iterator to go through the attributes of our models from local database, and overwrites values to the updated values from legacy system

    //  TODO må slette 1 fag
    public void updateFromWebservice()
    {
        String devURL = "http://18.185.40.91/course";

        RestTemplate restTemplate = new RestTemplate();

        CourseWebModel[] courseWebModelsArray = restTemplate.getForObject(devURL, CourseWebModel[].class);

        List<CourseModel> localCoursesList = courseRepo.findAll();

        Iterator<CourseModel> courseModelIterator = localCoursesList.iterator();

        List<CourseWebModel> courseWebModels = Arrays.asList(courseWebModelsArray);

        for (CourseWebModel courseWebModel : courseWebModels)
        {
            if(!courseModelIterator.hasNext())
            {
                CourseModel newCourseModel = new CourseModel(courseWebModel.getId(),
                        courseWebModel.getNamedanish(), courseWebModel.getName(), courseWebModel.getSemester(),
                        courseWebModel.getStudyprogramme(), courseWebModel.getEcts(), courseWebModel.getLanguange(),
                        courseWebModel.getDescription(), courseWebModel.isMandatory());

                localCoursesList.add(newCourseModel);
            }

            else
            {
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


        }

        courseRepo.saveAll(localCoursesList);
    }

    //  deletes specific course
    public void deleteFromDatabase(int id)
    {
        courseRepo.deleteById(id);
    }
}
