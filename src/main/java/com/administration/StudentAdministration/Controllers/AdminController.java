package com.administration.StudentAdministration.Controllers;

import com.administration.StudentAdministration.Services.AdminServices.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController
{
    @Autowired
    private AdminServiceImpl adminService;
}
