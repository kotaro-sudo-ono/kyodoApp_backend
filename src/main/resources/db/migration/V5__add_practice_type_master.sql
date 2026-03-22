CREATE TABLE practice_type (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO practice_type (name) VALUES ('練習'), ('個人戦'), ('チーム戦');
