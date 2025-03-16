package com.example.kyudo_app.domain.model;

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
    @Column(name ="recode_id")
    private Long recodeId;
    @Column(name ="hit_count")
    private  Integer hitCount;
    @Column(name ="total_shots")
    private  Integer totalShots;
    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;
}

