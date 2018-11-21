package com.administration.demo.Services;

import com.administration.demo.Models.Course;
import com.administration.demo.Repositories.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
}
