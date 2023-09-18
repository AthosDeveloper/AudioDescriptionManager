package com.project.AudioDescriptionManager.service;

import com.project.AudioDescriptionManager.data.model.Project;

import java.util.List;

public interface ProjectService {
    Project creat(Project obj);
    Project findById(Long id);
 List<Project> findAll();
 Project update(Project project);
 void delet(Long id);
}
