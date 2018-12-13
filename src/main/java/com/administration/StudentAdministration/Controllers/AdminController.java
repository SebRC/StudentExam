package com.administration.StudentAdministration.Controllers;

import com.administration.StudentAdministration.Repositories.RoleRepo;
import com.administration.StudentAdministration.Services.AdminServices.AdminServiceImpl;
import com.administration.StudentAdministration.Services.CourseServices.CourseServiceImpl;
import com.administration.StudentAdministration.Services.StudentServices.StudentServiceImpl;
import com.administration.StudentAdministration.Services.TeacherServices.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController
{
    @Autowired
    private AdminServiceImpl adminService;

    @Autowired
    StudentServiceImpl studentService;

    @Autowired
    private TeacherServiceImpl teacherService;

    @Autowired
    private CourseServiceImpl courseService;

    @Autowired
    private RoleRepo roleRepo;

    @GetMapping("/consume")
    public String consumeAll()
    {
        studentService.consumeWebService();
        teacherService.consumeWebService();
        courseService.consumeWebService();

        return "redirect:/student/course";
    }

    @GetMapping("/course")
    public String course(Model model)
    {
        model.addAttribute("courses", courseService.getAllCoursesFromDatabase());

        model.addAttribute("role", roleRepo.getOne(2));

        return "Courses/course";
    }

    @GetMapping("/test")
    public String test()
    {
        adminService.createAdmin();

        return "redirect:/admin/Course";
    }

}
