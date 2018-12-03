package com.administration.demo.Services;

import com.administration.demo.Services.CourseServices.CourseServiceImpl;
import com.administration.demo.Services.TeacherServices.TeacherServiceImpl;
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
