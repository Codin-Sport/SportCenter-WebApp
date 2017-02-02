<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>

<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Add New Field</title>
</head>
<body>
	<%@ include file="_header.jsp"%>
	<form action="FieldServlet.do" method="post">
		<fieldset>

			<div class="form-group">
				<label for="name">Name</label> <input type="text"
					class="form-control" name="name"
					value="<c:out value="${field.name}" />" placeholder="Name" />
			</div>

			<div class="form-group">
				<label for="sports">Sports</label> <input type="text"
					class="form-control" name="sport_000"
					value="<c:out value="${field.sports[0]}" />" placeholder="Sport I" />
				<input type="text" class="form-control" name="sport_001"
					value="<c:out value="${field.sports[1]}" />" placeholder="Sport II" />
				<input type="text" class="form-control" name="sport_002"
					value="<c:out value="${field.sports[2]}" />"
					placeholder="Sport III" /> <input type="text" class="form-control"
					name="sport_003" value="<c:out value="${field.sports[3]}" />"
					placeholder="Sport IV" />
			</div>


			<button type="submit" class="btn btn-primary">Submit</button>

		</fieldset>
	</form>
</body>
</html>
