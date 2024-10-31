CREATE TABLE User(
    UserId int (10) NOT NULL PRIMARY KEY AUTO_INCREMENT
    Name char (10)
    MailAddress char (10)
    CreateAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
    LoreId int (10)
);