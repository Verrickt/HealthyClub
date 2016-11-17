create database HealthyClub;
use HealthyClub;
create table User
(
	Name nvarchar(10) not null,
	ID int not null AUTO_INCREMENT primary key,
    Email nvarchar(50) not null,
    Gender char(1) not null check(Gender in ('M','F')),
	Age int not null check(Age>=0 and Age<=120),
    PhoneNumber nvarchar(11),
    Password nvarchar(20) not null
);

create table MemberShipCardLevel
(
	ID int not null auto_increment primary key,
    LevelName nvarchar(20) not null
);
create table MemberShipCard
(
ID int not null auto_increment primary key,
Fund decimal(10,2) not null check(Fund>=0),
MemberShipLevel int not null,
UserID int not null,
FOREIGN KEY(MemberShipLevel) references MemberShipCardLevel(ID),
Foreign key(UserID) references User(ID)
);
create table HealthyDocument
(
ID int not null auto_increment primary key,
UserID int not null,
Notes nvarchar(200) not null,
foreign key(UserID) references User(ID)

);
create table Employee
(
	ID int not null AUTO_INCREMENT primary key,
    Email nvarchar(50) not null,
    Gender char(1) not null check(Gender in ('M','F')),
	Age int not null check(Age>=0 and Age<=120),
    PhoneNumber nvarchar(11),
    JobTitle nvarchar(10) not null,
    Name nvarchar(10) not null,
    Password nvarchar(20) not null,
    Authority int not null check(Authority in (0,1,2))
);

create table Service
(
	ID int not null auto_increment primary key,
    Name nvarchar(20) not null
);

create table Technician
(
	ID int not null auto_increment primary key,
    EmployeeID int not null,
    foreign key(EmployeeID) references Employee(ID)
);

create table DedicatedService
(
 ID int not null auto_increment primary key,
 TechnicianID int not null,
 ServiceID int not null,
 Price decimal(10,2) not null check(Price>0),
 Foreign key (ServiceID) references Service(ID),
 Foreign key (TechnicianID) references Technician(ID)

);
create table DaylyAvailibility
(
ID int not null auto_increment primary key,
StartTime time not null check(StartTime between '00:00:00' and '24:00:00'),
EndTime time  not null,
TechnicianID int  not null,
DayOfWeek int  not null check(DayOfWeek between 1 and 7),
foreign key (TechnicianID) references Technician(ID)
);

create table PreorderTicket
(
ID int  not null auto_increment primary key,
OrderedTime DateTime not null,
Status nvarchar(10) check(Status in ('Placed','Cancelled')),
ReviewStatus nvarchar(20) check(ReviewStatus in ('Passed','Failed','NotReviewed')),
MemberShipCardID int not null,
DedicatedServiceID int not null,
foreign key(MemberShipCardID) references MemberShipCard(ID),
foreign key(DedicatedServiceID) references DedicatedService(ID)

);


create table ServiceTicket
(
ID int  not null auto_increment primary key,
OrderedTime DateTime not null ,
Status nvarchar(10) check(Status in ('Placed','Cancelled')),
MemberShipCardID int not null,
DedicatedServiceID int not null,
foreign key(MemberShipCardID) references MemberShipCard(ID),
foreign key(DedicatedServiceID) references DedicatedService(ID)

);


create table PaymentMethod
(
ID int not null primary key auto_increment,
Name nvarchar(20) not null
);



create table PaymentRecord
(
ID int not null primary key auto_increment,
Amount decimal(10,2) not null,
TimeFinished DateTime not null,
PaymentMethodID int not null,
CashierID int not null,
ServiceTicketID int not null,
foreign key(PaymentMethodID) references PaymentMethod(ID),
foreign key(CashierID) references Employee(ID),
foreign key(ServiceTicketID) references ServiceTicket(ID) 
);





