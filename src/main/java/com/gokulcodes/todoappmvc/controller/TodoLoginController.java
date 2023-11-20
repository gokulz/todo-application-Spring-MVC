package com.gokulcodes.todoappmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoLoginController {
    
    @GetMapping("/showLoginPage")
    public String loginPage(){

        return "todo/todo-login";
    }
}
