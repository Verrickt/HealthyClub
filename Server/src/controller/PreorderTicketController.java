package controller;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;
import org.hibernate.Transaction;

import model.DedicatedService;
import model.MemberShipCard;
import model.PreorderTicket;
import util.GenericHelper;
import util.ResponseBuilder;
public class PreorderTicketController extends ControllerBase {
	 public String list()
	    {
	        String msg=null;	   
	        List<PreorderTicket> tickets=
	        GenericHelper.GetResult(session,"From PreorderTicket");
	        msg=SUCCESS;
	        return new ResponseBuilder(msg,tickets).toString();

	    }
	 public String listMemberShipCardID(Integer MemberShipCardID)
	    {
	        String msg=null;
	        List<PreorderTicket> tickets=
	    	        GenericHelper.GetResult(session,"From PreorderTicket where MemberShipCardID=\'"+ MemberShipCardID +"\'");
	        msg=SUCCESS;
	        return new ResponseBuilder(msg,tickets).toString();

	    }
	 
	    public String listTechnicianID(Integer TechnicianID,String filter)
	    {
	        String msg=null;
	        String hql="";
	        PreorderTicket tickets=null;
	        if("unreviewed".equals(filter)) {
	        	hql="from PreorderTicket p,DedicatedService d where p.dedicatedService=d.id and" +
	        			" p.reviewStatus='notreviewed' and d.technician=\'"+ TechnicianID +"\'";
	        } else {
	        	hql="from PreorderTicket p where p.dedicatedService=DedicatedService d where p.dedicatedService=d.id and d.technician=\'"+ TechnicianID +"\'";
	        }	        
	        List<Object> list=
	    	        GenericHelper.GetResult(session,hql);
	        
	        for(int i = 0; i < list.size(); i++)
	 
	        { 
	            Object []obj = (Object[])list.get(i);  //转型为数组
	            tickets = (PreorderTicket)obj[0];  //和select中顺序的类型相对应,可以是类
	        }
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
