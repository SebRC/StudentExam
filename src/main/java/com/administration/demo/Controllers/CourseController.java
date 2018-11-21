package com.administration.demo.Controllers;

import com.administration.demo.Services.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller("/course")
public class CourseController
{
    @Autowired
    private CourseServiceImpl courseService;

    @GetMapping
    public String courseHomepage(Model model) throws IOException
    {
        courseService.testJson();

        model.addAttribute("courses", courseService.getCourses());

        return "course";
    }



}
