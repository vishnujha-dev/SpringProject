package com.project.security.controller;

import com.project.security.model.UserInfo;
import com.project.security.service.UserDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;


@RestController
@RequestMapping("/User")
public class UserSecureController {

    @Autowired
    UserDetailService userDetailService;
    private static final Logger logger= LoggerFactory.getLogger(UserSecureController.class);

    @GetMapping("/allRegisterUser")
    public List<UserInfo> allRegisterUser(String customerId){
        return userDetailService.getResisterUser();
    }

    @GetMapping("/{customerId}")
    @PreAuthorize("(hasAuthority('ROLE_ADMIN') or hasRole('NORMAL')) and hasAuthority('READ_USER')")
    //@PreAuthorize("hasRole('ADMIN')")
   // @PreAuthorize("hasAuthority('READ_USER')")
    public UserInfo getCustomer(@PathVariable("customerId") String customerId){
        return userDetailService.getUserUserNameOrID(customerId);
    }
}
