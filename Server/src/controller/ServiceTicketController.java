package controller;

import java.util.Date;
import java.util.Set;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Transaction;

import model.DedicatedService;
import model.MemberShipCard;
import model.ServiceTicket;
import model.Technician;
import util.GenericHelper;
import util.ResponseBuilder;

public class ServiceTicketController extends ControllerBase {
	 public String list()
	    {
	        String msg=null;
	        List<ServiceTicket> tickets=
	        GenericHelper.GetResult(session,"From ServiceTicket");
	        msg=SUCCESS;
	        
	        tickets.forEach(x->x.init());
	        
	        return new ResponseBuilder(msg,tickets).toString();

	    }
	 public String listMemberShipCardID(Integer MemberShipCardID)
	    {
	        String msg=null;
	        List<ServiceTicket> tickets=
	    	        GenericHelper.GetResult(session,"From ServiceTicket where MemberShipCardID=\'"+ MemberShipCardID +"\'");
	        msg=SUCCESS;
	        tickets.forEach(x->x.init());
	        return new ResponseBuilder(msg,tickets).toString();

	    }
	 public String listTechnicianID(Integer TechnicianID)
	    {
		    List<ServiceTicket> result=null;
	        String msg=null;
	        String hql="from ServiceTicket s,DedicatedService d where s.dedicatedService=d.id and d.technician=\'"+ TechnicianID +"\'";	       
	        Technician t = (Technician)session.get(Technician.class, TechnicianID);
	        Set ds = t.getDedicatedServices();
	        
	        List<ServiceTicket> tickets = GenericHelper.GetResult(session, "From ServiceTicket");
	        
	      
	        {
	        	result = tickets.stream().filter(x->ds.contains(x))
	        			.collect(Collectors.toList());
	        }
	        
	        
	       result.forEach(x->x.init());
	       
	        msg=SUCCESS;
	        return new ResponseBuilder(msg,result).toString();
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
	            result.init();
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
	        Date date = new Date();
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
	            result.init();
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
