package com.administration.StudentAdministration.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//controller used for the login, welcome and access denied pages
@Controller
@RequestMapping("/home")
public class HomeController
{
    //mappings for the different home pages
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
