<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">		
		
		<title>Add New Field</title>
	</head>
	<body>
		<%@ include file="_header.jsp" %>
    	<form action="FieldServlet.do" method="post">
        	<fieldset>           
	            <div>
	                <label for="id">Field ID</label> 
	                <input type="text" name="id" value="<c:out value="${field.id}" />" readonly="readonly" placeholder="ID" />
	            </div>
	           
	            <div>
	                <label for="name">Name</label> 
	                <input type="text" name="name" value="<c:out value="${field.name}" />" placeholder="Name" />
	            </div>
	           
	            <div>
	                <label for="sport_000">Sport I</label> 
	                <input type="text" name="sport_000" value="<c:out value="${field.sports[0]}" />" placeholder="I Sport" />
	            </div>
	
		        <div>
	                <label for="sport_001">Sport II</label> 
	                <input type="text" name="sport_001" value="<c:out value="${field.sports[1]}" />" placeholder="II Sport" />
	            </div>
	            
	            <div>
	                <label for="sport_002">Sport III</label> 
	                <input type="text" name="sport_002" value="<c:out value="${field.sports[2]}" />" placeholder="III Sport" />
	            </div>
	            
	           	<div>
	                <label for="sport_003">Sport IV</label> 
	                <input type="text" name="sport_003" value="<c:out value="${field.sports[3]}" />" placeholder="IV Sport" />
	            </div>
	            
	            <div>
	                <input type="submit" value="Submit" />
	            </div>
        	</fieldset>
    	</form>
	</body>
</html>
