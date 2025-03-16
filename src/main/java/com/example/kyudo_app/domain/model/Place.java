package com.example.kyudo_app.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name="Place")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="place_id")
    private Integer placeId;
    @Column(name ="place_name")
    private String placeName;
    @Column(name ="address")
    private String placePoint;
    // Placeに関連するゲームマッチ（複数のGameMatch）
    @OneToMany(mappedBy = "place")
    private List<GameMatch> gameMatches;
}
