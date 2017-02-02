<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>

<html>
	<head>
		<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css" />
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Show All Field</title>
	</head>
	
	<body>
		<%@ include file="_header.jsp" %>
		<div class="container-fluid">
		<div class="panel panel-info">
			<div class="panel-heading">Field Detail</div>		
				<table class="table table-bordered table-striped table-hover table-condensed">
	
        	<thead>
            	<tr>
                	<th>ID</th>
                	<th>Name</th>
                	<th>Sport I</th>
                	<th>Sport II</th>
                	<th>Sport III</th>
                	<th>Sport IV</th>
            	</tr>
        	</thead>
        	
        	<tbody>
                	<tr>
                    	<td><c:out value="${field.id}" /></td>
                    	<td><c:out value="${field.name}" /></td>
                    	<td><c:out value="${field.sports[0]}" /></td>
                    	<td><c:out value="${field.sports[1]}" /></td>
                    	<td><c:out value="${field.sports[2]}" /></td>
                    	<td><c:out value="${field.sports[3]}" /></td>
                	</tr>
        	</tbody>
    	</table>
    	</div>
    	</div>
	</body>
</html>
