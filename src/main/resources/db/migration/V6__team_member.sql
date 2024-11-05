CREATE TABLE TeamMember (
    TeamMemberID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    UserId INT,
    TeamID INT,
    FOREIGN KEY (UserId) REFERENCES User(UserId),
    FOREIGN KEY (TeamID) REFERENCES Team(TeamID)
);
