package servlet;

import java.io.IOException;

import controller.EmployeeController;
import controller.UserController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		UserController c = new UserController();
		String action = request.getParameter("action");
		String result = null;
		switch (action) {
		case "login":

		{
			String password = request.getParameter("password");
			String username = request.getParameter("username");
			result = c.login(username, password);

		}

			break;
		case "create": {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			Integer age = Integer.valueOf(request.getParameter("age"));
			String gender = request.getParameter("gender");
			String phoneNumber = request.getParameter("phoneNumber");
			String password = request.getParameter("password");
			
			
			result = c.register(name, email, age, gender, phoneNumber, password);

		}
			break;
		case "list": {
				result = c.list();
		}
			break;
		case "modify": {
			Integer userID = Integer.valueOf(request
					.getParameter("userID"));

			String name = request.getParameter("name");
			String email = request.getParameter("email");
			Integer age = Integer.valueOf(request.getParameter("age"));
			String gender = request.getParameter("gender");
			String phoneNumber = request.getParameter("phoneNumber");
			String password = request.getParameter("password");
			
			
			result =c.modify(userID, name, email, age, gender, phoneNumber, password);
		}
			break;

		}
		response.getWriter().write(result);

	}

}
