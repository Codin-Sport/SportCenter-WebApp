<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">		
		
		<title>Add New Customer</title>
	</head>
	<body>
		<%@ include file="_header.jsp" %>
    	<form action="CustomerServlet.do" method="post">
        	<fieldset>           
	            <div>
	                <label for="id">Customer ID</label> 
	                <input type="text" name="id" value="<c:out value="${customer.id}" />" readonly="readonly" placeholder="ID" />
	            </div>
	           
	            <div>
	                <label for="firstname">First Name</label> 
	                <input type="text" name="firstname" value="<c:out value="${customer.firstname}" />" placeholder="First Name" />
	            </div>
	
	            <div>
	                <label for="lastname">Last Name</label> 
	                <input type="text" name="lastname" value="<c:out value="${customer.lastname}" />" placeholder="Last Name" />
	            </div>
	            
	            <div>
	                <label for="email">Email</label> 
	                <input type="text" name="email" value="<c:out value="${customer.email}" />" placeholder="E-Mail" />
	            </div>
	
	            <div>
	                <input type="submit" value="Submit" />
	            </div>
        	</fieldset>
    	</form>
	</body>
</html>
