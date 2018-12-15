package com.administration.StudentAdministration.Controllers;

import com.administration.StudentAdministration.Models.CourseModels.CourseModel;
import com.administration.StudentAdministration.Services.CourseServices.CourseServiceImpl;
import com.administration.StudentAdministration.Services.RoleServices.RoleServiceImpl;
import com.administration.StudentAdministration.Services.TeacherServices.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

//controller used for directing teachers to different pages on the website
@RequestMapping("/teacher")
@Controller
public class TeacherController
{
    //services needed to get data from database
    @Autowired
    private CourseServiceImpl courseService;

    @Autowired
    private TeacherServiceImpl teacherService;

    @Autowired
    private RoleServiceImpl roleService;

    //getmapping for consuming teacher data from webservice
    @GetMapping("/consume")
    public String consumeWebservice()
    {
        courseService.consumeWebService();

        return "redirect:/home/course";
    }

    //getmapping for updating teachers in database with data from webservice
    @GetMapping("/update")
    public String updateFromWebservice()
    {
        courseService.updateFromWebservice();

        return "redirect:/home/course";
    }

    /*
    //  Course List Page
    @GetMapping("/course")
    public String courses(Model model)
    {
        model.addAttribute("courses", courseService.getAllCoursesFromDatabase());

        model.addAttribute("role", roleService.findOne(1));

        return "Courses/course";
    }
    */


    // CRUD
    @GetMapping("/create")
    public String createCourse(Model model, Principal principal)
    {
        model.addAttribute("courseModel", new CourseModel());

        model.addAttribute("teachers", teacherService.getAllTeachersFromDatabase());

        model.addAttribute("role", roleService.getActiveUserRole(principal.getName()));

        model.addAttribute("username", principal.getName());

        return "Courses/create";
    }

    @PostMapping("/create")
    public String createCourse(@ModelAttribute CourseModel courseModel)
    {
        courseService.save(courseModel);

        return "redirect:/home/course";
    }



    @GetMapping("/edit")
    public String editCourse(@RequestParam ("id") int id, Model model, Principal principal)
    {
        model.addAttribute("courseModel", courseService.findOne(id));

        model.addAttribute("teachers", teacherService.getAllTeachersFromDatabase());

        model.addAttribute("role", roleService.getActiveUserRole(principal.getName()));

        model.addAttribute("username", principal.getName());


        return "Courses/edit";
    }


    @PostMapping("/edit/{id}")
    public String editCourse(@PathVariable int id, @ModelAttribute CourseModel courseModel)
    {
        courseService.save(courseModel);

        return "redirect:/home/course";
    }

    @GetMapping("/delete")
    public String deleteCourse(@RequestParam ("id") int id, Model model, Principal principal)
    {
        model.addAttribute("courseModel", courseService.findOne(id));

        model.addAttribute("role", roleService.getActiveUserRole(principal.getName()));

        model.addAttribute("username", principal.getName());

        return "Courses/delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteCourse(@PathVariable int id)
    {
        courseService.deleteFromDatabase(id);

        return "redirect:/home/course";
    }
    //CRUD End


}



