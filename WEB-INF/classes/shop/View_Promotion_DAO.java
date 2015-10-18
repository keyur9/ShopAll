package shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import shop.Promotion;

public class View_Promotion_DAO {
	public class ViewSchemeDAO {
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
			public ArrayList<Promotion> getPromotionDetails(String pname)
		{
			ArrayList<Promotion> list=null;
			try
			{ 
			con =getConnection();
			stmt = con.prepareStatement("select * from promotion where NAME='"+pname+"'");
			list=new ArrayList<Promotion>();
			rs=stmt.executeQuery();
			while(rs.next())
			{
				Promotion p=new Promotion();
				String a=rs.getString(1);
				//int d=rs.getInt(2);
				int c=rs.getInt(3);
				
				p.setPname(a);
				//p.setPrice(d);
				p.setDisc(c);
				
				list.add(p);
			}
			}catch(Exception e){e.printStackTrace();}
			return list;
		}
	
	}
}
