package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import controller.PaymentMethodController;
import controller.PaymentRecordController;

@SuppressWarnings("serial")
@WebServlet("/PaymentRecordServlet")
public class PaymentRecordServlet extends HttpServlet {

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

		PaymentRecordController p = new PaymentRecordController();
		String action = request.getParameter("action");
		String result = null;
		if ("list".equals(action)) {
			result = p.list();
		} else if ("listEmployeeID".equals(action)) {
			Integer EmployeeID = Integer.parseInt(request
					.getParameter("EmployeeID"));
			result = p.listEmployeeID(EmployeeID);
		} else if ("listPaymentMethodID".equals(action)) {
			Integer PaymentMethodID = Integer.parseInt(request
					.getParameter("PaymentMethodID"));
			result = p.listPaymentMethodID(PaymentMethodID);
		} else if ("listUserID".equals(action)) {
			Integer UserID = Integer.parseInt(request.getParameter("UserID"));
			result = p.listUserID(UserID);
		} else if ("create".equals(action)) {
			Integer PaymentMethodID = Integer.parseInt(request
					.getParameter("PaymentMethodID"));
			Integer EmployeeID = Integer.parseInt(request
					.getParameter("EmployeeID"));
			Integer ServiceTicketID = Integer.parseInt(request
					.getParameter("ServiceTicketID"));
			Double amount = Double.valueOf(request.getParameter("amount"));
			result = p.create(PaymentMethodID, EmployeeID, ServiceTicketID,
					amount);
		}
		response.getWriter().println(result);
	}
}
