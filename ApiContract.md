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

paymentrecord
=

preorderticket
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


serviceticket
=



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

No parameter

- modify

userID,name,email,age,gender in('F','M'),phoneNumber,password

