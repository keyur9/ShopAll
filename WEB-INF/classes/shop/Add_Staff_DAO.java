package shop;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Add_Staff_DAO {
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
	
	public void getEmpDetails(String uname, int age, String pwd)
		{
		
			try
			{ 
			con =getConnection();
			stmt = con.prepareStatement("insert into employee values(?,?,?)");
			 stmt.setString(1,uname);
             stmt.setInt(2,age);
             stmt.setString(3,pwd);
			//list = new ArrayList<Employee>();
			stmt.executeUpdate();
			
			
			}catch(Exception e){e.printStackTrace();}
		 //return list;
		}	
	public void updEmpDetails(String name,int age)
	{
		try{
			con =getConnection();
			stmt = con.prepareStatement("update employee set AGE="+age+" where USERNAME='"+name+"' ");
			stmt.executeUpdate();	
			con.commit();
			System.out.println("Updating Successfully!");
			}catch(Exception e){e.printStackTrace();}
			 //finally{try{con.close();}catch(Exception e ){e.printStackTrace();}}
	}
	
	public boolean loginEmp(String uname, int pwd, String type)
	{
		//boolean b = false;
		//ArrayList list= null;
		try{
			con=getConnection();
			stmt = con.prepareStatement("select * from employee");
			//stmt.setString(1,uname);
            //stmt.setInt(2,pwd);
            //stmt.setString(4,type);
			rs=stmt.executeQuery();
			
			while(rs.next())
				{
				//Employee e=new Employee();
				String a=rs.getString(1);
				int d=rs.getInt(2);
				String c=rs.getString(4);
				//e.setName(a);
				//e.setPwd(d);
				//e.setType(c);
				//list.add(e);
				if(a.equals(uname) && d==pwd && c.equals(type))
				{
				return true;
				}
				}
			}catch(Exception e){e.printStackTrace();}
		return false;
		
	}
}
