package shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Delete_Product_DAO {
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
	public void deletePro(String pname)
	{
		try
		{ 
		con =getConnection();
		stmt = con.prepareStatement("delete from product where NAME='"+pname+"'");
		stmt.executeUpdate();
		}catch(Exception e){e.printStackTrace();}
	}

}
