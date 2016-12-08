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

>Modify()





HealthyDocument
---

>Create(UserID)

>Modify()



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


DedicatedService
---

>List()

>Modify(ID)

>create(ServiceID,EmployeeID)


DaylyAvailibility
---
>List(TechnicianID)

>Modify(ID)

>Create(TechnicianID)

PreorderTicket
---
>List()

>List(MemberShipCardID)

>List(TechnicianID)

>Modify(ID)

- Cancel

- Finish

- Review

>Create(MemberShipCardID,DedicatedService)

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



