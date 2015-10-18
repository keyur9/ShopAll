package shop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.Add_Staff_DAO;

/**
 * Servlet implementation class Login_Servlet
 */
public class Login_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_Servlet() {
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
		String uname = (String)request.getParameter("uname");
		//int age = Integer.parseInt(request.getParameter("age"));
		int pwd = Integer.parseInt(request.getParameter("pwd"));
		String type = (String)request.getParameter("type");
		Add_Staff_DAO adao = new Add_Staff_DAO();
		
		if(adao.loginEmp(uname, pwd, type))
		{
			//out.println("valid");
			//request.setAttribute("data", list);
			request.getRequestDispatcher("/Employee.html").forward(request, response);
		}
		else
		{
			out.println("aa");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
