package controller;

import model.MemberShipCard;
import model.MemberShipCardLevel;
import util.GenericHelper;
import util.ResponseBuilder;

import java.beans.beancontext.BeanContextMembershipListener;
import java.util.List;

/**
 * Created by von on 12/9/16.
 */
public class LevelController extends ControllerBase {

    public String list()
    {
        List<MemberShipCardLevel> levels = null;
        levels = GenericHelper.GetResult(session,"From MemberShipCardLevel");
        return new ResponseBuilder<List<MemberShipCard>>(SUCCESS,levels).toString();

    }
    public String modify(Integer levelID,String levelName)
    {
        String msg = FAIL;
        MemberShipCardLevel result=null;
        Transaction t  = session.beginTransaction();
        MemberShipCardLevel card = GetLevel(levelID);
        card.setLevelName(levelName);
        try
        {
            session.update(level);
            t.commit();
            result=card;
            msg=SUCCESS;
        }
        catch (Exception e){
            t.rollback();

        }
            finally{

            return new ResponseBuilder<MemberShipCardLevel>(msg,result).toString();
        }

    }
    public String create(String levelName)
    {
        MemberShipCardLevel result=null;
        Transaction t  = session.beginTransaction();
        MemberShipCardLevel card = new MemberShipCardLevel(levelName);
        card.setLevelName(levelName);
        try
        {
            session.save(level);
            t.commit();
            result=card;
            msg=SUCCESS;
        }
        catch (Exception e){
            t.rollback();

        }
        finally{

            return new ResponseBuilder<MemberShipCardLevel>(msg,result).toString();
        }
    }


    private static MemberShipCardLevel GetLevel(Integer levelID)
    {
        return session.get(MemberShipCardLevel.class,levelID);
    }

}
