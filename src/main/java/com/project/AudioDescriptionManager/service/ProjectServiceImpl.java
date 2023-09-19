package com.project.AudioDescriptionManager.service;

import com.project.AudioDescriptionManager.data.DTOs.ProjectDTO;
import com.project.AudioDescriptionManager.data.model.Project;
import com.project.AudioDescriptionManager.repositories.ProjectRepository;
import com.project.AudioDescriptionManager.service.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

@Autowired
private  ModelMapper mapper;
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project findById(Long id) {
        return projectRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("objeto não encontrado"));
    }

    @Override
    public Project creat(ProjectDTO obj) {
        return projectRepository.save(mapper.map(obj, Project.class));
    }

    @Override
    public Project update (ProjectDTO obj) {
        return projectRepository.save(mapper.map(obj, Project.class));
    }

    @Override
    public void delet(Long id) {
        findById(id);
        projectRepository.deleteById(id);
    }


    public Project calculateTotalValue(Long id) {
        Project projectValue = findById(id);

        BigDecimal totalProject = projectValue.getValuePerMinut().multiply(new BigDecimal(projectValue.getDuration()));
        projectValue.setTotalValue(totalProject);
        return projectRepository.save(projectValue);

}

    }


