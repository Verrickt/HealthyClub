ApiContract


url pattern : Domain/HealthyClub/




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




membershipCard
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




paymentMethod
=

paymentRecord
=

preorderTicket
=

service
=
action

 - create

name

- list

no parameter

- modify

serviceID,name


serviceTicket
=



technicianServlet
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

No parameter

- modify

userID,name,email,age,gender in('F','M'),phoneNumber,password

