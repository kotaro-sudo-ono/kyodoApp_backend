-- db/migration/V1__kyudo_app.sql

-- 0. belonging_groupテーブル
CREATE TABLE belonging_group (
    group_id VARCHAR(26) NOT NULL PRIMARY KEY,
    name VARCHAR(20) NOT NULL
);

-- 1. usersテーブル
CREATE TABLE users (
    user_id VARCHAR(26) NOT NULL PRIMARY KEY,
    name VARCHAR(10),
    mail_address VARCHAR(30) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role_id INT(10),
    group_id VARCHAR(26),
    create_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_user_group FOREIGN KEY (group_id) REFERENCES belonging_group(group_id)
);

-- 2. teamテーブル
CREATE TABLE team (
    team_id VARCHAR(26) NOT NULL PRIMARY KEY,
    team_name VARCHAR(10)
);

-- 3. team_memberテーブル
CREATE TABLE team_member (
    team_member_id VARCHAR(26) NOT NULL PRIMARY KEY,
    team_id VARCHAR(26) NOT NULL,
    user_id VARCHAR(26) NOT NULL,
    CONSTRAINT fk_team_member_team FOREIGN KEY (team_id) REFERENCES team(team_id),
    CONSTRAINT fk_team_member_user FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- 4. placeテーブル
CREATE TABLE place (
    place_id VARCHAR(26) NOT NULL PRIMARY KEY,
    place_name VARCHAR(255),
    address VARCHAR(255)
);

-- 5. game_match（個人戦）
CREATE TABLE game_match (
    match_id VARCHAR(26) NOT NULL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    match_date DATE NOT NULL,
    place_id VARCHAR(26),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_game_match_place FOREIGN KEY (place_id) REFERENCES place(place_id)
);

-- 6. game_match_user（個人戦参加）
CREATE TABLE game_match_user (
    game_match_user_id VARCHAR(26) NOT NULL PRIMARY KEY,
    match_id VARCHAR(26) NOT NULL,
    user_id VARCHAR(26) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_gmu_match FOREIGN KEY (match_id) REFERENCES game_match(match_id),
    CONSTRAINT fk_gmu_user FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- 7. team_match（チーム戦）
CREATE TABLE team_match (
    team_match_id VARCHAR(26) NOT NULL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    match_date DATE NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- 8. team_match_member（チーム戦参加・射順管理）
CREATE TABLE team_match_member (
    team_match_member_id VARCHAR(26) NOT NULL PRIMARY KEY,
    team_match_id VARCHAR(26) NOT NULL,
    user_id VARCHAR(26) NOT NULL,
    order_number INT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_tmm_match FOREIGN KEY (team_match_id) REFERENCES team_match(team_match_id),
    CONSTRAINT fk_tmm_user FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- 9. arrow_record（矢ごとの記録）
CREATE TABLE arrow_record (
    arrow_id VARCHAR(26) NOT NULL PRIMARY KEY,
    game_match_user_id VARCHAR(26),
    team_match_member_id VARCHAR(26),
    arrow_no INT NOT NULL,
    hit BOOLEAN NOT NULL,
    remarks VARCHAR(255),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_ar_gmu FOREIGN KEY (game_match_user_id) REFERENCES game_match_user(game_match_user_id),
    CONSTRAINT fk_ar_tmm FOREIGN KEY (team_match_member_id) REFERENCES team_match_member(team_match_member_id)
    -- game_match_user_id / team_match_member_id はNULL可能（練習用）
);
