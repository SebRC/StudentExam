package com.administration.demo.Controllers;

import com.administration.demo.Services.TeacherServices.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/teacher")
@Controller
public class TeacherController
{
    @Autowired
    private TeacherServiceImpl teacherService;

    @GetMapping("/teacherConsume")
    public String teachersConsume()
    {
        teacherService.consumeWebService();

        return "Courses/test";
    }

}
