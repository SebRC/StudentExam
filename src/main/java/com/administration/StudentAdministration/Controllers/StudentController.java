package com.administration.StudentAdministration.Controllers;

import com.administration.StudentAdministration.Repositories.RoleRepo;
import com.administration.StudentAdministration.Services.CourseServices.CourseService;
import com.administration.StudentAdministration.Services.CourseServices.CourseServiceImpl;
import com.administration.StudentAdministration.Services.StudentServices.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
@RequestMapping("/student")
public class StudentController
{
    @Autowired
    StudentServiceImpl studentService;

    @Autowired
    CourseServiceImpl courseService;

    @Autowired
    RoleRepo roleRepo;

    @GetMapping("/consume")
    public String consume()
    {
        studentService.consumeWebService();

        return "redirect:/student/course";
    }

    @GetMapping("/login")
    public String login()
    {
        return "Courses/login";
    }

    @GetMapping("/course")
    public String course(Model model, Principal principal)
    {
        model.addAttribute("courses", courseService.getAllCoursesFromDatabase());

        model.addAttribute("role", roleRepo.getOne(0));

        model.addAttribute("user", principal.getName());

        return "Courses/course";
    }

}
