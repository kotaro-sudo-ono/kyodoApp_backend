CREATE TABLE Recode (
    recodeId int(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    UserId int(10),
    HitCount int(10) DEFAULT 0,
    TotalShots int(10) DEFAULT 0,
    MatchId int(10),
    FOREIGN KEY (UserId) REFERENCES V1__User(UserId),
    FOREIGN KEY (MatchId) REFERENCES V1__Match(MatchId)
);
