//TODO

remove MemberShipCardLevel



User
---
> Login(username,password)

> Modify(ID)

>List()

>Create()


MemberShipCardLevel
---

> List()

> Modify(ID)


>Create()

MemberShipCard
---

>Create(UserID)

>List()

>List(UserID)

>Modify()





HealthyDocument
---

>Create(UserID)

>Modify()

>List(UserID)


Employee
---
>Create()

>List()

>Login(username,password)

>Modify(ID)

Service
---
>Create()

>List()

>Modify(ID)



Technician
---

>Create(EmployeeID)

>Modify(ID)

>List()

>List(EmployeeID)


DedicatedService
---

>List()

>Modify(ID)

>Create(ServiceID,EmployeeID)



PreorderTicket
---
>List()

>List(MemberShipCardID)

>List(TechnicianID,filter)

filter={"none","unreviewed"}

- All

- Un Reviewed

>Review(ID,Status)

status={"passed","failed"}

>Cancel(ID)

Status=> Cancelled



>Create(MemberShipCardID,DedicatedServiceID)

ReviewStatus="NotReviewed"

Status="Placed"

ServiceTicket
---
>List()

>List(MemberShipCardID)

>List(TechnicianID)


>Cancel(ID)

- Cancel

Status="Cancelled"



>Create(MemberShipCardID,DedicatedService)


Status="Placed"

PaymentMethod
---
>List()

>Modify(ID)



PaymentRecord
---



>List()

>List(EmployeeID)

>List(PaymentMethodID)

>List(UserID)

>Create(PaymentMethodID,EmployeeID,ServiceTicketID)

