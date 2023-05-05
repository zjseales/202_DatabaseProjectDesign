<%-- 
    Document   : view-students
    Created on : 1 Aug 2022, 11:14:59
    Author     : seaza886
--%>

<%@page import="java.util.Collection"%>
<%@page import="dao.DaoFactory"%>
<%@page import="dao.StudentDAO"%>
<%@page import="dao.JdbiDaoFactory"%>
<%@page import="domain.Student"%>
<%@page import="dao.StudentJdbiDAO"%>
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

    <h1>Students</h1>
    
    <a href="view-students.jsp?major=All"><button>All</button></a>

<%
    StudentDAO dao = DaoFactory.getStudentDAO();
    
    Collection<String> majors = dao.getMajors();

    for (String major : majors) {
%>
    <a href="view-students.jsp?major=<%= major %>"><button><%= major %></button></a>
<%
    }
%>

    <table>
         <thead>
              <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Address</th>
                    <th>Phone Number</th>
                    <th>Major</th>
              </tr>
         </thead>
         <tbody>
            <%  
                String major = request.getParameter("major");
                Collection<Student> students;
                
                if (major == null || major.equals("All")){
                    students = dao.getAll();
                } else {
                    students = dao.filterByMajor(major);
                }

                for (Student student : students) {
            %>
            <tr>
                <td><%= student.getId() %></td>
                <td><%= student.getName() %></td>
                <td><%= student.getAddress() %></td>
                <td><%= student.getPhoneNumber() %></td>
                <td><%= student.getMajor() %></td>
					 <td><form action="view-student" method="POST"><input type="hidden" name="id" value="<%= student.getId() %>"><button>Update</button></form></td>
            </tr>
            <%
                }
            %>
         </tbody>
    </table>

    <a class="nav" href="index.jsp">Back to Menu</a>
</main>
	</body>
</html>
