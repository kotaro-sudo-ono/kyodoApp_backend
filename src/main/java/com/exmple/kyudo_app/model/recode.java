package com.exmple.kyudo_app.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;


@Entity
    @Table(name="recode")
    public class Recode {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private UUID recodeId;
        private Long UserId;
        private int HitCount;
        private  int TotalShots;
        private int MatchId;
        @ManyToMany()
        List<User> userList;


    }

