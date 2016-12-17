package controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Transaction;

import model.DedicatedService;
import model.MemberShipCard;
import model.PaymentMethod;
import model.PaymentRecord;
import model.PreorderTicket;
import model.ServiceTicket;
import util.GenericHelper;
import util.ResponseBuilder;

public class ServiceTicketController extends ControllerBase {
	 public String list()
	    {
	        String msg=null;
	        List<ServiceTicket> cards=
	        GenericHelper.GetResult(session,"From ServiceTicket");
	        msg=SUCCESS;
	        return new ResponseBuilder(msg,cards).toString();

	    }
	 public String listMemberShipCardID(Integer MemberShipCardID)
	    {
	        String msg=null;
	        List<ServiceTicket> tickets=
	    	        GenericHelper.GetResult(session,"From ServiceTicket where MemberShipCardID=\'"+ MemberShipCardID +"\'");
	        msg=SUCCESS;
	        return new ResponseBuilder(msg,tickets).toString();

	    }
	 public String listTechnicianID(Integer TechnicianID)
	    {
	        String msg=null;
	        String hql="from ServiceTicket s,DedicatedService d where s.dedicatedService=d.id and d.technician=\'"+ TechnicianID +"\'";	       
	        List<ServiceTicket> tickets=
	    	        GenericHelper.GetResult(session,hql);
	        msg=SUCCESS;
	        return new ResponseBuilder(msg,tickets).toString();

	    }
	 
	 public String Cancel(Integer ID)
	    {
	        String msg=null;
	        ServiceTicket result = null;
	        Transaction t = session.beginTransaction();
	        try {
	        	ServiceTicket ticket =  (ServiceTicket)session.get(ServiceTicket.class,ID);
		        ticket.setStatus("Cancelled");
	            session.update(ticket);
	            t.commit();
	            msg=SUCCESS;
	            result = ticket;
	        }
	        catch (Exception e)
	        {
	            msg=FAIL;
	            t.rollback();
	            result = null;
	        }
	        finally
	        {
	        	return new ResponseBuilder(msg,result).toString();

	        }
	    }
	 
	  public String create(Integer MemberShipCardID,Integer DedicatedServiceID)
	    {
		    ServiceTicket result=null;
	    	String Status = "Placed";
	        MemberShipCard card = (MemberShipCard)session.get(MemberShipCard.class,MemberShipCardID);
            DedicatedService service =(DedicatedService)session.get(DedicatedService.class,DedicatedServiceID);	 
	        Date date = new Date(0);  
	        Timestamp ordertime = new Timestamp(date.getTime()); 
	        ServiceTicket ticket = new ServiceTicket(service,card,ordertime);
	        ticket.setStatus(Status);
	        Transaction t = session.beginTransaction();
	        String msg="";
	        try {
	            session.save(ticket);
	            t.commit();
	            msg=SUCCESS;
	            result = ticket;
	        }
	        catch (Exception e)
	        {
	            msg=FAIL;
	            t.rollback();
	            result = null;
	        }
	        finally
	        {
	            return new ResponseBuilder(msg,result).toString();

	        }
	    }
}
