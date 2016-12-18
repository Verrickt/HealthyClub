package controller;

import model.DedicatedService;
import model.Service;
import model.Technician;
import util.GenericHelper;
import util.ResponseBuilder;

import java.util.List;

import org.hibernate.Transaction;

/**
 * Created by von on 12/8/16.
 */
public class DedicatedServiceController extends ControllerBase {

	public static final String UNEXPECTED = "UNEXPECTED";
	public static final String format = "From DedicatedService where TechnicianID='%d'";

	public String list(Integer TechnicianID) {
		String hql = String.format(format, TechnicianID);
		String msg = "";
		List<DedicatedService> result = null;
		DedicatedService s = new DedicatedService();
		List<DedicatedService> services = GenericHelper
				.<DedicatedService> GetResult(session, hql);
		msg = SUCCESS;
		return new ResponseBuilder<List<DedicatedService>>(msg, result)
				.toString();
	}
	
	public String list()
	{
		String msg = "";

		List<DedicatedService> result = null;
		DedicatedService s = new DedicatedService();
		List<DedicatedService> services = GenericHelper
				.<DedicatedService> GetResult(session, "From DedicatedService");
		msg = SUCCESS;
		return new ResponseBuilder<List<DedicatedService>>(msg, result)
				.toString();
	}
	
	

	public String create(Integer serviceID, Integer techinicianID, double price) {
		String msg = "";
		DedicatedService result = null;

		Service s = (Service) session.get(Service.class, serviceID);
		Technician t = (Technician) session
				.get(Technician.class, techinicianID);
		DedicatedService ds = new DedicatedService(s, t, price);
		Transaction trans = session.beginTransaction();
		try {
			session.save(ds);
			result = ds;
			msg = SUCCESS;
			trans.commit();
		} catch (Exception e) {
			msg = UNEXPECTED;
			trans.rollback();
		} finally {
			return new ResponseBuilder<DedicatedService>(msg, result)
					.toString();
		}
	}

	public String remove(Integer dedicatedServiceID) {
		String msg = "";
		Transaction t = session.beginTransaction();
		try {
			DedicatedService ds = (DedicatedService) session.get(
					DedicatedService.class, dedicatedServiceID);
			session.delete(ds);
			t.commit();
			msg = SUCCESS;
		} catch (Exception e) {
			t.rollback();
			msg = FAIL;
		} finally {
			return new ResponseBuilder(msg, null).toString();
		}
	}

	public String modify(Integer dedicatedServiceID, Integer serviceID,
			Integer techinicianID, double price) {
		String msg = "";
		DedicatedService result = null;
		Transaction t = session.beginTransaction();
		try {
			DedicatedService ds = (DedicatedService) session.get(
					DedicatedService.class, dedicatedServiceID);
			Technician tech = (Technician) session.get(Technician.class,
					techinicianID);
			Service s = (Service) session.get(Service.class, serviceID);
			ds.setPrice(price);
			ds.setService(s);
			ds.setTechnician(tech);
			session.update(ds);
			t.commit();
			msg = SUCCESS;
		} catch (Exception e) {
			t.rollback();
			msg = FAIL;
		} finally {
			return new ResponseBuilder(msg, null).toString();
		}
	}

}
