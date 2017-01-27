<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Welcome</title>
</head>

<body>
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="index.jsp">Codin Sport Center</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="CustomerServlet.do?action=list">Customer</a></li>
			<li><a href="FieldServlet.do?action=list">Field</a></li>
		</ul>
	</div>
	</nav>
	<div class="container-fluid col-md-4">
		<div class="panel panel-info">
			<div class="panel-heading">Customer List</div>
			<div class="panel-body">
				<table class="table table-bordered table-striped table-hover">
					<thead>
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email</th>
							<th colspan="3">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${customers}" var="customer">
							<tr>
								<td><c:out value="${customer.firstname}" /></td>
								<td><c:out value="${customer.lastname}" /></td>
								<td><c:out value="${customer.email}" /></td>
								<td>
									<a class="btn btn-primary" href="CustomerServlet.do?action=view&id=<c:out value="${customer.id}"/>">View</a>
									<a class="btn btn-warning" href="CustomerServlet.do?action=edit&id=<c:out value="${customer.id}"/>">Update</a>
									<a class="btn btn-danger" href="CustomerServlet.do?action=delete&id=<c:out value="${customer.id}"/>">Delete</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<a class="btn btn-block btn-success" href="CustomerServlet.do?action=insert">Add New Customer</a>					
			</div>
		</div>
	</div>
</body>
</html>