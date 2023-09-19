package com.project.AudioDescriptionManager.controllers;

import com.project.AudioDescriptionManager.data.DTOs.ProjectDTO;
import com.project.AudioDescriptionManager.data.DTOs.UserDTO;
import com.project.AudioDescriptionManager.data.model.Project;
import com.project.AudioDescriptionManager.service.ProjectServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Api(value = "ProjectEndpoint", description = "REST API for Project", tags = {"PersonEndpoint"})

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    private  static final  String ID = "/{id}";

    @Autowired
    private ProjectServiceImpl service;
@Autowired
    ModelMapper mapper;
@ApiOperation(value = "CalcularValorProjeto")
@PostMapping(value = ID, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Project> calculateTotalValue (@PathVariable Long id, @RequestBody Project obj){
    obj = service.calculateTotalValue(id);
    return ResponseEntity.ok().body(obj);
}

@ApiOperation(value = "EncontrarProjetoEspecifico")
@GetMapping(value = ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectDTO> findById(@PathVariable Long id) {

        return ResponseEntity.ok().body(mapper.map(service.findById(id), ProjectDTO.class));

}
@ApiOperation(value = "CriarProjeto")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
            public ResponseEntity<ProjectDTO> creat(@RequestBody ProjectDTO obj){


        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path(ID).buildAndExpand(service.creat(obj).getId_project()).toUri();
        return ResponseEntity.created(uri).build();

    }
@ApiOperation(value = "DeletarProjetoPeloId")
@DeleteMapping(value = ID, consumes = MediaType.APPLICATION_JSON_VALUE)
public  ResponseEntity<Void> delet(@PathVariable Long id){
    service.delet(id);
    return  ResponseEntity.noContent().build();
}
@ApiOperation(value = "EncontrarTodosProjetos")
@GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProjectDTO>> findAllProject(){

        return ResponseEntity.ok().body(service.findAll().stream().map(x -> mapper.map(x, ProjectDTO.class)).collect(Collectors.toList()));
    }


}

