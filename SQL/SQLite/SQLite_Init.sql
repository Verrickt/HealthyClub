
create table User
(
	Name nvarchar(10) not null,
	ID INTEGER not null  primary key,
    Email nvarchar(50) ,
    Gender char(1) check(Gender in ('M','F')),
	Age INTEGER  check(Age>=0 and Age<=120),
    PhoneNumber nvarchar(11) not null,
    Password nvarchar(20) not null
);

create table MemberShipCardLevel
(
	ID INTEGER not null  primary key,
    LevelName nvarchar(20) not null
);
create table MemberShipCard
(
ID INTEGER not null  primary key,
Fund decimal(10,2) not null check(Fund>=0),
MemberShipCardLevelID INTEGER not null,
UserID INTEGER not null,
FOREIGN KEY(MemberShipCardLevelID) references MemberShipCardLevel(ID),
Foreign key(UserID) references User(ID)
);
create table HealthyDocument
(
ID INTEGER not null  primary key,
UserID INTEGER not null,
Notes nvarchar(200) not null,
foreign key(UserID) references User(ID)

);
create table Employee
(
	ID INTEGER not null  primary key,
    Email nvarchar(50) not null,
    Gender char(1) not null check(Gender in ('M','F')),
	Age INTEGER not null check(Age>=0 and Age<=120),
    PhoneNumber nvarchar(11),
    JobTitle nvarchar(10) not null,
    Name nvarchar(10) not null,
    Password nvarchar(20) not null,
    Authority INTEGER not null check(Authority in (0,1,2))
);

create table Service
(
	ID INTEGER not null  primary key,
    Name nvarchar(20) not null
);

create table Technician
(
	ID INTEGER not null  primary key,
    EmployeeID INTEGER not null,
    foreign key(EmployeeID) references Employee(ID)
);

create table DedicatedService
(
 ID INTEGER not null  primary key,
 TechnicianID INTEGER not null,
 ServiceID INTEGER not null,
 Price decimal(10,2) not null check(Price>0),
 Foreign key (ServiceID) references Service(ID),
 Foreign key (TechnicianID) references Technician(ID)

);
create table DaylyAvailibility
(
ID INTEGER not null  primary key,
StartTime time not null check(StartTime between '00:00:00' and '24:00:00'),
EndTime time  not null,
TechnicianID INTEGER  not null,
DayOfWeek INTEGER  not null check(DayOfWeek between 1 and 7),
foreign key (TechnicianID) references Technician(ID)
);

create table PreorderTicket
(
ID INTEGER  not null  primary key,
OrderedTime DateTime not null,
PreOrderedTime DateTime not null,
Status nvarchar(10) check(Status in ('Placed','Cancelled')),
ReviewStatus nvarchar(20) check(ReviewStatus in ('Passed','Failed','NotReviewed')),
MemberShipCardID INTEGER not null,
DedicatedServiceID INTEGER not null,
foreign key(MemberShipCardID) references MemberShipCard(ID),
foreign key(DedicatedServiceID) references DedicatedService(ID)

);


create table ServiceTicket
(
ID INTEGER  not null  primary key,
OrderedTime DateTime not null ,
Status nvarchar(10) check(Status in ('Placed','Cancelled')),
MemberShipCardID INTEGER not null,
DedicatedServiceID INTEGER not null,
foreign key(MemberShipCardID) references MemberShipCard(ID),
foreign key(DedicatedServiceID) references DedicatedService(ID)

);


create table PaymentMethod
(
ID INTEGER not null primary key ,
Name nvarchar(20) not null
);



create table PaymentRecord
(
ID INTEGER not null primary key ,
Amount decimal(10,2) not null,
TimeFinished DateTime not null,
PaymentMethodID INTEGER not null,
CashierID INTEGER not null,
ServiceTicketID INTEGER not null,
foreign key(PaymentMethodID) references PaymentMethod(ID),
foreign key(CashierID) references Employee(ID),
foreign key(ServiceTicketID) references ServiceTicket(ID) 
);





