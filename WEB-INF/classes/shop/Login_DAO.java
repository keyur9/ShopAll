package shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login_DAO {
	Connection con;
	Statement st;
	Connection getConnection()
	{
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","keyur");
		return con;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
	public boolean isEmpExist(String uname)
	{
		boolean b=false;
		try{
			con=getConnection();
			st=con.createStatement();
			ResultSet r=st.executeQuery("select * from employee");
			while(r.next())
			{
				String a=r.getString(1);
				if(a.equals(uname))
				{
				b=true;
				}
				
			}
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;
		
	}

}
