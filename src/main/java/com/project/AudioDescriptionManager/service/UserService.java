package com.project.AudioDescriptionManager.service;

import com.project.AudioDescriptionManager.data.model.User;
import com.project.AudioDescriptionManager.repositories.UserRepository;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    User create(User user);
    User update(User user);
    void delete(Long id);
}
