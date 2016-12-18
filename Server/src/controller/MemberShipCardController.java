package controller;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import model.MemberShipCard;
import model.MemberShipCardLevel;
import model.User;
import servlet.MembershipCardServlet;
import util.GenericHelper;
import util.ResponseBuilder;

import java.util.List;

import org.hibernate.Transaction;

/**
 * Created by von on 12/8/16.
 */
public class MemberShipCardController extends ControllerBase {
	public static final String format = "From MemberShipCard where UserID='%d'";

	public String list() {
		String msg = null;
		List<MemberShipCard> cards = GenericHelper.GetResult(session,
				"From MembershipCard");
		msg = SUCCESS;
		return new ResponseBuilder(msg, cards).toString();

	}

	public String modify(Integer MembershipCardID, Integer levelID, double fund) {
		String msg = null;
		MemberShipCard result = null;
		Transaction t = session.beginTransaction();
		MemberShipCardLevel level = (MemberShipCardLevel) session.get(
				MemberShipCardLevel.class, levelID);
		try {
			MemberShipCard card = (MemberShipCard) session.get(
					MemberShipCard.class, MembershipCardID);
			card.setFund(fund);
			card.setMemberShipCardLevel(level);
			session.update(card);
			t.commit();
			msg = SUCCESS;
			result = card;
		} catch (Exception e) {
			msg = FAIL;
			t.rollback();
			result = null;
		} finally {
			return new ResponseBuilder<MemberShipCard>(msg, result).toString();

		}
	}

	public String create(Integer userID, Integer levelID, double fund) {
		MemberShipCard result = null;
		MemberShipCardLevel level = (MemberShipCardLevel) session.get(
				MemberShipCardLevel.class, levelID);
		User user = (User) session.get(User.class, userID);
		MemberShipCard card = new MemberShipCard(level, user, fund);
		Transaction t = session.beginTransaction();
		String msg = "";
		try {
			session.save(card);
			t.commit();
			msg = SUCCESS;
			result = card;
		} catch (Exception e) {
			msg = FAIL;
			t.rollback();
			result = null;
		} finally {
			return new ResponseBuilder<MemberShipCard>(msg, result).toString();

		}
	}

	public String list(Integer userID) {
		String msg = null;
		MemberShipCard card = null;
		MemberShipCard result = null;
		try {
			card = GenericHelper.<MemberShipCard> GetResult(session,
					String.format(format, userID)).get(0);
			msg = SUCCESS;
			result = card;
		} catch (Exception e) {
			msg = FAIL;
		} finally {
			return new ResponseBuilder<MemberShipCard>(msg, result).toString();
		}

	}

}
