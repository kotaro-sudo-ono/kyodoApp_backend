package com.exmple.kyudo_app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name="match")
public class GameMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID matchId;
    private Date date;
}
