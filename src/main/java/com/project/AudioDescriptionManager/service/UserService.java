package com.project.AudioDescriptionManager.service;

import com.project.AudioDescriptionManager.data.DTOs.UserDTO;
import com.project.AudioDescriptionManager.data.model.User;
import com.project.AudioDescriptionManager.repositories.UserRepository;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    User create(UserDTO obj);
    User update(UserDTO obj);
    void delete(Long id);
}
