
drop table if exists city;
drop table if exists hotel;

CREATE TABLE city (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  state VARCHAR(45) NOT NULL,
  country VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));


CREATE TABLE hotel (
  city INT NOT NULL,
  name VARCHAR(45) NOT NULL,
  address VARCHAR(45) NOT NULL,
  zip VARCHAR(45) NOT NULL);

insert into city (name, state, country) values ('NewYork', 'CA', 'US');
insert into city (name, state, country) values ('Los Angeles', 'CA', 'US');
insert into hotel(city, name, address, zip) values (1, 'Conrad Treasury Place', 'William & George Streets', '4001');
