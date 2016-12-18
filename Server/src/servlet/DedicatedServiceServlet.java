package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DedicatedServiceController;
import controller.EmployeeController;
import controller.HealthyDocumentController;

public class DedicatedServiceServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DedicatedServiceServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DedicatedServiceController c = new DedicatedServiceController();
		String action = request.getParameter("action");
		String result = null;
		switch (action) {
		

			
		case "create": {
			Integer serviceID= Integer.valueOf(request.getParameter("serviceID"));
			Integer technicianID= Integer.valueOf(request.getParameter("technicianID"));
			Double price = Double.valueOf(request.getParameter("price"));

			result = c.create(serviceID, technicianID, price);
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
				Integer TechnicianID= Integer.valueOf(request.getParameter("technicianID"));
				result = c.list(TechnicianID);
			}
			
			
		}
			break;
		case "modify": {
			Integer dedicatedServiceID = Integer.valueOf("dedicatedServiceID");
			Integer serviceID= Integer.valueOf(request.getParameter("serviceID"));
			Integer technicianID= Integer.valueOf(request.getParameter("technicianID"));
			Double price = Double.valueOf(request.getParameter("price"));
			result = c.modify(dedicatedServiceID, serviceID, technicianID, price);
			
		}
			break;

		}
		response.getWriter().write(result);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
