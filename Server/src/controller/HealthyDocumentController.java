package controller;

import model.HealthyDocument;
import util.GenericHelper;
import util.ResponseBuilder;

import java.util.List;

/**
 * Created by von on 12/14/16.
 */
public class HealthyDocumentController extends ControllerBase {
    public static final String format="From HealthyDocument where UserID='%d'";

    public String get(Integer userID)
    {
        String msg=null;
        HealthyDocument doc = null;
        HealthyDocument result = null;
        try
        {
            doc = GenericHelper.<HealthyDocument>GetResult(session,String.format(format,userID)).get(0);
            msg=SUCCESS;
            result=doc;

        }
        catch (Exception e)
        {
            result=null;
            msg=FAIL;
        }
        finally {
            return new ResponseBuilder<>(msg,result);
        }
    }

    public String modify(Integer documentID,String note)
    {
        String msg=null;
        HealthyDocument doc = null;
        HealthyDocument result = null;
        Transaction t = session.beginTransaction();

        try
        {
            doc = (HealthyDocument) session.get(HealthyDocument.class,documentID);
            doc.setNotes(note);
            session.update(doc);
            t.commit();
            msg=SUCCESS;
            result=doc;
        }
        catch (Exception e)
        {
            t.rollback();
            result=null;
            msg=FAIL;
        }
        finally {
            return new ResponseBuilder<>(msg,result).toString();
        }
    }

    public String create(Integer userID,String note)
    {
        String msg=null;
        HealthyDocument doc = null;
        HealthyDocument result = null;
        Transaction t = session.beginTransaction();

        try
        {
            doc = (HealthyDocument) session.get(HealthyDocument.class,documentID);
            doc.setNotes(note);
            session.save(doc);
            t.commit();
            msg=SUCCESS;
            result=doc;
        }
        catch (Exception e)
        {
            t.rollback();
            result=null;
            msg=FAIL;
        }
        finally {
            return new ResponseBuilder<>(msg,result).toString();
        }

    }

}
