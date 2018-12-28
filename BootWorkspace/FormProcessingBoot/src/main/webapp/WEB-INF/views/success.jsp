<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="edu.aspire.view.vo.Customer"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<%
	Customer cust = (Customer) request.getAttribute("customer");
	out.println("Customer ID is:"+cust.getCid());
%>

</body>
</html>