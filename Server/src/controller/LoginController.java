package controller;


import java.util.*;
import java.util.stream.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.*;
import util.GenericHelper;
import util.ResponseBuilder;

public class LoginController {
    private static final String ERR_USERNAME_NON_EXIST="ERR_USERNAME_NON_EXIST";
    private static final String ERR_WRONG_PASSWORD="ERR_WRONG_PASSWORD";
    private static final String SUCCESS="SUCCESS";
    private static final String ERR_REGIST_FAILED="ERR_REGIST_FAILED";

    private static final String format="From User where Name='%s'";
    private ResponseBuilder<User> builder;
    private static final Session session = hibernate.HibernateSessionFactory.getSession();
    public String login(String username,String password)
    {
        User result = null;
        String msg;
        String hql = String.format(format,username);
        List<User> users = util.GenericHelper.GetResult(session,hql);
        if (users.size()==0)
        {

            msg=ERR_USERNAME_NON_EXIST;
        }
        else
        {
            User user =users.get(0);
            if (user.getPassword().equals(password))
            {
                msg=SUCCESS;
                result=user;
            }
            else
            {
                msg=ERR_WRONG_PASSWORD;
            }

        }
        return new ResponseBuilder<User>(msg,result).toString();
    }

    public String Register(String name,String email,Integer age,String gender,
                               String phoneNumber,String password)
    {
        String msg=null;
        User result = null;
        User user = new User(name,phoneNumber,password);
        user.setAge(age);
        user.setGender(gender);
        user.setEmail(email);
		Transaction tran = session.beginTransaction();

            try {
				session.save(user);
				tran.commit();
				result=user;
				msg=SUCCESS;
				
			} catch (Exception e) {
				msg=ERR_REGIST_FAILED;
				tran.rollback();
			}
           finally
           {
               return new ResponseBuilder<User>(msg,result).toString();
           }
      

    }

}
