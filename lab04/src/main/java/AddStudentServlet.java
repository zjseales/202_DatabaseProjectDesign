/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import dao.DaoExceptionMapper;
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
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import net.sf.oval.exception.ConstraintsViolatedException;

/**
 * @author seaza886
 */
@WebServlet(urlPatterns = {"/add-student"})
public class AddStudentServlet extends HttpServlet {

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
		
		try{
			StudentDAO dao = DaoFactory.getStudentDAO();
		
			// extract the form data
			Integer id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String phoneNumber = request.getParameter("phoneNumber");
                        String major = request.getParameter("major");

			// create the student object
			Student student = new Student(id, name, address, phoneNumber, major);
                        
         //ensure student contains valid variables
         new Validator().assertValid(student);
                        
			// save the student
			dao.save(student);

			//redirect to index page
			response.sendRedirect("index.jsp");
		} catch (NumberFormatException e){
			HttpSession session = request.getSession();
			session.setAttribute("validation", "You have entered an invalid ID.");
			
			//redirect to index page
			response.sendRedirect("add-students.jsp");
		} catch (ConstraintsViolatedException e) {
         ConstraintViolation[] violations;
         violations = e.getConstraintViolations();
                        
         String msg = "Please fix the following input errors:";
                        
         msg += "<ul>";
                        
         for (ConstraintViolation cv : violations) {
            msg += "<li>" + cv.getMessage() + "</li>";
         }
         msg += "<ul>";
                        
         request.getSession().setAttribute("validation", msg);
			response.sendRedirect("add-student.jsp");
        } catch (Exception ex) {
    String msg = new DaoExceptionMapper().messageFromException(ex);
    request.getSession().setAttribute("validation", msg);
    response.sendRedirect("add-student.jsp");
}
    }

}
