package com.example.myjavatodo.repository;

import com.example.myjavatodo.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<TodoEntity, Long> {
}
