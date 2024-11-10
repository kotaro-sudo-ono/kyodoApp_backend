package com.exmple.kyudo_app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="record")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recodeId;
    private  Integer hitCount;
    private  Integer totalShots;
    @OneToOne()
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;
}

