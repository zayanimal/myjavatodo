package com.example.myjavatodo.model;

import com.example.myjavatodo.entity.UserEntity;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

public @Data class User {
    private Long id;
    private String username;
    private List<Todo> todos;

    public static User toModel(UserEntity entity) {
        User model = new User();
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        model.setTodos(entity.getTodos().stream().map(Todo::toModel).collect(Collectors.toList()));
        return model;
    }
}
