package util;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by von on 12/7/16.
 */
public class GenericHelper {
	public static <T> List<T> GetResult(Session session, String hql) {
		String name = "Von";
		Query query = session.createQuery(hql);
		List list = query.list();
		return new ArrayList<T>(list);
	}
}