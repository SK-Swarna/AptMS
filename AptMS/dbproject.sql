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
--drop table FullAddress

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
select * from FullAddress
--closing agreements
delete from CurrentRentals where FlatID = '';
select * from FlatDetails

--get The last identity value inserted into an identity column 
select SCOPE_IDENTITY()
select @@IDENTITY
select * from 
Flats
join FlatDetails 
on Flats.FlatID = FlatDetails.FlatID;
insert into CurrentRentals
values(1, 7)
select * from RegPeople where ResID in (select ResID from CurrentRentals);

select * from RegPeople;

select * from CurrentRentals;

create table Bills(
BillID int identity(1,1) primary key,
FlatID int,
ResID int,
Amount decimal(7,2),
Pay_st varchar(23),
BillMonth varchar(23),


constraint fid_fk foreign key(FlatID) references Flats,
constraint resid_fk foreign key(ResID) references RegPeople );

drop table Bills;
select * from Flats
insert into Flats
values((select 'vacant'), (select 100.0));

delete from Flats where FlatID=8
insert into Bills values(7, (select ResID from CurrentRentals where FlatID = 7), (select MonthlyRent from Flats where FlatID = 7), 'due', 'june')
