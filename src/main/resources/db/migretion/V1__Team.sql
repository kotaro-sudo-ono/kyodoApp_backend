CREATE TABLE Team (
    TeamID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    UserId int,
    TeamName char
    FOREIGN KEY (UserId) REFERENCES V1__User(UserId),
);