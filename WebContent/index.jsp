<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />

<title>Welcome</title>
</head>

<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
          <a class="navbar-brand" href="index.jsp">Codin Sport Center</a>   
	</div>
	<ul class="nav navbar-nav">
	 	<li><a href="CustomerServlet.do?action=list">Customer</a></li>
	 	<li><a href="FieldServlet.do?action=list">Field</a></li>
	</ul>	
</div>
</nav>
</body>
</html>