<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>

<html>
<head>
<link rel="stylesheet" href="./css/bootstrap.min.css" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show All Field</title>
</head>
	
	<body>
		<%@ include file="_header.jsp" %>
		<div class="container-fluid">
		<div class="panel panel-info">
			<div class="panel-heading">Reservation Detail</div>		
				<table class="table table-bordered table-striped table-hover table-condensed">
        	<thead>
            	<tr>
                	<th>ID</th>
					<th>Customer ID</th>
                	<th>Field ID</th>
					<th>Start Time</th>
					<th>End Time</th>
					<th>Creation Time</th>
					<th>Update Time</th>
                	<th>Info</th>
            	</tr>
        	</thead>
        	
        	<tbody>
                	<tr>
                    	<td><c:out value="${reservation.id}" /></td>
                    	<td><c:out value="${reservation.customer_id}" /></td>
                    	<td><c:out value="${reservation.field_id}" /></td>
                    	<td><c:out value="${reservation.start_time}" /></td>
                    	<td><c:out value="${reservation.end_time}" /></td>
                    	<td><c:out value="${reservation.ctime}" /></td>
                    	<td><c:out value="${reservation.utime}" /></td>
                    	<td><c:out value="${reservation.info}" /></td>
                	</tr>
        	</tbody>
    	</table>
    	</div>
    	</div>
	</body>
</html>
