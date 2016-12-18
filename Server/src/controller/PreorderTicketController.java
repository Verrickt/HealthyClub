package controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Transaction;

import model.DedicatedService;
import model.MemberShipCard;
import model.MemberShipCardLevel;
import model.PreorderTicket;
import model.User;
import util.GenericHelper;
import util.ResponseBuilder;

public class PreorderTicketController extends ControllerBase {
	public String list() {
		String msg = null;
		List<PreorderTicket> tickets = GenericHelper.GetResult(session,
				"From PreorderTicket");
		msg = SUCCESS;
		return new ResponseBuilder(msg, tickets).toString();

	}

	public String listMemberShipCardID(Integer MemberShipCardID) {
		String msg = null;
		List<PreorderTicket> tickets = GenericHelper.GetResult(session,
				"From PreorderTicket where MemberShipCardID=\'"
						+ MemberShipCardID + "\'");
		msg = SUCCESS;
		return new ResponseBuilder(msg, tickets).toString();

	}

	public String listTechnicianID(Integer TechnicianID, String filter) {
		String msg = null;
		String hql = "";
		if ("unreviewed".equals(filter)) {
			hql = "from PreorderTicket p,DedicatedService d where p.dedicatedService=d.id and"
					+ " p.reviewStatus='notreviewed' and d.technician=\'"
					+ TechnicianID + "\'";
		} else {
			hql = "from PreorderTicket p,DedicatedService d where p.dedicatedService=d.id and d.technician=\'"
					+ TechnicianID + "\'";
		}
		List<PreorderTicket> tickets = GenericHelper.GetResult(session, hql);
		msg = SUCCESS;
		return new ResponseBuilder(msg, tickets).toString();

	}

	public String review(Integer ID, String reviewStatus) {
		String msg = null;
		PreorderTicket result = null;
		Transaction t = session.beginTransaction();
		try {
			PreorderTicket ticket = (PreorderTicket) session.get(
					PreorderTicket.class, ID);
			ticket.setReviewStatus(reviewStatus);
			session.update(ticket);
			t.commit();
			msg = SUCCESS;
			result = ticket;
		} catch (Exception e) {
			msg = FAIL;
			t.rollback();
			result = null;
		} finally {
			return new ResponseBuilder(msg, result).toString();

		}
	}

	public String cancel(Integer ID) {
		String msg = null;
		PreorderTicket result = null;
		Transaction t = session.beginTransaction();
		try {
			PreorderTicket ticket = (PreorderTicket) session.get(
					PreorderTicket.class, ID);
			ticket.setStatus("Cancelled");
			session.update(ticket);
			t.commit();
			msg = SUCCESS;
			result = ticket;
		} catch (Exception e) {
			msg = FAIL;
			t.rollback();
			result = null;
		} finally {
			return new ResponseBuilder(msg, result).toString();

		}
	}

	public String create(Integer MemberShipCardID, Integer DedicatedServiceID,
			Timestamp preOrderedTime) {
		PreorderTicket result = null;
		String Status = "Placed";
		String reviewStatus = "NotReviewed";
		MemberShipCard card = (MemberShipCard) session.get(
				MemberShipCard.class, MemberShipCardID);
		DedicatedService service = (DedicatedService) session.get(
				DedicatedService.class, DedicatedServiceID);
		Timestamp ordertime = Timestamp.valueOf(LocalDateTime.now());
		PreorderTicket ticket = new PreorderTicket(service, card, ordertime,
				preOrderedTime, Status, reviewStatus);
		Transaction t = session.beginTransaction();
		String msg = "";
		try {
			session.save(ticket);
			t.commit();
			msg = SUCCESS;
			result = ticket;
		} catch (Exception e) {
			msg = FAIL;
			t.rollback();
			result = null;
		} finally {
			return new ResponseBuilder(msg, result).toString();

		}
	}
}
