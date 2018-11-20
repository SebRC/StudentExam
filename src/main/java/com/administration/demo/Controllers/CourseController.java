package com.administration.demo.Controllers;

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

    @GetMapping
    public String courseHomepage(Model model)
    {
        model.addAttribute("courses", courseService.getCourses());

        return "course";
    }
}
