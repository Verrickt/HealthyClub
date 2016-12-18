package controller;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.*;
import util.GenericHelper;
import util.ResponseBuilder;

public class UserController extends ControllerBase {
	private static final String ERR_USER_NOT_EXIST = "ERR_USER_NOT_EXIST";
	private static final String ERR_WRONG_PASSWORD = "ERR_WRONG_PASSWORD";
	private static final String ERR_REGISTER_FAILED = "ERR_REGISTER_FAILED";

	private static final String format = "From User where Name='%s'";
	private ResponseBuilder<User> builder;

	public String login(String username, String password) {
		User result = null;
		String msg;
		String hql = String.format(format, username);
		List<User> users = util.GenericHelper.GetResult(session, hql);
		if (users.size() == 0) {

			msg = ERR_USER_NOT_EXIST;
		} else {
			User user = users.get(0);
			if (user.getPassword().equals(password)) {
				msg = SUCCESS;
				result = user;
			} else {
				msg = ERR_WRONG_PASSWORD;
			}

		}
		return new ResponseBuilder<User>(msg, result).toString();
	}

	public String register(String name, String email, Integer age,
			String gender, String phoneNumber, String password) {
		String msg = null;
		User result = null;
		User user = new User(name, phoneNumber, password);
		user.setAge(age);
		user.setGender(gender);
		user.setEmail(email);
		Transaction tran = session.beginTransaction();

		try {
			session.save(user);
			tran.commit();
			result = user;
			msg = SUCCESS;

		} catch (Exception e) {
			msg = ERR_REGISTER_FAILED;
			tran.rollback();
		} finally {
			return new ResponseBuilder<User>(msg, result).toString();
		}

	}

	public String modify(Integer userID, String name, String email,
			Integer age, String gender, String phoneNumber, String password) {
		String msg = "";
		Transaction t = session.beginTransaction();
		try {
			User u = (User) session.get(User.class, userID);
			u.setAge(age);
			u.setEmail(email);
			u.setPhoneNumber(phoneNumber);
			u.setGender(gender);
			u.setPassword(password);
			u.setName(name);
			session.update(u);
			t.commit();
			msg = SUCCESS;

		} catch (Exception e) {
			t.rollback();
			msg = ERR_USER_NOT_EXIST;
		} finally {
			return new ResponseBuilder(msg, null).toString();
		}
	}

	public String list() {
		List<User> result = null;
		String msg = null;
		List<User> users = GenericHelper.GetResult(session,
				"From User order by ID");
		msg = SUCCESS;
		result = users;
		return new ResponseBuilder<List<User>>(msg, result).toString();

	}

}
