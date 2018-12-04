package com.administration.StudentAdministration.Controllers;

import com.administration.StudentAdministration.Services.StudentServices.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController
{
    @Autowired
    StudentServiceImpl studentService;

    @GetMapping("/consume")
    public String consume()
    {
        studentService.consumeWebService();
        return "Courses/test";
    }

    @GetMapping("/login")
    public String login()
    {
        return "Courses/login";
    }
}
