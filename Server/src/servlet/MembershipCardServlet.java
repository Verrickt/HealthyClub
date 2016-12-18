package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import controller.MemberShipCardController;
import controller.MemberShipCardLevelController;

/**
 * Servlet implementation class MembershipCardServlet
 */
@WebServlet("/MembershipCardServlet")
public class MembershipCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MembershipCardServlet() {
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
		// TODO Auto-generated method stub
		
		MemberShipCardController c = new MemberShipCardController();
		String action = request.getParameter("action");
		String result = null;
		switch (action) {
		

			
		case "create": {
			Integer userID = Integer.valueOf(request.getParameter("levelname"));
			Integer levelID =Integer.valueOf( request.getParameter("levelID"));
			Double fund = Double.valueOf(request.getParameter("fund"));
			result = c.create(userID, levelID, fund);
		}
			break;
		case "list": {
	String filter = request.getParameter("filter");
		
			
			if(filter.isEmpty())
			{
				result = c.list();
			}
			else
			{
				Integer userID= Integer.valueOf(request.getParameter("userID"));
				result = c.list(userID);
			}
			
			
			
		}
			break;
		case "modify": {
			Integer levelID =Integer.valueOf( request.getParameter("levelID"));
			Integer MembershipCardID =Integer.valueOf( request.getParameter("membershipcardID"));
			Double fund = Double.valueOf(request.getParameter("fund"));
			c.modify(MembershipCardID, levelID, fund);
			
			
		}
			break;

		}
		response.getWriter().write(result);
		
	}

}
