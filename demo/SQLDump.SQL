CREATE TABLE 'sa46'.'student' (
  'nric' VARCHAR(9) NOT NULL,
  'nick_name' VARCHAR(45) NULL,
  'mark' INT NULL,
  'name' VARCHAR(45) NULL,
  'dob' DATE NULL,
  'phone_number' INT NULL,
  'email' VARCHAR(45) NULL,
  'address' VARCHAR(45) NULL,
  'user_name' VARCHAR(45) NULL,
  'password' VARCHAR(45) NULL,
  PRIMARY KEY ('nric'));
 CREATE TABLE 'sa46'.'lecturer' (
  'nric' VARCHAR(9) NOT NULL,
  'name' VARCHAR(45) NULL,
  'nick_name' VARCHAR(45) NULL,
  'phone_number' INT NULL,
  'email' VARCHAR(45) NULL,
  'address' VARCHAR(45) NULL,
  'user_name' VARCHAR(45) NULL,
  'password' VARCHAR(45) NULL,
  PRIMARY KEY ('nric'));
  CREATE TABLE 'sa46'.'course' (
  'cid' INT NOT NULL AUTO_INCREMENT,
  'course_code' VARCHAR(45) NULL,
  'course_name' VARCHAR(45) NULL,
  'start_date' DATE NULL,
  'end_date' DATE NULL,
  'credit' INT NULL,
  'lnric' VARCHAR(9) NULL,
  PRIMARY KEY ('cid'),
  INDEX 'nric_idx' ('lnric' ASC) VISIBLE,
  CONSTRAINT 'nric'
    FOREIGN KEY ('lnric')
    REFERENCES 'sa46'.'lecturer' ('nric')
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
   CREATE TABLE 'sa46'.'student_course' (
  'ccid' INT NOT NULL,
  'snric' VARCHAR(9) NOT NULL,
  PRIMARY KEY ('ccid', 'snric'),
  INDEX 'nric_idx' ('snric' ASC) VISIBLE,
  CONSTRAINT 'ccid'
    FOREIGN KEY ('ccid')
    REFERENCES 'sa46'.'course' ('cid')
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT 'snric'
    FOREIGN KEY ('snric')
    REFERENCES 'sa46'.'student' ('nric')
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

INSERT INTO sa46.student (nric, nick_name, mark, name, dob, phone_number, email, address, user_name, password) VALUES ("S1234567A", "Interactive", 78, "CHUA KHIONG YANG", '1990-12-12', 12345, "id1@u.nus.edu", "25 Heng Mui Keng Terrace", "student1", "password");
INSERT INTO sa46.student (nric, nick_name, mark, name, dob, phone_number, email, address, user_name, password) VALUES ("S1234567B", "Helpful", 88, "FONG YONGEN, JOEL", '1990-12-12', 12345, "id2@u.nus.edu", "25 Heng Mui Keng Terrace", "student2", "password");
INSERT INTO sa46.student (nric, nick_name, mark, name, dob, phone_number, email, address, user_name, password) VALUES ("S1234567C", "ClassRep", 98, "LIM HOE KIT", '1990-12-12', 12345, "id3@u.nus.edu", "25 Heng Mui Keng Terrace", "student3", "password");
INSERT INTO sa46.student (nric, nick_name, mark, name, dob, phone_number, email, address, user_name, password) VALUES ("S1234567D", "Gracious", 88, "NATHAN KHOO LI WEI", '1990-12-12', 12345, "id4@u.nus.edu", "25 Heng Mui Keng Terrace", "student4", "password");
INSERT INTO sa46.student (nric, nick_name, mark, name, dob, phone_number, email, address, user_name, password) VALUES ("S1234567E", "Suggester", 78, "SHANMUGAM MANIKANDAN", '1990-12-12', 12345, "id5@u.nus.edu", "25 Heng Mui Keng Terrace", "student5", "password");
INSERT INTO sa46.student (nric, nick_name, mark, name, dob, phone_number, email, address, user_name, password) VALUES ("S1234567F", "Clarifies", 68, "WANG SHIJUN", '1990-12-12', 12345678, "id6@u.nus.edu", "25 Heng Mui Keng Terrace", "student6", "password");




   
