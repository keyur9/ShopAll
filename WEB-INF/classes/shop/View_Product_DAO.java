package shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import shop.View_Product;

public class View_Product_DAO {
	Connection con;
	PreparedStatement stmt;
	ResultSet rs;
	Connection getConnection()
	{
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","keyur");	
	
		}catch(Exception e)
		{e.printStackTrace();
			}
		return con;
	}
	public ArrayList<View_Product> getProductDetails(String pname)
	{
		ArrayList<View_Product> list=null;
		try
		{ 
		con =getConnection();
		stmt = con.prepareStatement("select * from product where NAME='"+pname+"'");
		list=new ArrayList<View_Product>();
		rs=stmt.executeQuery();
		while(rs.next())
		{
			View_Product p=new View_Product();
			String a=rs.getString(1);
			int d=rs.getInt(2);
			int c=rs.getInt(3);
			
			p.setPname(a);
			p.setQty(d);
			p.setAmt(c);
			
			list.add(p);
		}
		}catch(Exception e){e.printStackTrace();}
		return list;
	}

}
