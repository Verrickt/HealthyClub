package controller;

import model.Employee;
import util.GenericHelper;
import util.ResponseBuilder;

import java.util.List;

import org.hibernate.Transaction;

/**
 * Created by von on 12/14/16.
 */
public class EmployeeController extends ControllerBase {
	public static final String format = "From Employee where name = '%s'";
	private static final String ERR_REGISTER_FAILED = "ERR_REGISTER_FAILED";

	public String login(String username, String password) {
		String msg = null;
		Employee result = null;
		Employee employee = null;
		try {
			employee = GenericHelper.<Employee> GetResult(session,
					String.format(format, username)).get(0);
			if (employee.getName().equals(password)) {
				result = employee;
				msg = SUCCESS;
			} else {
				msg = FAIL;
			}
		} catch (Exception e) {
			msg = FAIL;
		} finally {
			return new ResponseBuilder<Employee>(msg, employee).toString();
		}

	}

	public String create(String name, String email, Integer age, String gender,
			String phoneNumber, String password, Integer authority,
			String jobTitle) {
		String msg = null;
		Employee result = null;
		Employee employee = new Employee(email, gender, age, jobTitle, name,
				password, authority);
		employee.setPhoneNumber(phoneNumber);
		Transaction tran = session.beginTransaction();

		try {
			if(gender.length()>1)
				gender="M";
			session.save(employee);
			tran.commit();
			result = employee;
			msg = SUCCESS;

		} catch (Exception e) {
			msg = ERR_REGISTER_FAILED;
			tran.rollback();
		} finally {
			return new ResponseBuilder<Employee>(msg, result).toString();
		}

	}

	public String list() {
		String msg = FAIL;
		List<Employee> employees = GenericHelper.GetResult(session,
				"From Employee");
		msg = SUCCESS;
		return new ResponseBuilder<List<Employee>>(msg, employees).toString();
	}

	public String modify(Integer employeeID, String name, String email,
			Integer age, String gender, String phoneNumber, String password,
			Integer authority, String jobTitle) {
		String msg = null;
		Employee result = null;
		Employee employee = null;
		if(gender.length()>1)
			gender="M";
		employee = (Employee) session.get(Employee.class, employeeID);
		employee.setName(name);
		employee.setEmail(email);
		employee.setAge(age);
		employee.setGender(gender);
		employee.setPhoneNumber(phoneNumber);
		employee.setPassword(password);
		employee.setAuthority(authority);
		employee.setJobTitle(jobTitle);

		Transaction tran = session.beginTransaction();

		try {
			session.save(employee);
			tran.commit();
			result = employee;
			msg = SUCCESS;

		} catch (Exception e) {
			msg = ERR_REGISTER_FAILED;
			tran.rollback();
		} finally {
			return new ResponseBuilder<Employee>(msg, result).toString();
		}
	}
}
