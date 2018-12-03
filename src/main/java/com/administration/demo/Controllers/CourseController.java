package com.administration.demo.Controllers;

import com.administration.demo.Models.CourseModel;
import com.administration.demo.Services.CourseServices.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/course")
@Controller
public class CourseController
{
    @Autowired
    private CourseServiceImpl courseService;


    @GetMapping("/consume")
    public String consumeWebservice()
    {
        courseService.consumeWebService();

        return "redirect:/course/";
    }

    @GetMapping("/update")
    public String updateFromWebservice()
    {
        courseService.updateFromWebservice();

        return "redirect:/course/";
    }

    //  Course List Page
    @GetMapping
    public String courses(Model model)
    {
        model.addAttribute("courses", courseService.getAllCoursesFromDatabase());

        return "Courses/course";
    }


    // CRUD
    @GetMapping("/create")
    public String createCourse(Model model)
    {
        model.addAttribute("courseModel", new CourseModel());

        return "Courses/create";
    }

    @PostMapping("/create")
    public String createCourse(@ModelAttribute CourseModel courseModel)
    {
        courseService.save(courseModel);

        return "redirect:/course";
    }

    @GetMapping("/edit")
    public String editCourse(@RequestParam ("id") int id, Model model)
    {
        model.addAttribute("courseModel", courseService.findOne(id));

        return "Courses/edit";
    }


    @PostMapping("/edit/{id}")
    public String editCourse(@PathVariable int id, @ModelAttribute CourseModel courseModel)
    {
        courseService.save(courseModel);

        return "redirect:/course/";
    }

    @GetMapping("/delete")
    public String deleteCourse(@RequestParam ("id") int id, Model model)
    {
        model.addAttribute("courseModel", courseService.findOne(id));

        return "Courses/delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteCourse(@PathVariable int id)
    {
        courseService.deleteFromDatabase(id);

        return "redirect:/course/";
    }
    //CRUD End


}



