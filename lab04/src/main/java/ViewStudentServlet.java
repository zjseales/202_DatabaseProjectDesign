/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import dao.DaoFactory;
import dao.JdbiDaoFactory;
import dao.StudentCollectionsDAO;
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
@WebServlet(urlPatterns = {"/view-student"})
public class ViewStudentServlet extends HttpServlet {

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
		
		// extract the id
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		// get the student
		Student student = dao.getByID(id);
		
		HttpSession session = request.getSession();
		session.setAttribute("student", student);
		
		//redirect to index page
		response.sendRedirect("view-student-details.jsp");
	}

}
