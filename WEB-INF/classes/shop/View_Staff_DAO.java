package shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import shop.Employee;

public class View_Staff_DAO {
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
	public ArrayList<Employee> getEmpDetails(String uname)
	{
		ArrayList<Employee> list=null;
		try
		{ 
		con =getConnection();
		stmt = con.prepareStatement("select * from employee where USERNAME='"+uname+"'");
		list=new ArrayList<Employee>();
		rs=stmt.executeQuery();
		while(rs.next())
		{
			Employee e=new Employee();
			String a=rs.getString(1);
			int d=rs.getInt(2);
			String c = rs.getString(3);
			//String g=rs.getString(4);
			e.setName(a);
			e.setAge(d);
			e.setPwd(c);
			//e.setType(g);
			list.add(e);
		}
		}catch(Exception e){e.printStackTrace();}
		return list;
	}

}
