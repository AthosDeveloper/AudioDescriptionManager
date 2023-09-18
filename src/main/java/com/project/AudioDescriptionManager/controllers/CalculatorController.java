package com.project.AudioDescriptionManager.controllers;

import com.project.AudioDescriptionManager.data.model.Project;
import com.project.AudioDescriptionManager.data.model.User;
import com.project.AudioDescriptionManager.service.CalculatorService;
import com.project.AudioDescriptionManager.service.ProjectServiceImpl;
import com.project.AudioDescriptionManager.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {
    private static final String ID;
    @Autowired
    private CalculatorService calculatorService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private  ProjectServiceImpl projectService;


    @PostMapping(value = ID, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> calculatePaymentUser(@PathVariable Long id, @PathVariable Long id, @RequestBody User user) {
user = userService.findById(id);
        Project project = new Project();

        project = projectService.findById(id);
User result = calculatorService.calculatePaymentUser(project, user);
   return  ResponseEntity.ok().body(result);
    }

    }