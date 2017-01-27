<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://bootswatch.com/slate/bootstrap.min.css" />

<title>Welcome</title>
</head>

<body>
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<a class="navbar-brand" href="index.jsp">Codin Sport Center</a>
		</div>
		
		<ul class="nav navbar-nav">
			<li><a href="CustomerServlet.do?action=list">Customers</a></li>
			<li><a href="FieldServlet.do?action=list">Fields</a></li>
		</ul>
		
	</nav>

  <ul class="dropdown-menu">
    <li><a href="#">Action</a></li>
    <li><a href="#">Another action</a></li>
    <li><a href="#">Something else here</a></li>
    <li role="separator" class="divider"></li>
    <li><a href="#">Separated link</a></li>
  </ul>
</div>


</body>
</html>