package com.example.kyudo_app.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name="game_match")
public class GameMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="match_id")
    private Long matchId;
    @Column(name ="match_date")
    private Date matchDate;

    @ManyToMany
    @JoinTable(
        name = "GameMatch_User",  // 中間テーブルの名前
        joinColumns = @JoinColumn(name = "match_id"),  // GameMatchの外部キー
        inverseJoinColumns = @JoinColumn(name = "user_id")  // Userの外部キー
    )
    private List<User> users;  // GameMatchに関連する複数のユーザー
    @ManyToOne
    @JoinColumn(name = "Place_id", referencedColumnName = "Place_id")
    private Place place;
}
