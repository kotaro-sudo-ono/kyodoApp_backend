package com.exmple.kyudo_app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name="GameMatch")
public class GameMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matchId;
    private Date matchDate;
    @ManyToMany
    @JoinTable(
        name = "GameMatch_User",  // 中間テーブルの名前
        joinColumns = @JoinColumn(name = "matchId"),  // GameMatchの外部キー
        inverseJoinColumns = @JoinColumn(name = "userId")  // Userの外部キー
    )
    private List<User> users;  // GameMatchに関連する複数のユーザー
    @ManyToOne
    @JoinColumn(name = "PlaceId", referencedColumnName = "PlaceId")
    private Place place;
}
