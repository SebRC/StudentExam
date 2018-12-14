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

//controller used for directing students to different pages on the website
@Controller
@RequestMapping("/student")
public class StudentController
{
    //services needed to get data from database
    @Autowired
    StudentServiceImpl studentService;

    @Autowired
    CourseServiceImpl courseService;

    @Autowired
    RoleRepo roleRepo;

    //getmapping for consuming student data from webservice
    @GetMapping("/consume")
    public String consume()
    {
        studentService.consumeWebService();

        return "redirect:/home/course";
    }

    /*
    //students version of course page
    @GetMapping("/course")
    public String course(Model model, Principal principal)
    {
        model.addAttribute("courses", courseService.getAllCoursesFromDatabase());

        model.addAttribute("role", roleRepo.getOne(0));

        model.addAttribute("user", principal.getName());

        return "Courses/course";
    }
    */

}
