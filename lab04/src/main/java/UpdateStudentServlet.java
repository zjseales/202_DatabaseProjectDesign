/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import dao.DaoFactory;
import dao.JdbiDaoFactory;
import dao.StudentDAO;
import domain.Student;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author seaza886
 */
@WebServlet(urlPatterns = {"/update-student"})
public class UpdateStudentServlet extends HttpServlet {

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		StudentDAO dao = DaoFactory.getStudentDAO();
                
		HttpSession session = request.getSession();
		Student student = (Student) session.getAttribute("student");
                
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phoneNumber = request.getParameter("phoneNumber");
		
		student.setName(name);
		student.setAddress(address);
		student.setPhoneNumber(phoneNumber);
		
		// save the student
		dao.save(student);
		
		//redirect to index page
		response.sendRedirect("view-students.jsp");
		
	}

}
