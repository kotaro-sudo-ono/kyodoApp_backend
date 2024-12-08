CREATE TABLE place (
    place_id INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    place_name VARCHAR(255),
    address VARCHAR(255)
);

CREATE TABLE belonging_group (
    group_id INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL
);

CREATE TABLE users (
    user_id INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    mail_address VARCHAR(30) NOT NULL,
    create_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    lore_id INT(10),
    group_id INT(10) DEFAULT null,
    FOREIGN KEY (group_id) REFERENCES belonging_group(group_id)
);

CREATE TABLE game_match (
    match_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    match_date DATE,
    place_id INT DEFAULT null,
    FOREIGN KEY (place_id) REFERENCES place(place_id)
);

CREATE TABLE game_match_user (
    match_id INT NOT NULL,
    user_id INT NOT NULL,
    FOREIGN KEY (match_id) REFERENCES game_match(match_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE recode (
    recode_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    hit_count INT DEFAULT 0,
    total_shots INT DEFAULT 0,
    create_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE team (
    team_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    team_name VARCHAR(10)
);

CREATE TABLE team_member(
    team_member_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    team_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (team_id) REFERENCES team(team_id)
);
