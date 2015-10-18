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
<h1><font color="green"><u>Product details</u></font></h1>
<table border=10>
<% ArrayList<View_Product> list=(ArrayList<View_Product>)request.getAttribute("list");
for(int i=0;i<list.size();i++){
	View_Product p=list.get(i);%>
<tr>
<td><%= p.getPname()%></td>
<td><%= p.getQty()%></td>
<td><%= p.getAmt()%></td>
</tr>
<%}%>
</table>
</body>
</html>