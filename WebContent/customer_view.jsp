<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css" />
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Show All Customer</title>
	</head>
	
	<body>
		<%@ include file="_header.jsp" %>
    	<div class="container-fluid">
		<div class="panel panel-info">
			<div class="panel-heading">Customer Detail</div>		
				<table class="table table-bordered table-striped table-hover table-condensed">
	
        	<thead>
            	<tr>
                	<th>ID</th>
                	<th>First Name</th>
                	<th>Last Name</th>
                	<th>E-Mail</th>
            	</tr>
        	</thead>
        	
        	<tbody>
                	<tr>
                    	<td><c:out value="${customer.id}" /></td>
                    	<td><c:out value="${customer.firstname}" /></td>
                    	<td><c:out value="${customer.lastname}" /></td>
                    	<td><c:out value="${customer.email}" /></td>                    	                    	
                	</tr>
        	</tbody>
    	</table>
    	</div>
		</div>
	</body>
</html>