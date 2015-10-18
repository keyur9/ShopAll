package shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.Product_Login_DAO;
import shop.View_Product;
import shop.View_Product_DAO;

/**
 * Servlet implementation class View_Product_Servlet
 */
public class View_Product_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public View_Product_Servlet() {
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
		String pname = (String)request.getParameter("name");
		Product_Login_DAO plogindao=new Product_Login_DAO();
		boolean b=plogindao.isProductExist(pname);
		if(b)
		{
			View_Product_DAO vdao=new View_Product_DAO();
			ArrayList<View_Product> list=vdao.getProductDetails(pname);
			request.setAttribute("list",list);
			RequestDispatcher rd= request.getRequestDispatcher("/View_Product.jsp");
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
