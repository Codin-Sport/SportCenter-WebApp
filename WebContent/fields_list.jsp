<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" href="https://bootswatch.com/slate/bootstrap.min.css" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">




<title>Welcome</title>
</head>

<body>
	<%@ include file="_header.jsp" %>
	<div class="container-fluid">
		<div class="panel panel-info">
			<div class="panel-heading">Field List</div>
				<table class="table table-bordered table-striped table-hover table-condensed">
					<thead>
						<tr>
		                	<th>Name</th>
		                	<th>Sport I</th>
		                	<th>Sport II</th>
		                	<th>Sport III</th>
		                	<th>Sport IV</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${fields}" var="field">
							<tr>
								<td><c:out value="${field.name}" /></td>
								<td><c:out value="${field.sports[0]}" /></td>
								<td><c:out value="${field.sports[1]}" /></td>
								<td><c:out value="${field.sports[2]}" /></td>
								<td><c:out value="${field.sports[3]}" /></td>
								<td>
									<a class="btn btn-primary" href="FieldServlet.do?action=view&id=<c:out value="${field.id}"/>">
										<span class="glyphicon glyphicon-search" aria-hidden="true"></span>																	
									</a>
									
									<a class="btn btn-warning" href="FieldServlet.do?action=edit&id=<c:out value="${field.id}"/>">
										<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
									</a>																	
									
									<a class="btn btn-danger" href="FieldServlet.do?action=delete&id=<c:out value="${field.id}"/>">
										<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>								
									</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="panel-footer">		
					<a class="btn btn-block btn-success" href="FieldServlet.do?action=insert">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>																						
					Add New Field</a>				
				</div>	
			</div>
		</div>
</body>
</html>