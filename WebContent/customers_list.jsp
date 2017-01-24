<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Show All Customer</title>
	</head>
	
	<body>
    	<table>
        	<thead>
            	<tr>
                	<th>ID</th>
                	<th>First Name</th>
                	<th>Last Name</th>
                	<th>E-Mail</th>
                	<th colspan="2">Action</th>
            	</tr>
        	</thead>
        	
        	<tbody>
            	<c:forEach items="${customers}" var="customer">
                	<tr>
                    	<td><c:out value="${customer.id}" /></td>
                    	<td><c:out value="${customer.firstname}" /></td>
                    	<td><c:out value="${customer.lastname}" /></td>
                    	<td><c:out value="${customer.email}" /></td>
                    	<td>
                    		<a href="CustomerServlet.do?action=edit&id=<c:out value="${customer.id}"/>">Update</a>
                    	</td>
                    	<td>
                    	    <a href="CustomerServlet.do?action=delete&id=<c:out value="${customer.id}"/>">Delete</a>
						</td>                    	                    	
                	</tr>
            	</c:forEach>
        	</tbody>
    	</table>
    	
    	<p><a href="CustomerServlet.do?action=insert">Add Student</a></p>
	</body>
</html>