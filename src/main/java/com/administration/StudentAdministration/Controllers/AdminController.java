package com.administration.StudentAdministration.Controllers;

import com.administration.StudentAdministration.Services.AdminServices.AdminServiceImpl;
import com.administration.StudentAdministration.Services.CourseServices.CourseServiceImpl;
import com.administration.StudentAdministration.Services.RoleServices.RoleServiceImpl;
import com.administration.StudentAdministration.Services.StudentServices.StudentServiceImpl;
import com.administration.StudentAdministration.Services.TeacherServices.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//controller used for directing admins to different pages on the website
@Controller
@RequestMapping("/admin")
public class AdminController
{
    //services needed to get data from database
    @Autowired
    private AdminServiceImpl adminService;

    @Autowired
    StudentServiceImpl studentService;

    @Autowired
    private TeacherServiceImpl teacherService;

    @Autowired
    private CourseServiceImpl courseService;

    @Autowired
    private RoleServiceImpl roleService;

    //method for consuming the three different endpoints from webservice
    @GetMapping("/consume")
    public String consumeAll()
    {
        studentService.consumeWebService();
        teacherService.consumeWebService();
        courseService.consumeWebService();

        return "redirect:/home/course";
    }

    /*
    //getmapping for admin version of course page
    @GetMapping("/course")
    public String course(Model model)
    {
        model.addAttribute("courses", courseService.getAllCoursesFromDatabase());

        model.addAttribute("role", roleService.findOne(2));

        return "Courses/course";
    }
    */

    //method for creating an admin and saving it in the database
    //admins username will be set to test and password will be set to 1234
    @GetMapping("/test")
    public String test()
    {
        adminService.createAdmin();

        return "redirect:/home/Course";
    }

}
