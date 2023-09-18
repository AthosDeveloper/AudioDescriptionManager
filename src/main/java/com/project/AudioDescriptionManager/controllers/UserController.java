package com.project.AudioDescriptionManager.controllers;

import com.project.AudioDescriptionManager.data.model.User;
import com.project.AudioDescriptionManager.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
private static final String ID = "/{id}";
    @Autowired
    private UserServiceImpl service;
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }
    @GetMapping(value = ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User>findById(@PathVariable Long id){
        User obj = service.findById(id);
        return  ResponseEntity.ok().body(obj);
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> create(@RequestBody User obj){
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path(ID).buildAndExpand(service.create(obj).getId_user()).toUri();
        return ResponseEntity.created(uri).build();    }
    @DeleteMapping(value = ID, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
   return  ResponseEntity.noContent().build();
    }

}
