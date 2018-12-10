package com.administration.StudentAdministration.Controllers;

import com.administration.StudentAdministration.Models.CourseModels.CourseModel;
import com.administration.StudentAdministration.Repositories.RoleRepo;
import com.administration.StudentAdministration.Services.CourseServices.CourseServiceImpl;
import com.administration.StudentAdministration.Services.TeacherServices.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/teacher")
@Controller
public class TeacherController
{
    @Autowired
    private CourseServiceImpl courseService;

    @Autowired
    private TeacherServiceImpl teacherService;

    @Autowired
    private RoleRepo roleRepo;


    @GetMapping("/consume")
    public String consumeWebservice()
    {
        courseService.consumeWebService();

        return "redirect:/teacher/course";
    }

    @GetMapping("/consumeTeachers")
    public String consumeTeacher()
    {
        teacherService.consumeWebService();

        return "redirect:/teacher/course";
    }

    @GetMapping("/update")
    public String updateFromWebservice()
    {
        courseService.updateFromWebservice();

        return "redirect:/teacher/course";
    }

    //  Course List Page
    @GetMapping("/course")
    public String courses(Model model)
    {
        model.addAttribute("courses", courseService.getAllCoursesFromDatabase());

        model.addAttribute("role", roleRepo.getOne(1));

        return "Courses/course";
    }


    // CRUD
    @GetMapping("/create")
    public String createCourse(Model model)
    {
        model.addAttribute("courseModel", new CourseModel());

        model.addAttribute("teachers", teacherService.getAllTeachersFromDatabase());

        model.addAttribute("role", roleRepo.getOne(1));

        return "Courses/create";
    }

    @PostMapping("/create")
    public String createCourse(@ModelAttribute CourseModel courseModel)
    {
        courseService.save(courseModel);

        return "redirect:/teacher/course";
    }

    @GetMapping("/edit")
    public String editCourse(@RequestParam ("id") int id, Model model)
    {
        model.addAttribute("courseModel", courseService.findOne(id));

        model.addAttribute("teachers", teacherService.getAllTeachersFromDatabase());

        model.addAttribute("role", roleRepo.getOne(1));

        return "Courses/edit";
    }


    @PostMapping("/edit/{id}")
    public String editCourse(@PathVariable int id, @ModelAttribute CourseModel courseModel)
    {
        courseService.save(courseModel);

        return "redirect:/teacher/course";
    }

    @GetMapping("/delete")
    public String deleteCourse(@RequestParam ("id") int id, Model model)
    {
        model.addAttribute("courseModel", courseService.findOne(id));

        model.addAttribute("role", roleRepo.getOne(1));


        return "Courses/delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteCourse(@PathVariable int id)
    {
        courseService.deleteFromDatabase(id);

        return "redirect:/teacher/course";
    }
    //CRUD End


}



