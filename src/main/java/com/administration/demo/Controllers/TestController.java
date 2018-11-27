package com.administration.demo.Controllers;

import com.administration.demo.Services.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/Test")
public class TestController
{
    @Autowired
    private CourseServiceImpl courseService;

    @GetMapping("/consumetest")
    public String consumeWebservice()
    {
        courseService.consumeWebService();

        return "test";
    }
}
