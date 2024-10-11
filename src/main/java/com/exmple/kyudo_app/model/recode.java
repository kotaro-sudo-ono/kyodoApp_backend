package com.exmple.kyudo_app.model;

import jakarta.persistence.*;
import org.springframework.boot.SpringApplication;

import java.util.List;
import java.util.UUID;


@Entity
    @Table(name="recode")
    public class recode {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private UUID recodeId;
        @ManyToMany()
        List<User> userList;


    }

