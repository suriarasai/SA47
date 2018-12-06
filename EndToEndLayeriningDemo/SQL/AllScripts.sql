create database sample;

use sample;
DROP TABLE IF EXISTS `sample`.`heros`;
CREATE TABLE  `sample`.`heros` (
  `name` varchar(50) NOT NULL,
  `description` varchar(255) default NULL,
  `play` varchar(255) default NULL,
   PRIMARY KEY  (`name`)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `sample`.`employee`;
create table employee(
    employeeid varchar(16) not null primary key,
    name varchar(64),
    managerid varchar(16)
    );
    
DROP TABLE IF EXISTS `sample`.`user`;
CREATE TABLE `sample`.`user` (
  `userid` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `password` VARCHAR(12) NULL,
  `role` VARCHAR(45) NULL,
  `mgrid` INT,
  PRIMARY KEY (`userid`));
ALTER TABLE `sample`.`user` 
ADD INDEX `mgrid_idx` (`mgrid` ASC);
ALTER TABLE `sample`.`user` 
ADD CONSTRAINT `mgrid`
  FOREIGN KEY (`mgrid`)
  REFERENCES `sample`.`user` (`userid`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


 insert into heros values("Mother Theresa","Peace Maker","RealLife");
 insert into heros values("Ghandhi","Freedom Fighter","RealLife");
 insert into heros values("Givera","Free Thinker","RealLife");
 insert into heros values("Jackie Chan","Stunt Guy","Drunken Monk");
 

 insert into employee values("emp-1","Dilbert","emp-3");
 insert into employee values("emp-2","Wally","emp-3");
 insert into employee values("emp-3","Pointy Hair Manager","emp-4");
 insert into employee values("emp-4","Dogbert","");
 insert into employee values("emp-5","Alice","emp-3");
 insert into employee values("emp-6","Catbert","emp-4");
 
 INSERT INTO `sample`.`user` (`name`, `password`, `role`,`mgrid`) VALUES ("dogbert", "dogbert", "manager", null);
INSERT INTO `sample`.`user` (`name`, `password`, `role`,`mgrid`) VALUES ("pointy", "pointy", "manager", 1);
INSERT INTO `sample`.`user` (`name`, `password`, `role`,`mgrid`) VALUES ("alice", "alice", "employee", 2);
INSERT INTO `sample`.`user` (`name`, `password`, `role`,`mgrid`) VALUES ("dilbert", "dilbert", "employee", 2);
INSERT INTO `sample`.`user` (`name`, `password`, `role`,`mgrid`) VALUES ("catbert", "catbert", "employee", 2);
INSERT INTO `sample`.`user` (`name`, `password`, `role`,`mgrid`) VALUES ("ashok", "ashok", "intern", 2);
INSERT INTO `sample`.`user` (`name`, `password`, `role`,`mgrid`) VALUES ("ratbert", "ratbert", "employee", 2);
INSERT INTO `sample`.`user` (`name`, `password`, `role`,`mgrid`) VALUES ("wally", "wally", "employee", 2);
  