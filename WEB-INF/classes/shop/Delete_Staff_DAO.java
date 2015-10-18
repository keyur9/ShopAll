package shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Delete_Staff_DAO {
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
	public void deleteEmp(String bname)
	{
		try
		{ 
		con =getConnection();
		stmt = con.prepareStatement("delete from employee where USERNAME='"+bname+"'");
		stmt.executeUpdate();
		}catch(Exception e){e.printStackTrace();}
	}
}
