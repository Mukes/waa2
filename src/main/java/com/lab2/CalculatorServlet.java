package com.lab2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CalculatorServlet
 */
@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession httpSession = request.getSession();
		Integer addResult = (Integer) httpSession.getAttribute("addResult");
		Integer mulResult = (Integer) httpSession.getAttribute("mulResult");
		String add1 = (String) httpSession.getAttribute("add1");
		String add2 = (String) httpSession.getAttribute("add2");
		String mul1 = (String) httpSession.getAttribute("mul1");
		String mul2 = (String) httpSession.getAttribute("mul2");
		addResult = (addResult==null)?0:addResult;
		mulResult = (mulResult==null)?0:mulResult;
		add1 = (add1==null)?"":add1;
		add2 = (add2==null)?"":add2;
		mul1 = (mul1==null)?"":mul1;
		mul2 = (mul2==null)?"":mul2;
		request.setAttribute("addResult", addResult);
		request.setAttribute("mulResult", mulResult);
		request.setAttribute("add1", add1);
		request.setAttribute("add2", add2);
		request.setAttribute("mul1", mul1);
		request.setAttribute("mul2", mul2);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		/*PrintWriter out = response.getWriter();
		out.append("<!DOCTYPE html PUBLIC "
				+ "<html>"
				+ "<head>"
				+ "<meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'>"
						+ "<title>Calculator</title>"
						+ "</head>"
						+ "<body>"
						+ "<form method='post' action='/waa/calculate'>"
						+ "<input type='text' name='add_var1' value='"+add1+"'> + <input type='text' name='add_var2' value='"+add2+"'> = <input type='text' name='add_result' value='"+addResult+"'><br>"
						+ "<input type='text' name='mul_var1' value='"+mul1+"'> + <input type='text' name='mul_var2' value='"+mul2+"'> = <input type='text' name='mul_result' value='"+mulResult+"'><br>"
						+ "<input type='submit'>"
						+ "</form>"
						+ "</body>"
						+ "</html>");*/
		httpSession.invalidate();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String add1 = request.getParameter("add_var1");
		String add2 = request.getParameter("add_var2");
		String mul1 = request.getParameter("mul_var1");
		String mul2 = request.getParameter("mul_var2");
		Integer addResult = Integer.parseInt(add1) + Integer.parseInt(add2);
		Integer mulResult = Integer.parseInt(mul1) * Integer.parseInt(mul2);
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("addResult", addResult);
		httpSession.setAttribute("mulResult", mulResult);
		httpSession.setAttribute("add1", add1);
		httpSession.setAttribute("add2", add2);
		httpSession.setAttribute("mul1", mul1);
		httpSession.setAttribute("mul2", mul2);
		System.out.println("Context Path:"+getServletContext().getContextPath());
		response.sendRedirect(getServletContext().getContextPath()+"/calculate");
	}

}
