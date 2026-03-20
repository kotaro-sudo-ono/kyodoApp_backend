-- db/migration/V2__add_record_table.sql

-- record テーブル（的中記録）
CREATE TABLE record (
    record_id   VARCHAR(26)  NOT NULL PRIMARY KEY,
    hit_count   INT          NOT NULL,
    total_shots INT          NOT NULL,
    user_id     VARCHAR(26)  NOT NULL,
    CONSTRAINT fk_record_user FOREIGN KEY (user_id) REFERENCES users(user_id)
);
