use sample;
drop table if exists student_course;
drop table if exists userdb;
drop table if exists enrolment;
drop table if exists course;
drop table if exists student;
drop table if exists lecturer;

CREATE TABLE sample.userdb (
  id BIGINT(20) NOT NULL,
  username VARCHAR(45) NULL,
  email VARCHAR (45) NULL,
  address VARCHAR (45) NULL,
  PRIMARY KEY (id));

CREATE TABLE sample.student (
  nric VARCHAR(9) NOT NULL,
  nick_name VARCHAR(45) NULL,
  mark INT NULL,
  name VARCHAR(45) NULL,
  dob DATE NULL,
  phone_number INT NULL,
  email VARCHAR(45) NULL,
  address VARCHAR(45) NULL,
  user_name VARCHAR(45) NULL,
  password VARCHAR(45) NULL,
  PRIMARY KEY (nric));
  
 CREATE TABLE sample.lecturer (
  nric VARCHAR(9) NOT NULL,
  name VARCHAR(45) NULL,
  nick_name VARCHAR(45) NULL,
  phone_number INT NULL,
  email VARCHAR(45) NULL,
  address VARCHAR(45) NULL,
  user_name VARCHAR(45) NULL,
  password VARCHAR(45) NULL,
  PRIMARY KEY (nric));
  
  CREATE TABLE sample.course (
  cid INT NOT NULL AUTO_INCREMENT,
  course_code VARCHAR(45) NULL,
  course_name VARCHAR(45) NULL,
  start_date DATE NULL,
  end_date DATE NULL,
  credit INT NULL,
  lnric VARCHAR(9) NULL,
  PRIMARY KEY (cid),
  INDEX nric_idx (lnric ASC) VISIBLE,
  CONSTRAINT nric
    FOREIGN KEY (lnric)
    REFERENCES sample.lecturer (nric)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
  
 CREATE TABLE sample.enrolment (
    eid INT NOT NULL AUTO_INCREMENT, 
   scid INT NOT NULL,
  snric VARCHAR(9) NOT NULL,
  grade VARCHAR(2) NULL,
   mark INT NULL,
   PRIMARY KEY (eid),
  INDEX snric_idx (snric ASC) VISIBLE,
  CONSTRAINT scid
    FOREIGN KEY (scid)
    REFERENCES sample.course (cid)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT snric
    FOREIGN KEY (snric)
    REFERENCES sample.student (nric)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION  
 );

INSERT INTO sample.userdb (id, username, email, address) VALUES (1, "tom", "tom@nus.edu.sg", "Tom's Apartment @ Cartoon Network");
INSERT INTO sample.userdb (id, username, email, address) VALUES (2, "jerry", "jerry@nus.edu.sg", "Tom's Apartment @ Cartoon Network");
INSERT INTO sample.userdb (id, username, email, address) VALUES (3, "nibbles", "nibbles@nus.edu.sg", "Tom's Apartment @ Cartoon Network");

INSERT INTO sample.student (nric, nick_name, mark, name, dob, phone_number, email, address, user_name, password) VALUES ("S1234567A", "Interactive", 78, "ONG HONG DAH", '1990-12-12', 12345, "id1@u.nus.edu", "25 Heng Mui Keng Terrace", "student1", "password");
INSERT INTO sample.student (nric, nick_name, mark, name, dob, phone_number, email, address, user_name, password) VALUES ("S1234567B", "Helpful", 88, "PARINITA CHOWDHARY", '1990-12-12', 12345, "id2@u.nus.edu", "25 Heng Mui Keng Terrace", "student2", "password");
INSERT INTO sample.student (nric, nick_name, mark, name, dob, phone_number, email, address, user_name, password) VALUES ("S1234567C", "ClassRep", 98, "HAOMING GUO", '1990-12-12', 12345, "id3@u.nus.edu", "25 Heng Mui Keng Terrace", "student3", "password");
INSERT INTO sample.student (nric, nick_name, mark, name, dob, phone_number, email, address, user_name, password) VALUES ("S1234567D", "Gracious", 88, "ADAM PNG YEE SOON", '1990-12-12', 12345, "id4@u.nus.edu", "25 Heng Mui Keng Terrace", "student4", "password");
INSERT INTO sample.student (nric, nick_name, mark, name, dob, phone_number, email, address, user_name, password) VALUES ("S1234567E", "Suggester", 78, "GERALDINE TAY HUI LING", '1990-12-12', 12345, "id5@u.nus.edu", "25 Heng Mui Keng Terrace", "student5", "password");
INSERT INTO sample.student (nric, nick_name, mark, name, dob, phone_number, email, address, user_name, password) VALUES ("S1234567F", "Clarifies", 68, "HANA NORDIN", '1990-12-12', 12345678, "id6@u.nus.edu", "25 Heng Mui Keng Terrace", "student6", "password");

INSERT INTO sample.lecturer (nric, name, nick_name, phone_number, email, address, user_name, password) VALUES ("S2345678A", "Suria", "Silly", 123456, "suria@nus.edu.sg", "19 Heng Mui Keng Terrace", "suria", "password");
INSERT INTO sample.lecturer (nric, name, nick_name, phone_number, email, address, user_name, password) VALUES ("S2345678B", "Shifu", "Master Shifu", 123457, "shifu@nus.edu.sg", "19 Heng Mui Keng Terrace", "shifu", "password");
INSERT INTO sample.lecturer (nric, name, nick_name, phone_number, email, address, user_name, password) VALUES ("S2345678C", "Po", "Black Eye", 123458, "po@nus.edu.sg", "19 Heng Mui Keng Terrace", "po", "password");
INSERT INTO sample.lecturer (nric, name, nick_name, phone_number, email, address, user_name, password) VALUES ("S2345678D", "Tigress", "Fast", 123459, "tiger@nus.edu.sg", "19 Heng Mui Keng Terrace", "tigress", "password");
INSERT INTO sample.lecturer (nric, name, nick_name, phone_number, email, address, user_name, password) VALUES ("S2345678E", "Oogway", "Slow", 123460, "oogwat@nus.edu.sg", "19 Heng Mui Keng Terrace", "oogway", "password");


INSERT INTO sample.course (course_code, course_name, start_date, end_date, credit, lnric) VALUES ("JAVA-18-1", "Java Web and Spring Framework", "2018-11-20", "2018-12-20", 4, "S2345678A");
INSERT INTO sample.course (course_code, course_name, start_date, end_date, credit, lnric) VALUES ("BEAD-18-1", "Big Data Engineering", "2018-1-20", "2018-6-20", 5, "S2345678A");
INSERT INTO sample.course (course_code, course_name, start_date, end_date, credit, lnric) VALUES ("CLOUD-18-1", "Cloud Computing", "2018-4-20", "2018-7-20", 5, "S2345678A");
INSERT INTO sample.course (course_code, course_name, start_date, end_date, credit, lnric) VALUES ("PLAT-18-1", "Platform Engineer", "2019-1-20", "2019-6-20", 5, "S2345678A");
INSERT INTO sample.course (course_code, course_name, start_date, end_date, credit, lnric) VALUES ("LIFE-18-1", "Life Philoshophy", "2018-1-20", "2018-6-20", 4, "S2345678B");
INSERT INTO sample.course (course_code, course_name, start_date, end_date, credit, lnric) VALUES ("ASTRO-18-1", "Astrophysics", "2018-1-20", "2018-6-20", 4, "S2345678E");


INSERT INTO sample.enrolment (scid, snric, grade, mark) VALUES (1, "S1234567A", "A", 78);
INSERT INTO sample.enrolment (scid, snric, grade, mark) VALUES (1, "S1234567B", "A+", 87);
INSERT INTO sample.enrolment (scid, snric, grade, mark) VALUES (1, "S1234567C", "A+", 88);
INSERT INTO sample.enrolment (scid, snric, grade, mark) VALUES (1, "S1234567D", "A", 76);
INSERT INTO sample.enrolment (scid, snric, grade, mark) VALUES (1, "S1234567E", "A+", 83);
INSERT INTO sample.enrolment (scid, snric, grade, mark) VALUES (1, "S1234567F", "A", 80);

INSERT INTO sample.enrolment (scid, snric, grade, mark) VALUES (5, "S1234567A", "A", 78);
INSERT INTO sample.enrolment (scid, snric, grade, mark) VALUES (5, "S1234567B", "A+", 87);
INSERT INTO sample.enrolment (scid, snric, grade, mark) VALUES (5, "S1234567C", "A+", 88);
INSERT INTO sample.enrolment (scid, snric, grade, mark) VALUES (5, "S1234567D", "A", 76);
INSERT INTO sample.enrolment (scid, snric, grade, mark) VALUES (5, "S1234567E", "A+", 83);
INSERT INTO sample.enrolment (scid, snric, grade, mark) VALUES (5, "S1234567F", "A", 80);

INSERT INTO sample.enrolment (scid, snric, grade, mark) VALUES (6, "S1234567A", "A", 78);
INSERT INTO sample.enrolment (scid, snric, grade, mark) VALUES (6, "S1234567B", "A+", 87);
INSERT INTO sample.enrolment (scid, snric, grade, mark) VALUES (6, "S1234567C", "A+", 88);
INSERT INTO sample.enrolment (scid, snric, grade, mark) VALUES (6, "S1234567D", "A", 79);
INSERT INTO sample.enrolment (scid, snric, grade, mark) VALUES (6, "S1234567E", "A+", 83);
INSERT INTO sample.enrolment (scid, snric, grade, mark) VALUES (6, "S1234567F", "A", 77);  



