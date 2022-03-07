create database aptmsdb;
use aptmsdb;
drop database aptmsdb
create table Flats (
FlatID int Identity(1, 1) primary key,
vacancy_st varchar(30),
MonthlyRent decimal(7, 2)
);

insert into Flats
values('vacant', 1004);

select * from Flats
drop table RegPeople
create table RegPeople (
ResID int Identity(1, 1) primary key,
Name varchar(255),
Phone varchar(13),
Email varchar(40),
DOB date,
NID varchar(30)
);
select * from RegPeople
insert into RegPeople (Name, Phone, Email, DOB, NID)
values();

(Name, Phone, Email, DOB, Hometown, Occupation, Office, NID)


create table FlatServices(
Gas varchar(29),
Electricity varchar(20),
lift varchar(20),
Generator varchar(20)

);


create table FullAddress(
FlatNo varchar(30),
HouseNo varchar(30),
Road varchar(30),
Block varchar(30),
Thana varchar(30),
Zilla varchar(30),
Division varchar(30)
);

create table FlatDetails(
FlatID int,
Bed int,
Area decimal(7, 2),
Bath int,
Balcony int
);