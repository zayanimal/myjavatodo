package com.example.myjavatodo.model;

import com.example.myjavatodo.entity.TodoEntity;
import lombok.Data;

public @Data class Todo {
    private Long id;
    private String title;
    private Boolean completed;

    public static Todo toModel(TodoEntity entity) {
        Todo model = new Todo();
        model.setId(entity.getId());
        model.setCompleted(entity.getCompleted());
        model.setTitle(entity.getTitle());

        return model;
    }
}
