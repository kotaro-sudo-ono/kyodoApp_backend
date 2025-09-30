-- usersテーブルのmail_addressにユニーク制約を追加

ALTER TABLE users ADD CONSTRAINT uq_users_mail_address UNIQUE (mail_address);