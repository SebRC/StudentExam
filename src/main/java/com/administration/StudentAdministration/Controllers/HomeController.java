package com.administration.StudentAdministration.Controllers;

import com.administration.StudentAdministration.Services.CourseServices.CourseServiceImpl;
import com.administration.StudentAdministration.Services.RoleServices.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

//controller used for the login, welcome and access denied pages
@Controller
@RequestMapping("/home")
public class HomeController
{
    @Autowired
    private RoleServiceImpl roleService;

    @Autowired
    private CourseServiceImpl courseService;

    @GetMapping("/course")
    public String course(Model model, Principal principal)
    {
        System.out.println();
        System.out.println(roleService.getActiveUserRole(principal.getName()).getRole_name());
        System.out.println();

        model.addAttribute("courses", courseService.getAllCoursesFromDatabase());

        model.addAttribute("role", roleService.getActiveUserRole(principal.getName()));

        model.addAttribute("username", principal.getName());

        return "Courses/course";

    }

    //mappings for the different home pages
    @GetMapping("/login")
    public String login()
    {
        return "Courses/login";
    }

    @GetMapping("/frontpage")
    public String frontpage(Principal principal)
    {
        System.out.println();
        System.out.println(roleService.getActiveUserRole(principal.getName()).getRole_name());
        System.out.println();
        return "Courses/frontpage";
    }

    @GetMapping("/denied")
    public String denied()
    {
        return "Courses/denied";
    }

}
