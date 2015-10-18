<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*,shop.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1><font color="green"><u>Staff details</u></font></h1>
<table border=2>
<% ArrayList<Employee> list=(ArrayList<Employee>)request.getAttribute("list");
for(int i=0;i<list.size();i++){
	Employee e=list.get(i);%>
<tr>
<td><%= e.getName()%></td>
<td><%= e.getAge()%></td>
<td><%= e.getPwd()%></td>
<td><%= e.getType()%></td>
</tr>
<%}%>
</table>
</body>
</html>