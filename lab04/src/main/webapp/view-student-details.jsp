<%-- 
    Document   : view-student-details
    Created on : 8 Aug 2022, 10:39:07
    Author     : seaza886
--%>

<%@page import="domain.Student"%>
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

			
			<%
				Student student = (Student)session.getAttribute("student");
			%>

			<fieldset>

			<legend>Student Details</legend>

			<form action="update-student" method="POST">

            <label>Name:</label><input type="text" name="name" value="<%= student.getName() %>" />
            <label>Address:</label><textarea name="address"><%= student.getAddress() %></textarea>
            <label>Phone Number:</label><input name="phoneNumber" value="<%= student.getPhoneNumber() %>" />
            <label>Major:</label><input name="major" value="<%= student.getMajor() %>" />

            <button type="submit">Edit Student Details</button>
			</form>
			
			

			</fieldset>

			<a class="nav" href="index.jsp">Back to Home</a>

		</main>
	</body>
</html>
