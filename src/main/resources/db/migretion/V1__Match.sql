CREATE TABLE Match (
    MatchId int(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    MatchDate date,
    PleaseId int(10),
    UserId int(10),
    FOREIGN KEY (PleaseId) REFERENCES V1__Please(PleaseId),
    FOREIGN KEY (UserId) REFERENCES V1__User(UserId)
);
