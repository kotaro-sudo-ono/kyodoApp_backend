-- V3: arrow_record拡張 + record拡張

ALTER TABLE arrow_record ADD COLUMN position_x DOUBLE;
ALTER TABLE arrow_record ADD COLUMN position_y DOUBLE;
ALTER TABLE arrow_record ADD COLUMN record_id VARCHAR(26);
ALTER TABLE arrow_record ADD CONSTRAINT fk_ar_record
    FOREIGN KEY (record_id) REFERENCES record(record_id);

ALTER TABLE record ADD COLUMN practice_date DATETIME;
ALTER TABLE record ADD COLUMN practice_type_id INT;
