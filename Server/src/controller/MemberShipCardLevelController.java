package controller;

import model.MemberShipCard;
import model.MemberShipCardLevel;
import util.GenericHelper;
import util.ResponseBuilder;

import java.beans.beancontext.BeanContextMembershipListener;
import java.util.List;

import org.hibernate.Transaction;

/**
 * Created by von on 12/9/16.
 */
public class MemberShipCardLevelController extends ControllerBase {

	public String list() {
		List<MemberShipCardLevel> levels = null;
		levels = GenericHelper.GetResult(session, "From MemberShipCardLevel");
		return new ResponseBuilder<List<MemberShipCardLevel>>(SUCCESS, levels)
				.toString();

	}

	public String modify(Integer levelID, String levelName) {
		String msg = FAIL;
		MemberShipCardLevel result = null;
		Transaction t = session.beginTransaction();
		MemberShipCardLevel level = GetLevel(levelID);
		level.setLevelName(levelName);
		try {
			session.update(level);
			t.commit();
			result = level;
			msg = SUCCESS;
		} catch (Exception e) {
			t.rollback();

		} finally {

			return new ResponseBuilder<MemberShipCardLevel>(msg, result)
					.toString();
		}

	}

	public String create(String levelName) {
		String msg = "";
		MemberShipCardLevel result = null;
		Transaction t = session.beginTransaction();
		MemberShipCardLevel level = new MemberShipCardLevel(levelName);
		level.setLevelName(levelName);
		try {
			session.save(level);
			t.commit();
			result = level;
			msg = SUCCESS;
		} catch (Exception e) {
			msg=FAIL;
			t.rollback();

		} finally {

			return new ResponseBuilder<MemberShipCardLevel>(msg, result)
					.toString();
		}
	}

	private static MemberShipCardLevel GetLevel(Integer levelID) {
		return (MemberShipCardLevel) session.get(MemberShipCardLevel.class,
				levelID);
	}

}
