package shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.Promotion;
import shop.Scheme_Exist_DAO;
import shop.View_Promotion_DAO;

/**
 * Servlet implementation class View_Promotion_Servlet
 */
public class View_Promotion_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public View_Promotion_Servlet() {
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
		Scheme_Exist_DAO sdao=new Scheme_Exist_DAO();
		boolean b=sdao.isProductExist(pname);
		if(b)
		{
			View_Promotion_DAO vdao= new View_Promotion_DAO();
			ArrayList<Promotion> list=vdao.getPromotionDetails(pname);
			request.setAttribute("list",list);
			RequestDispatcher rd= request.getRequestDispatcher("/View_Promotion.jsp");
			rd.forward(request,response);
		}
		else
		{
			out.println("no such product found");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
