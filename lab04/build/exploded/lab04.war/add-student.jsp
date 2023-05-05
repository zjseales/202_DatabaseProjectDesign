<%-- 
    Document   : add-student
    Created on : 1 Aug 2022, 11:11:43
    Author     : seaza886
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Page</title>
		<link rel="stylesheet" href="css/style.css"/>
	</head>
	<body>
		<main>
			<%@include file="WEB-INF/jspf/navigation.jspf"%>

			<fieldset>

			<legend>Student Details</legend>
			
			<%
				String validation = (String)session.getAttribute("validation");
				validation = validation != null ? validation : "";
			%>

			<p><%= validation %></p>

			<form action="add-student" method="POST">

            <label>ID:</label><input type="number" name="id" required/>
            <label>Name:</label><input type="text" name="name"/>
            <label>Address:</label><textarea type="text" name="address"></textarea>
            <label>Phone Number:</label><input type="tel" name="phoneNumber"/>
            <label>Major:</label><input type="text" name="major"/>

            <button type="submit">Add Student</button>
			</form>

			</fieldset>

			<a class="nav" href="index.jsp">Back to Home</a>

		</main>
	</body>
</html>
