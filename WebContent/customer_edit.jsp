<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>

<html>
	<head>
		<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css" />
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">		
		
		<title>Add New Customer</title>
	</head>
	<body>
		<%@ include file="_header.jsp" %>
    	<form action="CustomerServlet.do" method="post">
        	<fieldset>
	            <div class="form-group">
	                <label for="firstname">Your Name</label> 
	                <input type="text" class="form-control" name="firstname" value="<c:out value="${customer.firstname}" />" placeholder="first" />
	                <input type="text" class="form-control" name="lastname" value="<c:out value="${customer.lastname}" />" placeholder="last" />
	            </div>
	
	            <div class="form-group">
	                <label for="email">Email</label> 
	                <input type="email" class="form-control" name="email" value="<c:out value="${customer.email}" />" placeholder="name@example.com" />
	            </div>
	
                <button type="submit" class="btn btn-primary">Submit</button>
        	</fieldset>
    	</form>
	</body>
</html>
