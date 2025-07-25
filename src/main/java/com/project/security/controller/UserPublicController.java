package com.project.security.controller;

import com.project.security.service.FilePathFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/public")
public class UserPublicController {

    @Autowired
    FilePathFinder filePathFinder;

    //@PreAuthorize("hasRole('NORMAL')")
    @GetMapping("/home")
    public String getHome(){
        return "this is Home page";
    }

    @GetMapping("/user/register")
    public String getRegister(){
        return "this is Register page";
    }

    @GetMapping("/file/{fileName}")
    public List<String> getFileName(@PathVariable("fileName") String fileName){
        List<String> fileList=filePathFinder.filePathFromFileName(fileName);
        return fileList;
    }
    @GetMapping("/fileMover/{Output}")
    public String getFileMover(@PathVariable("Output") String Output){
        return filePathFinder.fileMover(Output);
    }
}

