CREATE TABLE GameMatch (
    MatchId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    MatchDate DATE,
    PleaseId INT,
    UserId INT,
    FOREIGN KEY (PleaseId) REFERENCES Please(PleaseId),
    FOREIGN KEY (UserId) REFERENCES User(UserId)
);
