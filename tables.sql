create database foodlover;

use foodlover;


create table origin(
id INT NOT NULL AUTO_INCREMENT,
originame VARCHAR(100),
PRIMARY KEY (id)
);


insert into origin values(1,'Malleshwaram');
insert into origin values(2,'Vincent City');
insert into origin values(3,'Tokyo');
insert into origin values(4,'Edmond');



CREATE TABLE destination(
id INT NOT NULL AUTO_INCREMENT,
thedestination VARCHAR(100),
originid int,
FOREIGN KEY (originid) REFERENCES  origin(id),
PRIMARY KEY (id)
);



insert into destination values(1, 'New York',4);
insert into destination values(2, 'London',2);
insert into destination values(3,'New Delhi',1);
insert into destination values(4, 'Beijing',3);
insert into destination values(5, 'Miami',4);
insert into destination values(6, 'Toronto',4);
insert into destination values(7, 'Culcutta',1);


CREATE TABLE restaurant
(
id int NOT NULL AUTO_INCREMENT,
restname varchar(256),
rating double,
destinationid int,
 PRIMARY KEY (id),
 FOREIGN KEY (destinationid) REFERENCES  destination(id)
);

insert into restaurant values(1,'China Town', 3.5, 1);
insert into restaurant values(2,'Paragon', 4.5, 2);
insert into restaurant values(3,'WaterFall', 2.5,3);
insert into restaurant values(4,'Liverpool', 2.5,3);
insert into restaurant values(5,'FastFood', 4.5,4);
insert into restaurant values(6,'Manchester', 4.5, 4);
insert into restaurant values(7,'Paragon', 4.5, 3);
insert into restaurant values(8,'WaterFall', 2.5,3);

CREATE TABLE food
(
id INT NOT NULL AUTO_INCREMENT,
foodname VARCHAR(100), 
price int,
restid int,
PRIMARY KEY (id),
FOREIGN KEY (restid) REFERENCES  restaurant(id)
);


insert into food values(1, 'Chilli Chicken', 345, 6);
insert into food values(2, 'Dosa', 50 , 3);
insert into food values(3, 'Veg Biriyani', 100 , 3);
insert into food values(4, 'Broasted Chicken', 100 , 6);
insert into food values(5, 'Noodles', 120, 2);
insert into food values(6, 'Dragon Chicken', 120, 1);
insert into food values(7, 'Desi Biriyani', 100 , 3);
insert into food values(8, 'Dessert', 100 , 2);



CREATE TABLE booking
(
id INT NOT NULL AUTO_INCREMENT,
username varchar(100),
foodname VARCHAR(100), 
restname VARCHAR(100),
PRIMARY KEY (id)
);

insert into booking values (1, 'mosses.john','Noodles', 'Paragon');
insert into booking values (2, 'Tony.louis','Chilli Chicken', 'Manchester');
insert into booking values (3, 'mama.mia','Dosa', 'WaterFall');
insert into booking values (4, 'mama.mia','Veg Biriyani', 'WaterFall');
insert into booking values (5, 'mosses.john','Broasted Chicken', 'Manchester');
insert into booking values (6, 'mosses.john','Dragon Chicken', 'China Town');
insert into booking values (7, 'Tony.louis','Desi Biriyani', 'WaterFall');
insert into booking values (8, 'mama.mia','Dessert', 'Paragon');
insert into booking values (10, 'mosses.john','Noodles', 'Paragon');

