GO
use HealthyClub
GO






-- create table User
-- (
-- 	Name nvarchar(10) not null,
-- 	ID int not null AUTO_INCREMENT primary key,
--     Email nvarchar(50) not null,
--     Gender char(1) not null check(Gender in ('M','F')),
-- 	Age int not null check(Age>=0 and Age<=120),
--     PhoneNumber nvarchar(11),
--     Password nvarchar(20) not null
-- );


insert into [User] values ('Von','von@xxx.com','M',28,'2333','p@ssw0rd');
insert into [User] values ('Gary','gary@xxx.com','M',24,'2333','p@ssw0rd');
insert into [User] values ('Ann','ann@xxx.com','F',19,'2333','p@ssw0rd');
insert into [User] values ('Peter','peter@xxx.com','M',26,'2333','p@ssw0rd');


-- create table MemberShipCardLevel
-- (
-- 	ID int not null auto_increment primary key,
--     LevelName nvarchar(20) not null
-- );


insert into MemberShipCardLevel values ('铜牌会员');
insert into MemberShipCardLevel values ('银牌会员');
insert into MemberShipCardLevel values ('金牌会员');
insert into MemberShipCardLevel values ('蜜汁会员');



-- create table MemberShipCard
-- (
-- ID int not null auto_increment primary key,
-- Fund decimal(10,2) not null check(Fund>=0),
-- MemberShipLevel int not null,
-- UserID int not null,
-- FOREIGN KEY(MemberShipLevel) references MemberShipCardLevel(ID),
-- Foreign key(UserID) references User(ID)
-- );

insert into MemberShipCard values (2567.5,2,1);
insert into MemberShipCard values (23246.23,3,2);
insert into MemberShipCard values (5465.7,1,3);
insert into MemberShipCard values (7985,1,4);



-- create table HealthyDocument
-- (
-- ID int not null auto_increment primary key,
-- UserID int not null,
-- Notes nvarchar(200) not null,
-- foreign key(UserID) references User(ID)

-- );

insert into HealthyDocument values (1,'HealthyForever');
insert into HealthyDocument values (2,'HealthyForever');
insert into HealthyDocument values (3,'VeryHealthy');
insert into HealthyDocument values (4,'ABitHealthy');



-- create table Employee
-- (
-- 	ID int not null AUTO_INCREMENT primary key,
--     Email nvarchar(50) not null,
--     Gender char(1) not null check(Gender in ('M','F')),
-- 	Age int not null check(Age>=0 and Age<=120),
--     PhoneNumber nvarchar(11),
--     JobTitle nvarchar(10) not null,
--     Name nvarchar(10) not null,
--     Password nvarchar(20) not null,
--     Authority int not null check(Authority in (0,1,2))
-- );


insert into Employee values ('tank@xxx.com','M',25,'23333333','Big Boss','Tank','p@ssw0rd',0);
insert into Employee values ('spitter@xxx.com','F',21,'13524355','cashier','Spitter','p@ssw0rd',1);
insert into Employee values ('hunter@xxx.com','M',24,'23333333','Technician','hunter','p@ssw0rd',2);
insert into Employee values ('boomer@xxx.com','M',10,'23333333','Technician','boomer','p@ssw0rd',2);
insert into Employee values ('jockey@xxx.com','M',26,'23333333','Technician','jockey','p@ssw0rd',2);


-- create table Service
-- (
-- 	ID int not null auto_increment primary key,
--     Name nvarchar(20) not null
-- );


insert into Service values('推背');
insert into Service values('足疗');
insert into Service values('按摩');
insert into Service values('推拿');
insert into Service values('你懂的( ͡° ͜ʖ ͡°)');


-- create table Technician
-- (
-- 	ID int not null auto_increment primary key,
--     EmployeeID int not null,
--     foreign key(EmployeeID) references Employee(ID)
-- );


insert into Technician values(3);
insert into Technician values(4);
insert into Technician values(5);
insert into Technician values(2);


-- create table DedicatedService
-- (
--  ID int not null auto_increment primary key,
--  TechnicianID int not null,
--  ServiceID int not null,
--  Price decimal(10,2) not null check(Price>0),
--  Foreign key (ServiceID) references Service(ID),
--  Foreign key (TechnicianID) references Technician(ID)

-- );


insert into DedicatedService values(1,1,23.3);
insert into DedicatedService values(1,2,145);
insert into DedicatedService values(1,3,4);

insert into DedicatedService values(2,2,195);
insert into DedicatedService values(2,4,163);
insert into DedicatedService values(2,3,16);

insert into DedicatedService values(3,1,25);
insert into DedicatedService values(3,4,150);
insert into DedicatedService values(3,3,4);

insert into DedicatedService values(4,1,52.5);
insert into DedicatedService values(4,2,14.5);
insert into DedicatedService values(4,5,43);




-- create table DaylyAvailibility
-- (
-- ID int not null auto_increment primary key,
-- StartTime time not null check(StartTime between '00:00:00' and '24:00:00'),
-- EndTime time  not null,
-- TechnicianID int  not null,
-- DayOfWeek int  not null check(DayOfWeek between 1 and 7),
-- foreign key (TechnicianID) references Technician(ID)
-- );



insert into DaylyAvailibility values('08:00:00','16:00:00',1,1);
insert into DaylyAvailibility values('08:00:00','16:00:00',1,2);
insert into DaylyAvailibility values('08:00:00','16:00:00',1,3);
insert into DaylyAvailibility values('08:00:00','16:00:00',1,4);
insert into DaylyAvailibility values('08:00:00','16:00:00',1,5);





insert into DaylyAvailibility values('08:00:00','16:00:00',2,1);
insert into DaylyAvailibility values('08:00:00','16:00:00',2,2);
insert into DaylyAvailibility values('08:00:00','16:00:00',2,3);
insert into DaylyAvailibility values('08:00:00','16:00:00',2,4);
insert into DaylyAvailibility values('08:00:00','16:00:00',2,5);


insert into DaylyAvailibility values('08:00:00','16:00:00',3,1);
insert into DaylyAvailibility values('08:00:00','16:00:00',3,2);
insert into DaylyAvailibility values('08:00:00','16:00:00',3,3);
insert into DaylyAvailibility values('08:00:00','16:00:00',3,4);
insert into DaylyAvailibility values('08:00:00','16:00:00',3,5);


insert into DaylyAvailibility values('08:00:00','16:00:00',4,1);
insert into DaylyAvailibility values('08:00:00','16:00:00',4,2);
insert into DaylyAvailibility values('08:00:00','16:00:00',4,3);
insert into DaylyAvailibility values('08:00:00','16:00:00',4,4);
insert into DaylyAvailibility values('08:00:00','16:00:00',4,5);




-- create table PreorderTicket
-- (
-- ID int  not null auto_increment primary key,
-- OrderedTime DateTime not null,
-- Status nvarchar(10) check(Status in ('Placed','Cancelled')),
-- ReviewStatus nvarchar(20) check(ReviewStatus in ('Passed','Failed','NotReviewed')),
-- MemberShipCardID int not null,
-- DedicatedServiceID int not null,
-- foreign key(MemberShipCardID) references MemberShipCard(ID),
-- foreign key(DedicatedServiceID) references DedicatedService(ID)

-- );

insert into PreorderTicket values(0,'2016-10-10 11:00','2016-10-10 12:00','Placed','Failed',1,4);
insert into PreorderTicket values(0,'2016-11-10 12:00','2016-11-11 16:00','Placed','Passed',2,5);
insert into PreorderTicket values(0,'2016-10-8 12:00','2015-10-10 13:00','Cancelled','NotReviewed',2,5);
insert into PreorderTicket values(0,'2016-3-10 11:59','2016-3-10 12:00','Placed','Passed',2,7);


-- create table ServiceTicket
-- (
-- ID int  not null auto_increment primary key,
-- OrderedTime DateTime not null ,
-- Status nvarchar(10) check(Status in ('Placed','Cancelled')),
-- MemberShipCardID int not null,
-- DedicatedServiceID int not null,
-- foreign key(MemberShipCardID) references MemberShipCard(ID),
-- foreign key(DedicatedServiceID) references DedicatedService(ID)

-- );


insert into ServiceTicket values('2016-10-10 12:00','Placed',1,4);
insert into ServiceTicket values('2016-11-11 16:00','Placed',2,5);
insert into ServiceTicket values('2015-10-10 13:00','Cancelled',2,5);
insert into ServiceTicket values('2016-3-10 13:00','Placed',2,7);
insert into ServiceTicket values('2015-10-10 14:00','Cancelled',2,5);
insert into ServiceTicket values('2016-3-10 17:00','Placed',3,12);



-- create table PaymentMethod
-- (
-- ID int not null primary key auto_increment,
-- Name nvarchar(20) not null
-- );

insert into PaymentMethod values ('Alipay');
insert into PaymentMethod values ('UnionPay');
insert into PaymentMethod values ('Cash');
insert into PaymentMethod values ('Credit Card');
insert into PaymentMethod values ('MemberShipCard');


-- create table PaymentRecord
-- (
-- ID int not null primary key auto_increment,
-- Amount decimal(10,2) not null,
-- TimeFinished DateTime not null,
-- PaymentMethodID int not null,
-- CashierID int not null,
-- ServiceTicketID int not null,
-- foreign key(PaymentMethodID) references PaymentMethod(ID),
-- foreign key(CashierID) references Employee(ID),
-- foreign key(ServiceTicketID) references ServiceTicket(ID) 
-- );

insert into PaymentRecord values(100,'2016-10-10 12:00',5,3,1);
insert into PaymentRecord values(50,'2016-11-10 13:42',3,1,2);

