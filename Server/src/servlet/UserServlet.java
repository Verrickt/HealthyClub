package servlet;


import hibernate.test;

import java.io.IOException;

import com.google.*;
import com.google.gson.*;

import controller.LoginController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginController c = new LoginController();
		String action = request.getParameter("action");
		String result = null;
		switch(action)
		{
		case"login":
		{
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			result = c.login(username, password);
		}
		break;
		case"register":
		{
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			Integer age=Integer.valueOf(request.getParameter("age"));
			String gender=request.getParameter("gender");
            String phoneNumber=request.getParameter("phoneNumber");
            String password=request.getParameter("password");
            result = c.Register(name, email, age, gender, phoneNumber, password);           		
			
		}break;

		
		}
		response.getWriter().println(result);
		


	}

}
