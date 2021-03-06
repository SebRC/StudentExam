package com.administration.StudentAdministration.Controllers;

import com.administration.StudentAdministration.Models.CourseModels.CourseModel;
import com.administration.StudentAdministration.Services.CourseServices.CourseRestServiceImpl;
import com.administration.StudentAdministration.Services.CourseServices.CourseServiceImpl;
import com.administration.StudentAdministration.Services.RoleServices.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//controller used for the login, welcome and access denied pages

@Controller
@RequestMapping("/home")
public class HomeController
{
    @Autowired
    private RoleServiceImpl roleService;

    @Autowired
    private CourseServiceImpl courseService;

    @Autowired
    private CourseRestServiceImpl courseRestService;

    @GetMapping("/course")
    public String coursePage(@PageableDefault(value=10, page=0) Pageable pageable,
                                   Model model, Principal principal)
    {
        //gets a page with coursemodels from database
        Page<CourseModel> page = courseService.courseModelPage(pageable);

        //creates a list of integers of number of pages
        //used in html to display amount of pages
        List<Integer> pageNumbers = IntStream.rangeClosed(1, page.getTotalPages())
                .boxed()
                .collect(Collectors.toList());

        //adds list of pagenumbers to be displayed in html
        model.addAttribute("pageNumbers", pageNumbers);

        //adds current page to be used for displaying active page in html
        //doesn't work as intended yet, active page number isn't highlighted
        // + is used to display the right page number
        model.addAttribute("number", page.getNumber() + 1);

        //adds total number of pages to model
        //used to check if pagination is needed in html
        model.addAttribute("totalPages", page.getTotalPages());

        //adds total number of elements
        //not used at the moment but could be useful later
        model.addAttribute("totalElements",
                page.getTotalElements());

        //adds the size of the page
        model.addAttribute("size", page.getSize());

        //adds the courses to be displayed
        model.addAttribute("courses", page.getContent());

        //regular attributes

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

    @GetMapping("/denied")
    public String denied()
    {
        return "Courses/denied";
    }

    @GetMapping("/rest")
    public String consumeOwnREST()
    {
        courseService.consumeOwnREST();

        return "Courses/test";
    }
}


