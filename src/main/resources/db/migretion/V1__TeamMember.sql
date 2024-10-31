CREATE TABLE Recode (
    RecodeID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    UseId int ,
    TeamID int,
    FOREIGN KEY (UserId) REFERENCES V1__User(UserId),
    FOREIGN KEY (v) REFERENCES V1__Team(TeamID)
);