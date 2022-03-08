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



create table FlatServices(
FlatID int,
Gas varchar(29),
Electricity varchar(20),
lift varchar(20),
Generator varchar(20),

constraint service_FlatID_fk foreign key(FlatID) references Flats


);
insert into FlatServices(FlatID, Gas, Electricity, lift, Generator)
values();


drop table FlatDetails
create table FullAddress(
FlatID int,
FlatNo varchar(30),
HouseNo varchar(30),
Road varchar(30),
Block varchar(30),
Thana varchar(30),
Zilla varchar(30),
Division varchar(30),

constraint fullAdd_FlatID_fk foreign key(FlatID) references Flats
);

insert into FullAddress(FlatID, FlatNo, HouseNo, Road, Block, Thana, Zilla, Division)
values();

alter table FlatDetails
add constraint flatDet_FlatID_fk foreign key(FlatID) references Flats;
create table FlatDetails(
FlatID int,
Bed int,
Area decimal(7, 2),
Bath int,
Balcony int,

constraint flatDet_FlatID_fk foreign key(FlatID) references Flats
);

insert into FlatDetails(FlatID, Bed, Area, Bath, Balcony)
values();

create table Flats(
FlatID int identity(1, 1) primary key,
VacancyStatus varchar(30),
MonthlyRent decimal(7, 2)
);
select * from Flats
select * from FlatDetails
select * from FlatServices
select * from FullAddress

insert into FullAddress (FlatID,FlatNo, HouseNo, Road, Block, Thana, Zilla, Division) 
values('43fg', '23', '4', 's', 'a', 's', 'd')

select * from Flats
where vacancy_st = 'vacant'

update Flats
set vacancy_st = 'occupied'
where FlatID = 1;

select * from Flats  where vacancy_st = 'occupied'
update Flats Set MonthlyRent=9000 where FlatID = 1

update FlatServices Set FlatID = '1' where lift= 'no' and Generator='yes';
update FullAddress set FlatID = 1 where Block='fs'

update FlatDetails set FlatID=1 where Bed = 3 and Bath=3

select Generator from FlatServices

create table CurrentRentals (
ResID int,
FlatID int,

constraint fk_resID foreign key(ResID) references RegPeople,
constraint fk_flatID foreign key(FlatID) references Flats
);

--closing agreements
delete from CurrentRentals where FlatID = '';
select * from FlatDetails

--get The last identity value inserted into an identity column 
select SCOPE_IDENTITY()
