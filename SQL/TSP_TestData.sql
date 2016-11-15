use TSP;






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



insert into User values ('Von',1,'von@xxx.com','M',28,'2333','p@ssw0rd');
insert into User values ('Gary',1,'gary@xxx.com','M',24,'2333','p@ssw0rd');
insert into User values ('Ann',1,'ann@xxx.com','F',19,'2333','p@ssw0rd');
insert into User values ('Peter',1,'peter@xxx.com','M',26,'2333','p@ssw0rd');

-- create table MemberShipCardLevel
-- (
-- 	LevelID int not null auto_increment primary key,
--     LevelName nvarchar(20) not null
-- );



insert into MemberShipCardLevel values (0,'Copper');
insert into MemberShipCardLevel values (0,'Silver');
insert into MemberShipCardLevel values (0,'Gold');
insert into MemberShipCardLevel values (0,'???');



-- create table MemberShipCard
-- (
-- ID int not null auto_increment primary key,
-- Fund decimal(10,2) not null check(Fund>=0),
-- MemberShipLevel int not null,
-- UserID int not null,
-- FOREIGN KEY(MemberShipLevel) references MemberShipCardLevel(ID),
-- Foreign key(UserID) references User(ID)
-- );

insert into MembershipCard values (0,2567.5,2,1);
insert into MembershipCard values (0,23246.23,3,2);
insert into MembershipCard values (0,5465.7,1,3);
insert into MembershipCard values (0,7985,1,4);




-- create table HealthyDocument
-- (
-- ID int not null auto_increment primary key,
-- UserID int not null,
-- Notes nvarchar(200) not null,
-- foreign key(UserID) references User(ID)

-- );

insert into HealthyDocument values (0,1,'HealthyForever');
insert into HealthyDocument values (0,2,'HealthyForever');
insert into HealthyDocument values (0,3,'VeryHealthy');
insert into HealthyDocument values (0,4,'ABitHealthy');



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


insert into Employee values (0,'tank@xxx.com','M',25,'23333333','Big Boss','Tank','p@ssw0rd',0)
insert into Employee values (0,'spitter@xxx.com','F',21,'13524355','The cashier','Spitter','p@ssw0rd',1)
insert into Employee values (0,'hunter@xxx.com','M',25,'23333333','Miserable Worker','hunter','p@ssw0rd',2)
insert into Employee values (0,'boomer@xxx.com','M',25,'23333333','Miserable Worker','boomer','p@ssw0rd',2)
insert into Employee values (0,'jockey@xxx.com','M',25,'23333333','Miserable Worker','jockey','p@ssw0rd',2)


-- create table Service
-- (
-- 	ID int not null auto_increment primary key,
--     Name nvarchar(20) not null
-- );



insert into Service values(0,'');
insert into Service values(0,'');
insert into Service values(0,'');
insert into Service values(0,'');
insert into Service values(0,'');


-- create table Technician
-- (
-- 	ID int not null auto_increment primary key,
--     EmployeeID int not null,
--     foreign key(EmployeeID) references Employee(ID)
-- );

-- create table DedicatedService
-- (
--  ID int not null auto_increment primary key,
--  TechnicianID int not null,
--  ServiceID int not null,
--  Price decimal(10,2) not null check(Price>0),
--  Foreign key (ServiceID) references Service(ID),
--  Foreign key (TechnicianID) references Technician(ID)

-- );
-- create table DaylyAvailibility
-- (
-- ID int not null auto_increment primary key,
-- StartTime time not null check(StartTime between '00:00:00' and '24:00:00'),
-- EndTime time  not null,
-- DayOfWeek int  not null check(DayOfWeek between 1 and 7),
-- TechnicianID int  not null,
-- foreign key (TechnicianID) references Technician(ID)
-- );

-- create table PreorderTicket
-- (
-- ID int  not null auto_increment primary key,
-- OrderedTime DateTime not null,
-- Status nvarchar(10) check(Status in ('Placed','Cancelled')),
-- ReviewStatus nvarchar(20) check(Status in ('Passed','Failed','NotReviewed')),
-- MemberShipCardID int not null,
-- DedicatedServiceID int not null,
-- foreign key(MemberShipCardID) references MemberShipCard(ID),
-- foreign key(DedicatedServiceID) references DedicatedService(ID)

-- );


-- create table OrderTicket
-- (
-- ID int  not null auto_increment primary key,
-- OrderedTime DateTime not null ,
-- MemberShipCardID int not null,
-- DedicatedServiceID int not null,
-- foreign key(MemberShipCardID) references MemberShipCard(ID),
-- foreign key(DedicatedServiceID) references DedicatedService(ID)

-- );


-- create table PaymentMethod
-- (
-- ID int not null primary key auto_increment,
-- Name nvarchar(20) not null
-- );



-- create table PaymentRecord
-- (
-- ID int not null primary key auto_increment,
-- Amount decimal(10,2) not null,
-- TimeFinished DateTime not null,
-- PaymentMethodID int not null,
-- CashierID int not null,
-- foreign key(PaymentMethodID) references PaymentMethod(ID),
-- foreign key(CashierID) references Employee(ID)
-- );

