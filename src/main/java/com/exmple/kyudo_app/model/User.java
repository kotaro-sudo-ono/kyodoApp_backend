package com.exmple.kyudo_app.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name="User")
public class User {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;
    private String email;
    private String userRole;
    private Long recordId;
    private Long teamMemberId;
    // GameMatchとの多対多のリレーションを定義
    @ManyToMany(mappedBy = "users")  // mappedByはGameMatchクラスのusersフィールドに対応
    private List<GameMatch> gameMatches;  // Userが参加するゲームマッチのリスト
    @OneToMany
    @JoinColumn(name = "recordId", referencedColumnName = "recordId")
    private List<Record> records;
    @OneToMany
    @JoinColumn(name = "teamMemberId", referencedColumnName = "teamMemberId")
    private List<TeamMember> teamMembers;
    @OneToOne
    @JoinColumn(name = "groupId", referencedColumnName = "groupId")
    private BelongingGroup belongingGroup;
}
