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

>List(TechnicianID)

- All

- Un Reviewed


>Modify(ID)

- Cancel

- Finish

- Review

>Create(MemberShipCardID,DedicatedServiceID)

ServiceTicket
---
>List()

>List(MemberShipCardID)

>List(TechnicianID)


>Modify(ID)

- Cancel

- Finish


>Create(MemberShipCardID,DedicatedService)


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



