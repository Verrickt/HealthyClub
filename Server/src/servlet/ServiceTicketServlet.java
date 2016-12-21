package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ServiceTicketController;

@SuppressWarnings("serial")
@WebServlet("/ServiceTicketServlet")
public class ServiceTicketServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
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
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServiceTicketController s = new ServiceTicketController();
		String action = request.getParameter("action");
		String result = null;
		if ("list".equals(action)) {
			result = s.list();
		} else if ("listMemberShipCardID".equals(action)) {
			Integer MemberShipCardID = Integer.parseInt(request
					.getParameter("MemberShipCardID"));
			result = s.listMemberShipCardID(MemberShipCardID);
		} else if ("listTechnicianID".equals(action)) {
			Integer TechnicianID = Integer.parseInt(request
					.getParameter("TechnicianID"));
			
			result = s.listTechnicianID(TechnicianID);
		} else if ("cancel".equals(action)) {
			Integer ID = Integer.parseInt(request.getParameter("ID"));
			result = s.Cancel(ID);
		} else if ("create".equals(action)) {
			Integer MemberShipCardID = Integer.parseInt(request
					.getParameter("MemberShipCardID"));
			Integer DedicatedServiceID = Integer.parseInt(request
					.getParameter("DedicatedServiceID"));
			result = s.create(MemberShipCardID, DedicatedServiceID);
		}
		response.getWriter().println(result);
	}

}
