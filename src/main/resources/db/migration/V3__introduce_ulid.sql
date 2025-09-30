-- Introduce ULID for all ID columns

-- First, add new ULID columns
ALTER TABLE users ADD COLUMN user_id_new VARCHAR(26);
ALTER TABLE belonging_group ADD COLUMN group_id_new VARCHAR(26);
ALTER TABLE game_match ADD COLUMN match_id_new VARCHAR(26);
ALTER TABLE place ADD COLUMN place_id_new VARCHAR(26);
ALTER TABLE record ADD COLUMN record_id_new VARCHAR(26);
ALTER TABLE team ADD COLUMN team_id_new VARCHAR(26);
ALTER TABLE team_member ADD COLUMN team_member_id_new VARCHAR(26);

-- Generate ULIDs for existing data (using a simple approach with CONCAT and RAND)
-- Note: This is a simplified ULID-like generation for migration purposes
UPDATE users SET user_id_new = CONCAT(
    LPAD(HEX(UNIX_TIMESTAMP(NOW(3)) * 1000), 12, '0'),
    UPPER(SUBSTRING(MD5(CONCAT(user_id, RAND())), 1, 14))
) WHERE user_id_new IS NULL;

UPDATE belonging_group SET group_id_new = CONCAT(
    LPAD(HEX(UNIX_TIMESTAMP(NOW(3)) * 1000), 12, '0'),
    UPPER(SUBSTRING(MD5(CONCAT(group_id, RAND())), 1, 14))
) WHERE group_id_new IS NULL;

UPDATE game_match SET match_id_new = CONCAT(
    LPAD(HEX(UNIX_TIMESTAMP(NOW(3)) * 1000), 12, '0'),
    UPPER(SUBSTRING(MD5(CONCAT(match_id, RAND())), 1, 14))
) WHERE match_id_new IS NULL;

UPDATE place SET place_id_new = CONCAT(
    LPAD(HEX(UNIX_TIMESTAMP(NOW(3)) * 1000), 12, '0'),
    UPPER(SUBSTRING(MD5(CONCAT(place_id, RAND())), 1, 14))
) WHERE place_id_new IS NULL;

UPDATE record SET record_id_new = CONCAT(
    LPAD(HEX(UNIX_TIMESTAMP(NOW(3)) * 1000), 12, '0'),
    UPPER(SUBSTRING(MD5(CONCAT(record_id, RAND())), 1, 14))
) WHERE record_id_new IS NULL;

UPDATE team SET team_id_new = CONCAT(
    LPAD(HEX(UNIX_TIMESTAMP(NOW(3)) * 1000), 12, '0'),
    UPPER(SUBSTRING(MD5(CONCAT(team_id, RAND())), 1, 14))
) WHERE team_id_new IS NULL;

UPDATE team_member SET team_member_id_new = CONCAT(
    LPAD(HEX(UNIX_TIMESTAMP(NOW(3)) * 1000), 12, '0'),
    UPPER(SUBSTRING(MD5(CONCAT(team_member_id, RAND())), 1, 14))
) WHERE team_member_id_new IS NULL;

-- Add foreign key columns with ULID
ALTER TABLE users ADD COLUMN group_id_new VARCHAR(26);
ALTER TABLE game_match ADD COLUMN place_id_new VARCHAR(26);
ALTER TABLE record ADD COLUMN user_id_new VARCHAR(26);
ALTER TABLE team_member ADD COLUMN user_id_new VARCHAR(26);
ALTER TABLE team_member ADD COLUMN team_id_new VARCHAR(26);
ALTER TABLE game_match_user ADD COLUMN match_id_new VARCHAR(26);
ALTER TABLE game_match_user ADD COLUMN user_id_new VARCHAR(26);

-- Update foreign key references
UPDATE users u 
JOIN belonging_group bg ON u.group_id = bg.group_id 
SET u.group_id_new = bg.group_id_new;

UPDATE game_match gm 
JOIN place p ON gm.place_id = p.place_id 
SET gm.place_id_new = p.place_id_new;

UPDATE record r 
JOIN users u ON r.user_id = u.user_id 
SET r.user_id_new = u.user_id_new;

UPDATE team_member tm 
JOIN users u ON tm.user_id = u.user_id 
SET tm.user_id_new = u.user_id_new;

UPDATE team_member tm 
JOIN team t ON tm.team_id = t.team_id 
SET tm.team_id_new = t.team_id_new;

UPDATE game_match_user gmu 
JOIN game_match gm ON gmu.match_id = gm.match_id 
SET gmu.match_id_new = gm.match_id_new;

UPDATE game_match_user gmu 
JOIN users u ON gmu.user_id = u.user_id 
SET gmu.user_id_new = u.user_id_new;

-- Drop old foreign key constraints
ALTER TABLE users DROP FOREIGN KEY users_ibfk_1;
ALTER TABLE game_match DROP FOREIGN KEY game_match_ibfk_1;
ALTER TABLE record DROP FOREIGN KEY record_ibfk_1;
ALTER TABLE team_member DROP FOREIGN KEY team_member_ibfk_1;
ALTER TABLE team_member DROP FOREIGN KEY team_member_ibfk_2;
ALTER TABLE game_match_user DROP FOREIGN KEY game_match_user_ibfk_1;
ALTER TABLE game_match_user DROP FOREIGN KEY game_match_user_ibfk_2;

-- Drop old columns
ALTER TABLE users DROP COLUMN user_id;
ALTER TABLE users DROP COLUMN group_id;
ALTER TABLE belonging_group DROP COLUMN group_id;
ALTER TABLE game_match DROP COLUMN match_id;
ALTER TABLE game_match DROP COLUMN place_id;
ALTER TABLE place DROP COLUMN place_id;
ALTER TABLE record DROP COLUMN record_id;
ALTER TABLE record DROP COLUMN user_id;
ALTER TABLE team DROP COLUMN team_id;
ALTER TABLE team_member DROP COLUMN team_member_id;
ALTER TABLE team_member DROP COLUMN user_id;
ALTER TABLE team_member DROP COLUMN team_id;
ALTER TABLE game_match_user DROP COLUMN match_id;
ALTER TABLE game_match_user DROP COLUMN user_id;

-- Rename new columns to original names
ALTER TABLE users CHANGE COLUMN user_id_new user_id VARCHAR(26) NOT NULL;
ALTER TABLE users CHANGE COLUMN group_id_new group_id VARCHAR(26);
ALTER TABLE belonging_group CHANGE COLUMN group_id_new group_id VARCHAR(26) NOT NULL;
ALTER TABLE game_match CHANGE COLUMN match_id_new match_id VARCHAR(26) NOT NULL;
ALTER TABLE game_match CHANGE COLUMN place_id_new place_id VARCHAR(26);
ALTER TABLE place CHANGE COLUMN place_id_new place_id VARCHAR(26) NOT NULL;
ALTER TABLE record CHANGE COLUMN record_id_new record_id VARCHAR(26) NOT NULL;
ALTER TABLE record CHANGE COLUMN user_id_new user_id VARCHAR(26);
ALTER TABLE team CHANGE COLUMN team_id_new team_id VARCHAR(26) NOT NULL;
ALTER TABLE team_member CHANGE COLUMN team_member_id_new team_member_id VARCHAR(26) NOT NULL;
ALTER TABLE team_member CHANGE COLUMN user_id_new user_id VARCHAR(26) NOT NULL;
ALTER TABLE team_member CHANGE COLUMN team_id_new team_id VARCHAR(26) NOT NULL;
ALTER TABLE game_match_user CHANGE COLUMN match_id_new match_id VARCHAR(26) NOT NULL;
ALTER TABLE game_match_user CHANGE COLUMN user_id_new user_id VARCHAR(26) NOT NULL;

-- Add primary key constraints
ALTER TABLE users ADD PRIMARY KEY (user_id);
ALTER TABLE belonging_group ADD PRIMARY KEY (group_id);
ALTER TABLE game_match ADD PRIMARY KEY (match_id);
ALTER TABLE place ADD PRIMARY KEY (place_id);
ALTER TABLE record ADD PRIMARY KEY (record_id);
ALTER TABLE team ADD PRIMARY KEY (team_id);
ALTER TABLE team_member ADD PRIMARY KEY (team_member_id);

-- Add foreign key constraints
ALTER TABLE users ADD CONSTRAINT fk_users_group FOREIGN KEY (group_id) REFERENCES belonging_group(group_id);
ALTER TABLE game_match ADD CONSTRAINT fk_game_match_place FOREIGN KEY (place_id) REFERENCES place(place_id);
ALTER TABLE record ADD CONSTRAINT fk_record_user FOREIGN KEY (user_id) REFERENCES users(user_id);
ALTER TABLE team_member ADD CONSTRAINT fk_team_member_user FOREIGN KEY (user_id) REFERENCES users(user_id);
ALTER TABLE team_member ADD CONSTRAINT fk_team_member_team FOREIGN KEY (team_id) REFERENCES team(team_id);
ALTER TABLE game_match_user ADD CONSTRAINT fk_game_match_user_match FOREIGN KEY (match_id) REFERENCES game_match(match_id);
ALTER TABLE game_match_user ADD CONSTRAINT fk_game_match_user_user FOREIGN KEY (user_id) REFERENCES users(user_id);
