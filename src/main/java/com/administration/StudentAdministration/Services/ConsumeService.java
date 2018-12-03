package com.administration.StudentAdministration.Services;

import com.administration.StudentAdministration.Services.CourseServices.CourseServiceImpl;
import com.administration.StudentAdministration.Services.TeacherServices.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class ConsumeService
{
    @Autowired
    private TeacherServiceImpl teacherService;

    @Autowired
    private CourseServiceImpl courseService;

    public void consumeAll()
    {
        teacherService.consumeWebService();

        courseService.consumeWebService();
    }
}
