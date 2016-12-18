package controller;

import model.Service;

import org.hibernate.Transaction;
import org.omg.PortableInterceptor.SUCCESSFUL;

import util.ResponseBuilder;

import java.util.List;

public class ServiceController extends ControllerBase {

	public static final String ERR_UNEXPECTED = "ERR_UNEXPECTED";
	private util.ResponseBuilder<Service> builder;
	private final String format = "From Service where ID = '%d'";

	public String list()

	{
		String msg = null;
		List<Service> result = null;
		try {
			List<Service> services = util.GenericHelper.GetResult(session,
					"from Service order by ID");
			result = services;
			msg = SUCCESS;
		} catch (Exception e) {
			msg = ERR_UNEXPECTED;
			result = null;
		} finally {
			return new ResponseBuilder<List<Service>>(msg, result).toString();

		}

	}

	public String create(String name) {
		Service result = null;
		String msg = null;
		Service service = new Service(name);
		try {
			Transaction t = session.beginTransaction();
			session.save(service);
			t.commit();
			msg = SUCCESS;
			result = service;
		} catch (Exception e) {
			msg = ERR_UNEXPECTED;
			result = null;
		} finally {
			return new ResponseBuilder<Service>(msg, result).toString();

		}

	}

	public String modify(Integer Id, String name) {
		Service result = null;
		String msg = null;
		String hql = String.format(format, Id);
		Transaction t = session.beginTransaction();

		try {
			Service service = util.GenericHelper.<Service> GetResult(session,
					hql).get(0);
			service.setName(name);
			session.update(service);
			t.commit();
			msg = SUCCESS;
			result = service;
		} catch (Exception e) {
			msg = ERR_UNEXPECTED;
			t.rollback();
			result = null;
		} finally {
			return new ResponseBuilder<Service>(msg, result).toString();

		}

	}

}
