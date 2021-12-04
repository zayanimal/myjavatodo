package com.example.myjavatodo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
public @Data class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Boolean completed;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
