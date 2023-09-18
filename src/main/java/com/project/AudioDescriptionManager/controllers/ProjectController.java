package com.project.AudioDescriptionManager.controllers;

import com.project.AudioDescriptionManager.data.model.Project;
import com.project.AudioDescriptionManager.service.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    private  static final  String ID = "/{id}";

    @Autowired
    private ProjectServiceImpl service;
@PostMapping(value = ID, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Project> calculateTotalValue (@PathVariable Long id, @RequestBody Project obj){
    obj = service.calculateTotalValue(id);
    return ResponseEntity.ok().body(obj);
}

@GetMapping(value = ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Project> findById(@PathVariable Long id) {

        return ResponseEntity.ok().body(service.findById(id));

}
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
            public ResponseEntity<Project> creat(@RequestBody Project obj){


        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path(ID).buildAndExpand(service.creat(obj).getId_project()).toUri();
        return ResponseEntity.created(uri).build();

    }

@DeleteMapping(value = ID, consumes = MediaType.APPLICATION_JSON_VALUE)
public  ResponseEntity<Void> delet(@PathVariable Long id){
    service.delet(id);
    return  ResponseEntity.noContent().build();
}
@GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Project>> findAllProjects(){

        return ResponseEntity.ok().body(service.findAll());
    }

}

