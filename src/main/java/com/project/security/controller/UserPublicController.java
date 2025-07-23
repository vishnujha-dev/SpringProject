package com.project.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class UserPublicController {

    //@PreAuthorize("hasRole('NORMAL')")
    @GetMapping("/home")
    public String getHome(){
        return "this is Home page";
    }

    @GetMapping("/user/register")
    public String getRegister(){
        return "this is Register page";
    }
}
