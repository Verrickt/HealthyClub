package hibernate;

import java.util.*;
import java.util.stream.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class test {

	public static void main(String[] args) {
		System.out.println("Hello World");
		Session session = hibernate.HibernateSessionFactory.getSession();

		String name = "Von";

		String password = "p@ssw0rd";
		List<model.User> users = GetResult(session,
				"from User where Name='von' and Password = 'p@ssw0rd'");
		System.out.println(users.size());
		System.out.println(users.get(0).getName());
		util.ResponseBuilder<model.User> builder = new util.ResponseBuilder<model.User>(
				"OK", null);
		System.out.println(builder.toString());

	}

	public static <T> List<T> GetResult(Session session, String hql) {
		String name = "Von";
		Query query = session.createQuery(hql);
		List list = query.list();
		return new ArrayList<T>(list);
	}

}
