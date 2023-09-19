package com.project.AudioDescriptionManager.service;

import com.project.AudioDescriptionManager.data.DTOs.ProjectDTO;
import com.project.AudioDescriptionManager.data.model.Project;

import java.util.List;

public interface ProjectService {
    Project creat(ProjectDTO obj);
    Project findById(Long id);
 List<Project> findAll();
 Project update(ProjectDTO obj);
 void delet(Long id);
}
