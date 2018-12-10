package com.administration.StudentAdministration.Controllers;

import com.administration.StudentAdministration.Repositories.RoleRepo;
import com.administration.StudentAdministration.Services.CourseServices.CourseServiceImpl;
import com.administration.StudentAdministration.Services.StudentServices.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/home")
public class HomeController
{

    @GetMapping
    public String homepage()
    {
        return "Courses/test";
    }

    @GetMapping("/login")
    public String login()
    {
        return "Courses/login";
    }


    @GetMapping("/frontpage")
    public String frontpage()
    {
        return "Courses/frontpage";
    }


    @GetMapping("/denied")
    public String denied()
    {
        return "Courses/denied";
    }

}
