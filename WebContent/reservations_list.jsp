<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Welcome</title>
</head>

<body>

	<%@ include file="_header.jsp" %>

	<div class="container-fluid">
		<div class="panel panel-info">
			<div class="panel-heading">Reservation List</div>
			<div class="panel-body">
				<table class="table table-bordered table-striped table-hover">
					<thead>
						<tr>
							<th>Customer ID</th>
							<th>Field ID</th>
							<th>Start Time</th>
							<th>End Time</th>
							<th >Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${reservations}" var="reservation">
							<tr>
								<td><c:out value="${reservation.customer_id}" /></td>
								<td><c:out value="${reservation.field_id}" /></td>
								<td><c:out value="${reservation.start_time}" /></td>
								<td><c:out value="${reservation.end_time}" /></td>
								<td>
									<a class="btn btn-primary" href="ReservationServlet.do?action=view&id=<c:out value="${reservation.id}"/>">
										<span class="glyphicon glyphicon-search" aria-hidden="true"></span>																	
									</a>
									<a class="btn btn-warning" href="ReservationServlet.do?action=edit&id=<c:out value="${reservation.id}"/>">
										<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
									</a>																	
									<a class="btn btn-danger" href="ReservationServlet.do?action=delete&id=<c:out value="${reservation.id}"/>">
										<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>								
									</a>
						
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<a class="btn btn-block btn-success" href="ReservationServlet.do?action=insert">Add New Reservation</a>					
			</div>
		</div>
	</div>
</body>
</html>
