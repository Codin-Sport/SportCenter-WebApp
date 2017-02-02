<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="./css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
<title>Add New Customer</title>
</head>
<body>
	<%@ include file="_header.jsp"%>
	<form action="ReservationServlet.do" method="post">
		<div class="form-group">
			<label for="customer_id">Select customer email:</label> <select
				class="form-control" id="customer_id" name="customer_id">
				<option>--</option>
				<c:forEach items="${customers}" var="customer">
					<option>${customer.id}:${customer.email}</option>
				</c:forEach>
			</select> <label for="field_id">Select field:</label> <select
				class="form-control" id="field_id" name="field_id">
				<option>--</option>
				<c:forEach items="${fields}" var="field">
					<option>${field.id}:${field.name}</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
			<label for="start_time">Start time:</label> <input type="datetime-local" class="form-control"
				name="start_time" /> <label for="end_time">End time:</label> <input type="datetime-local"
				class="form-control" name="end_time" />
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</body>
</html>