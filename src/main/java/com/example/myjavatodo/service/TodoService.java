package com.example.myjavatodo.service;

import com.example.myjavatodo.entity.TodoEntity;
import com.example.myjavatodo.entity.UserEntity;
import com.example.myjavatodo.model.Todo;
import com.example.myjavatodo.repository.TodoRepo;
import com.example.myjavatodo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;

    @Autowired
    private UserRepo userRepo;

    public Todo createTodo(TodoEntity todo, Long userId) {
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);

        return Todo.toModel(todoRepo.save(todo));
    }

    public Todo completeTodo(Long id) {
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted());

        return Todo.toModel(todoRepo.save(todo));
    }
}
