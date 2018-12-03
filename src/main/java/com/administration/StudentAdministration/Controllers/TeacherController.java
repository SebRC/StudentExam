package com.administration.StudentAdministration.Controllers;

import com.administration.StudentAdministration.Services.TeacherServices.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/teacher")
@Controller
public class TeacherController
{
    @Autowired
    private TeacherServiceImpl teacherService;

    @GetMapping("/consume")
    public String teachersConsume()
    {
        teacherService.consumeWebService();

        return "Courses/test";
    }

}
