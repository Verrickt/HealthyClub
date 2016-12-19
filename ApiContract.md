ApiContract


url pattern : Domain/HealthyClub/module

# PLEASE USE HTTP POST METHOD!!!!!!!!!!




dedicatedservice
==

action

 - create

serviceID, technicianID, price



- list

filter in(null,'byTechnicianID')


filter,technicianID

- modify

dedicatedServiceID, serviceID, technicianID, price

employee
=
action


- login

username,password


- create

name,email,age,gender in('F','M'),phoneNumber,password,authority,jobtitle

- list

No parameter

- modify

employeeID,name,email,age,gender in('F','M'),phoneNumber,password,authority,jobtitle


healthydocument
=
action





- create

userID, note

- list




filter in(null,'byuserID')


filter,userID


- modify

documentID, note




membershipcard
=
action



 - create

userID, levelID, fund;


- list

filter in(null,'byuserID')


filter,userID

- modify

membershipcardID, levelID, fund




membershipcardlevel
=
action


 - create

levelName


- list

no parameter

- modify

levelID, levelName




paymentmethod
=
action
- list

no parameter

- modify

PaymentMethodID,name


paymentrecord
=

action

- list

no parameter
- listEmployeeID

EmployeeID

- listPaymentMethodID

PaymentMethodID

- listUserID

UserID

- create


PaymentMethodID,EmployeeID,ServiceTicketID,amount




preorderticket
=


action

- list

no parameter
- listMemberShipCardID

MemberShipCardID
- listTechnicianID

filter in(null,' unreviewed')

TechnicianID,filter


- review

ID,reviewStatus
- cancel

ID
- create

MemberShipCardID,DedicatedServiceID,preOrderedTime








service
=
action

 - create

name

- list

no parameter

- modify

serviceID,name


serviceticket
=


action
- list

no parameter

- listMemberShipCardID

MemberShipCardID
- listTechnicianID

TechnicianID

- cancel

ID
- create

MemberShipCardID,DedicatedServiceID




technician
=
action


- create

employeeID

- list

user
=
action



- login

username,password


- create

name,email,age,gender in('F','M'),phoneNumber,password

- list

filter in {"","membershipcardID"}

filter,membershipcardID

No parameter

- modify

userID,name,email,age,gender in('F','M'),phoneNumber,password

