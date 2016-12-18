package controller;

import org.hibernate.Session;

public class ControllerBase {
	protected static final String SUCCESS = "SUCCESS";
	protected static final String FAIL = "FAIL";

	public ControllerBase() {
		super();
	}

	protected static final Session session = hibernate.HibernateSessionFactory
			.getSession();

}