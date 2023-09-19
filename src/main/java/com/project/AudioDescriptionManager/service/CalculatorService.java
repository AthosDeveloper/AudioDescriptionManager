package com.project.AudioDescriptionManager.service;

import com.project.AudioDescriptionManager.data.DTOs.UserDTO;
import com.project.AudioDescriptionManager.data.enums.Position;
import com.project.AudioDescriptionManager.data.model.Project;
import com.project.AudioDescriptionManager.data.model.User;
import com.project.AudioDescriptionManager.service.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculatorService {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private ProjectServiceImpl projectService;
    private ModelMapper mapper;
    private boolean validateData(User user, Project project) {
        if (user != null && project != null) {
            return true;
        } else
throw  new ResourceNotFoundException("objeto não encontrado");
    }
 public User calculatePaymentUser(Project project, User user){
        validateData(user, project);
        if (user.getProject() != null){
            BigDecimal value =(project.getTotalValue().multiply(user.getPercentage())).divide(new BigDecimal("100.0"));
            user.setValueToReceive(value);
return  userService.create(mapper.map(user, UserDTO.class));
        }
  throw  new ResourceNotFoundException("objeto não encontrado");
 }
 }

