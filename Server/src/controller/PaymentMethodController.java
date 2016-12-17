package controller;

import java.util.List;

import model.PaymentMethod;

import org.hibernate.Transaction;

import util.GenericHelper;
import util.ResponseBuilder;

public class PaymentMethodController extends ControllerBase {
    public String list()
    {
        String msg=null;
        List<PaymentMethod> cards=
        GenericHelper.GetResult(session,"From PaymentMethod");
        msg=SUCCESS;
        return new ResponseBuilder(msg,cards).toString();

    }
    @SuppressWarnings("finally")
	public String modify(Integer PaymentMethodID,String name)
    {
        String msg=null;
        PaymentMethod result = null;
        Transaction t = session.beginTransaction();
        try{
        	   PaymentMethod method = (PaymentMethod) session.get(PaymentMethod.class,PaymentMethodID);
               method.setName(name);
               session.update(method);
               t.commit();
               msg=SUCCESS;
               result = method;
        }    catch (Exception e)
          {
            msg=FAIL;
            t.rollback();
            result = null;
        }
        finally
        {
            return new ResponseBuilder<PaymentMethod>(msg,result).toString();

        }
    }
}
