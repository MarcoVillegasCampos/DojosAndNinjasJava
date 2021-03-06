<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	</head>
	<body>
		<div class="container">
			<h1>NEW NINJA</h1>
			<form:form  action="/ninjas/new" method="post" modelAttribute="form">
				<p>
			       	<form:label class="form-label" path="dojo">Dojo:</form:label>
			        <form:errors path="dojo"/>
			        <form:select class="form-control" path="dojo">
			        	<c:forEach items="${dojos}" var="dojo" >
			        		<option value="${dojo.id}">${dojo.name}</option>
			        	</c:forEach>
			        </form:select>
    			</p>
			
    			<p>
			       	<form:label class="form-label" path="firstName">First Name:</form:label>
			        <form:errors path="firstName"/>
			        <form:input class="form-control" path="firstName"/>
    			</p>
    				<p>
			       	<form:label class="form-label" path="lastName">Last Name:</form:label>
			        <form:errors path="lastName"/>
			        <form:input class="form-control" path="lastName"/>
    			</p>
    				<p>
			       	<form:label class="form-label" path="age">Age</form:label>
			        <form:errors path="age"/>
			        <form:input type="number" class="form-control" path="age"/>
    			</p>
    	
    		
 				<button class="btn btn-success">Create</button>
			</form:form> 
		</div>

	</body>
</html>