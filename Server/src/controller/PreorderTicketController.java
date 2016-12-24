package controller;
import java.util.Date;
import java.util.Set;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Transaction;

import model.DedicatedService;
import model.MemberShipCard;
import model.PreorderTicket;
import model.ServiceTicket;
import model.Technician;
import util.GenericHelper;
import util.ResponseBuilder;
public class PreorderTicketController extends ControllerBase {
	 public String list()
	    {
	        String msg=null;	   
	        List<PreorderTicket> tickets=
	        GenericHelper.GetResult(session,"From PreorderTicket");
	        tickets.stream().forEach(x->x.init());
	        
	        msg=SUCCESS;
	        return new ResponseBuilder(msg,tickets).toString();

	    }
	 public String listMemberShipCardID(Integer MemberShipCardID)
	    {
	        String msg=null;
	        List<PreorderTicket> tickets=
	    	        GenericHelper.GetResult(session,"From PreorderTicket where MemberShipCardID=\'"+ MemberShipCardID +"\'");
	        msg=SUCCESS;
	        tickets.stream().forEach(x->x.init());

	        return new ResponseBuilder(msg,tickets).toString();

	    }
	 
	    public String listTechnicianID(Integer TechnicianID,String filter)
	    {
	        String msg=null;
	        String hql="";
	        List<PreorderTicket> result;
	        Technician t = (Technician)session.get(Technician.class, TechnicianID);
	        Set ds = t.getDedicatedServices();
	        
	        List<PreorderTicket> tickets = GenericHelper.GetResult(session, "From PreorderTicket");
	        
	        
	        
	        if("unreviewed".equals(filter)) {
	        	result = tickets.stream().filter(pt->pt.getReviewStatus().equals(filter))
	        	.filter(pt->ds.contains(pt.getDedicatedService())).collect(Collectors.toList());
	        	
	        } else {
	        	result = tickets.stream()
	    	        	.filter(pt->ds.contains(pt.getDedicatedService())).collect(Collectors.toList());
	        }	        

	        result.stream().forEach(x->x.init());
	        msg=SUCCESS;
	        return new ResponseBuilder(msg,tickets).toString();
	    }

	    
	    public String Review(Integer ID,String reviewStatus)
	    {
	        String msg=null;
	        PreorderTicket result = null;
	        Transaction t = session.beginTransaction();
	        try {
	        	PreorderTicket ticket =  (PreorderTicket)session.get(PreorderTicket.class,ID);
		        ticket.setReviewStatus(reviewStatus);
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
	    
	    public String Cancel(Integer ID)
	    {
	        String msg=null;
	        PreorderTicket result = null;
	        Transaction t = session.beginTransaction();
	        try {
	        	PreorderTicket ticket =  (PreorderTicket)session.get(PreorderTicket.class,ID);
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
	    
	    public String create(Integer MemberShipCardID,Integer DedicatedServiceID,Timestamp preOrderedTime)
	    {
	    	PreorderTicket result=null;
	    	String Status = "Placed";
	    	String reviewStatus = "NotReviewed";
	        MemberShipCard card = (MemberShipCard)session.get(MemberShipCard.class,MemberShipCardID);
	        DedicatedService service =(DedicatedService)session.get(DedicatedService.class,DedicatedServiceID);
	        Date date = new Date();  
	        Timestamp ordertime = new Timestamp(date.getTime()); 
	        PreorderTicket ticket = new PreorderTicket(service,card,ordertime,preOrderedTime,Status,reviewStatus);
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
