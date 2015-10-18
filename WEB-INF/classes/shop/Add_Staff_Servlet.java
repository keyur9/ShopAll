package shop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.Add_Staff_DAO;

/**
 * Servlet implementation class Add_Staff_DAO
 */
public class Add_Staff_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String uname = (String)request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String pwd = (String)request.getParameter("pwd");
		Add_Staff_DAO adao = new Add_Staff_DAO();
		adao.getEmpDetails(uname, age, pwd);
		out.println("Successfully Added!!");
		out.println("<html><body><a href='Store_Manager.html'>Click to go back to Sales page</a></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
