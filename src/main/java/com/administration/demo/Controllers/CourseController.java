package com.administration.demo.Controllers;

import com.administration.demo.Models.CourseModel;
import com.administration.demo.Services.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/course")
public class CourseController
{
    @Autowired
    private CourseServiceImpl courseService;


    @GetMapping("/consume")
    public String consumeWebservice()
    {
        courseService.consumeWebService();

        return "Courses/edit";
    }

    @GetMapping("/editTest")
    public String test()
    {
        CourseModel courseModel = courseService.findOne(1);

        courseModel.setCourseClassCode("TEST AF KLASSEKODE");

        courseService.saveOne(courseModel);

        return "Courses/edit";
    }

    @GetMapping
    public String courses(Model model)
    {
        courseService.update();

        model.addAttribute("courses", courseService.getAllCoursesFromDatabase());

        return "Courses/course";
    }




}
