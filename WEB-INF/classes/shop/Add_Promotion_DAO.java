package shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Add_Promotion_DAO {
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
	
	public void getPromDetails(int P_ID, String name, int dis)
		{
			try
			{ 
			con =getConnection();
			stmt = con.prepareStatement("insert into promotion values(?,?,?)");
			 stmt.setInt(1,P_ID);
             stmt.setString(2,name);
             stmt.setInt(3,dis);
			//list = new ArrayList<Employee>();
			stmt.executeUpdate();			
			}catch(Exception e){e.printStackTrace();}

		}	
	public void updPromDetails(String name,int dis)
		{
		try{
		con =getConnection();
		stmt = con.prepareStatement("update promotion set DISCOUNT="+dis+" where NAME='"+name+"' ");
		stmt.executeUpdate();	
		con.commit();
		//System.out.println("Updating Successfully!");
		}catch(Exception e){e.printStackTrace();}
		 //finally{try{con.close();}catch(Exception e ){e.printStackTrace();}}
		}
}
