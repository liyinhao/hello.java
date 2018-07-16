--
--    Copyright ${license.git.copyrightYears} the original author or authors.
--
--    Licensed under the Apache License, Version 2.0 (the "License");
--    you may not use this file except in compliance with the License.
--    You may obtain a copy of the License at
--
--       http://www.apache.org/licenses/LICENSE-2.0
--
--    Unless required by applicable law or agreed to in writing, software
--    distributed under the License is distributed on an "AS IS" BASIS,
--    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
--    See the License for the specific language governing permissions and
--    limitations under the License.
--

drop table if exists city;
drop table if exists hotel;

create table city (id int primary key auto_increment, name varchar, state varchar, country varchar);
create table hotel (city int, name varchar, address varchar, zip varchar);

--create table city (id int primary key auto_increment, name varchar(50), state varchar(50), country varchar(50));
--create table hotel (city int, name varchar(50), address varchar(50), zip varchar(50));

insert into city (name, state, country) values ('NewYork', 'CA', 'US');
insert into city (name, state, country) values ('Los Angeles', 'CA', 'US');
insert into hotel(city, name, address, zip) values (1, 'Conrad Treasury Place', 'William & George Streets', '4001');
