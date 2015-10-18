package shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Add_Product_DAO {
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
	
	public void getProdDetails(String name, int qty,int amt)
		{
			try
			{ 
			con =getConnection();
			stmt = con.prepareStatement("insert into product values(?,?,?)");
			 stmt.setString(1,name);
             stmt.setInt(2,qty);
             stmt.setInt(3,amt);
			//list = new ArrayList<Employee>();
			stmt.executeUpdate();			
			}catch(Exception e){e.printStackTrace();}

		}	
	public void updProdDetails(String name,int qty)
	{
		try
		{ 
		con =getConnection();
		stmt = con.prepareStatement("update product set QUANTITY=QUANTITY+"+qty+" where Name='"+name+"' ");
		//stmt.setString(1,name);
		//stmt.setInt(2,qty); 
		
               
		//list = new ArrayList<Employee>();
		stmt.executeUpdate();	
		con.commit();
		//System.out.println("Updating Successfully!");
		}catch(Exception e){e.printStackTrace();}
	}
}
