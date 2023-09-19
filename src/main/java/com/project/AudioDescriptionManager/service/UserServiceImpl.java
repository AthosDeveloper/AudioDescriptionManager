package com.project.AudioDescriptionManager.service;

import com.project.AudioDescriptionManager.data.DTOs.UserDTO;
import com.project.AudioDescriptionManager.data.model.User;
import com.project.AudioDescriptionManager.repositories.UserRepository;
import com.project.AudioDescriptionManager.service.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;
@Autowired
private ModelMapper mapper;
    @Override
    public List<User> findAll() {
   return  repository.findAll();
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("objeto não encontrado"));
    }

    @Override
    public User create(UserDTO obj) {
        return repository.save(mapper.map(obj, User.class));

    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }



    @Override
    public User update (UserDTO obj) {
        return repository.save(mapper.map(obj, User.class));
    }


}


