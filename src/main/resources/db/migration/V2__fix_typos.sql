-- Fix typos in database schema

-- Rename recode table to record
ALTER TABLE recode RENAME TO record;

-- Rename recode_id column to record_id in record table
ALTER TABLE record CHANGE COLUMN recode_id record_id INT NOT NULL AUTO_INCREMENT;

-- Rename lore_id column to role_id in users table
ALTER TABLE users CHANGE COLUMN lore_id role_id INT(10);
