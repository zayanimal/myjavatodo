package com.example.myjavatodo.service;

import com.example.myjavatodo.entity.UserEntity;
import com.example.myjavatodo.exception.UserAlreadyExistException;
import com.example.myjavatodo.model.User;
import com.example.myjavatodo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("Пользователь с таким именем уже существует");
        }

        return userRepo.save(user);
    }

    public User getOne(Long id) throws NoSuchElementException {
        return User.toModel(userRepo.findById(id).get());
    }

    public Long deleteUser(Long id) {
        userRepo.deleteById(id);
        return id;
    }
}
