-- V4: arrow_record に不足しているカラムを追加
ALTER TABLE arrow_record
    ADD COLUMN game_match_user_id VARCHAR(26) NULL,
    ADD COLUMN team_match_member_id VARCHAR(26) NULL,
    ADD CONSTRAINT fk_ar_gmu FOREIGN KEY (game_match_user_id) REFERENCES game_match_user(game_match_user_id),
    ADD CONSTRAINT fk_ar_tmm FOREIGN KEY (team_match_member_id) REFERENCES team_match_member(team_match_member_id);
