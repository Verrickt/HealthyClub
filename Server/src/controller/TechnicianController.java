package controller;

import model.Employee;
import model.Technician;
import model.User;
import util.GenericHelper;
import util.ResponseBuilder;

import java.util.List;

import org.hibernate.Transaction;

/**
 * Created by von on 12/14/16.
 */
public class TechnicianController extends ControllerBase {
	public static final String format = "From Technician where EmployeeID = '%d'";

	public String create(Integer employeeID) {

		String msg = null;
		Technician result = null;
		Technician te = new Technician();

		Transaction t = session.beginTransaction();
		try {
			Employee e = (Employee) session.get(Employee.class, employeeID);
			te.setEmployee(e);
			session.save(te);
			t.commit();
			msg = SUCCESS;
			result = te;
		} catch (Exception e) {
			t.rollback();
			result = null;
			msg = FAIL;
		} finally {
			return new ResponseBuilder<Technician>(msg, result).toString();
		}
	}

	public String list() {
		String msg = null;
		List<Technician> result = null;

		try {
			result = GenericHelper.<Technician> GetResult(session,
					"From Technician");
			msg = SUCCESS;
		} catch (Exception e) {
			result = null;
			msg = FAIL;
		} finally {
			return new ResponseBuilder<>(msg, result).toString();
		}

	}

	public String get(Integer userID) {
		String msg = null;
		Technician result = null;
		try {
			result = GenericHelper.<Technician> GetResult(session,
					String.format(format, userID)).get(0);
			msg = SUCCESS;
		} catch (Exception e) {
			result = null;
			msg = FAIL;
		} finally {
			return new ResponseBuilder<Technician>(msg, result).toString();
		}

	}

}
