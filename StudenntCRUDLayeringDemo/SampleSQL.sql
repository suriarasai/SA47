DROP TABLE IF EXISTS sa47.mentor;
DROP TABLE IF EXISTS sa47.student;

CREATE TABLE sa47.mentor (
  id INTEGER NOT NULL,
  mname VARCHAR(45) NULL,
  mnick VARCHAR(45) NULL,
  PRIMARY KEY (id));

CREATE TABLE sa47.student (
  id INTEGER NOT NULL,
  name VARCHAR(45) NULL,
  nick VARCHAR(45) NULL,
  mid INTEGER,
  PRIMARY KEY (id),
  CONSTRAINT MID_FK FOREIGN KEY (mid) REFERENCES sa47.mentor(id));
  
INSERT INTO sa47.mentor (id, mname, mnick) VALUES (1, 'SURIA', 'Naggy');
INSERT INTO sa47.mentor (id, mname, mnick) VALUES (2, 'DEREK', 'Wise');
  
INSERT INTO sa47.student (id, name, nick, mid) VALUES (1, 'ONG HONG DAH', 'Money', 1);
INSERT INTO sa47.student (id, name, nick, mid) VALUES (2, 'PARINITA CHOWDHARY', 'Summary Girl', 1);
INSERT INTO sa47.student (id, name, nick, mid) VALUES (3, 'MAY THAZIN SOE', 'Pleasant', 2);
INSERT INTO sa47.student (id, name, nick, mid) VALUES (4, 'ADAM PNG YEE SOON', 'Sweet & Bitter', 2);