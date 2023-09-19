package com.project.AudioDescriptionManager.controllers;

import com.project.AudioDescriptionManager.data.DTOs.UserDTO;
import com.project.AudioDescriptionManager.data.model.User;
import com.project.AudioDescriptionManager.service.UserServiceImpl;
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

@Api(value = "UserEndpoint", description = "UserEndpoint rest para usuários")

@RestController
@RequestMapping("/api/users")
public class UserController {
private static final String ID = "/{id}";
    @Autowired
    private UserServiceImpl service;
    @Autowired
    ModelMapper mapper;
@ApiOperation(value = "EncontrarTodosUsuarios")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDTO>> findAll(){
        return ResponseEntity.ok().body(service.findAll().stream().map(x -> mapper.map(x, UserDTO.class)).collect(Collectors.toList()));
    }
    @ApiOperation(value = "EncontrarUsuarioEspecificoPorId")
    @GetMapping(value = ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User>findById(@PathVariable Long id){
        User obj = service.findById(id);
        return  ResponseEntity.ok().body(obj);
    }
    @ApiOperation(value = "CriarNovoUsuario")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO obj){
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path(ID).buildAndExpand(service.create(obj).getId_user()).toUri();
        return ResponseEntity.created(uri).build();    }
    @ApiOperation("DeletarUsuario")
    @DeleteMapping(value = ID, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
   return  ResponseEntity.noContent().build();
    }

}
