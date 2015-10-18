package shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.Employee;
import shop.Login_DAO;
import shop.View_Staff_DAO;

/**
 * Servlet implementation class View_Staff_Servlet
 */
public class View_Staff_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public View_Staff_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String uname = (String)request.getParameter("name");
		Login_DAO logindao=new Login_DAO();
		boolean b=logindao.isEmpExist(uname);
		if(b)
		{
			View_Staff_DAO vdao=new View_Staff_DAO();
			ArrayList<Employee> list=vdao.getEmpDetails(uname);
			request.setAttribute("list",list);
			RequestDispatcher rd= request.getRequestDispatcher("/View_Staff.jsp");
			rd.forward(request,response);
		}
		else
		{
			out.println("no such name found");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
