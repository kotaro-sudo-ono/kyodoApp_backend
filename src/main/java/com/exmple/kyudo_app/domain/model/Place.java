package com.exmple.kyudo_app.domain.model;

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
    private Integer placeId;
    private String placeName;
    private String placePoint;
    // Placeに関連するゲームマッチ（複数のGameMatch）
    @OneToMany(mappedBy = "place")
    private List<GameMatch> gameMatches;
}
