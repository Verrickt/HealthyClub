package controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Transaction;

import model.DedicatedService;
import model.Employee;
import model.MemberShipCard;
import model.PaymentMethod;
import model.PaymentRecord;
import model.ServiceTicket;
import util.GenericHelper;
import util.ResponseBuilder;

public class PaymentRecordController extends ControllerBase {

	public String list() {
		String msg = null;
		List<PaymentRecord> records = GenericHelper.GetResult(session,
				"From PaymentRecord");
		msg = SUCCESS;
		return new ResponseBuilder(msg, records).toString();

	}

	public String listEmployeeID(Integer EmployeeID) {
		String msg = null;
		String hql = "from PaymentRecord p,Technician t where p.employee=t.id and t.employee=\'"
				+ EmployeeID + "\'";
		List<PaymentRecord> tickets = GenericHelper.GetResult(session, hql);
		msg = SUCCESS;
		return new ResponseBuilder(msg, tickets).toString();

	}

	public String listPaymentMethodID(Integer PaymentMethodID) {
		String msg = null;
		List<PaymentRecord> tickets = GenericHelper.GetResult(session,
				"From PaymentRecord where paymentMethod=\'" + PaymentMethodID
						+ "\'");
		msg = SUCCESS;
		return new ResponseBuilder(msg, tickets).toString();

	}

	public String listUserID(Integer UserID) {
		String msg = null;
		String hql = "from PaymentRecord p,MemberShipCard m,ServiceTicket s "
				+ "where m.id=s.memberShipCard and"
				+ " s.id=p.serviceTicket and m.user=\'" + UserID + "\'";
		List<PaymentRecord> tickets = GenericHelper.GetResult(session, hql);
		msg = SUCCESS;
		return new ResponseBuilder(msg, tickets).toString();

	}

	public String create(Integer PaymentMethodID, Integer EmployeeID,
			Integer ServiceTicketID, Double amount) {
		PaymentRecord result = null;
		PaymentMethod method = (PaymentMethod) session.get(PaymentMethod.class,
				PaymentMethodID);
		ServiceTicket ticket = (ServiceTicket) session.get(ServiceTicket.class,
				ServiceTicketID);
		Employee employee = (Employee) session.get(Employee.class, EmployeeID);
		Timestamp timeFinished = Timestamp.valueOf(LocalDateTime.now());
		PaymentRecord record = new PaymentRecord(method, ticket, employee,
				amount, timeFinished);
		Transaction t = session.beginTransaction();
		String msg = "";
		try {
			session.save(record);
			t.commit();
			msg = SUCCESS;
			result = record;
		} catch (Exception e) {
			msg = FAIL;
			t.rollback();
			result = null;
		} finally {
			return new ResponseBuilder(msg, result).toString();

		}
	}

}
