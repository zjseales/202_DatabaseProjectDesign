import dao.CustomerDAO;
import dao.DaoExceptionMapper;
import dao.DaoFactory;
import domain.Customer;
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
 *
 * @author Zac Seales
 */
@WebServlet(urlPatterns = {"/create-account"})
public class CreateAccountServlet extends HttpServlet {

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
        try {

            CustomerDAO dao = DaoFactory.getCustomerDAO();

            String firstName = request.getParameter("firstName");
            String surname = request.getParameter("surname");
            String username = request.getParameter("username");
            String emailAddress = request.getParameter("emailAddress");
            String shippingAddress = request.getParameter("shippingAddress");
            String password = request.getParameter("password");

            Customer customer = new Customer(firstName, surname, username, password, shippingAddress, emailAddress);
            
            new Validator().assertValid(customer);
            
            //save the customer
            dao.save(customer);
            request.getSession().setAttribute("validation", null);
            //redirect to index page
            response.sendRedirect("index.jsp");
            
        //ID must be a number
        } catch (NumberFormatException e) {
            HttpSession session = request.getSession();
            session.setAttribute("validation", "You have entered an invalid ID");
            response.sendRedirect("index.jsp");
        // username, password, and ID can not be null
        } catch (ConstraintsViolatedException e) {
            ConstraintViolation[] violations = e.getConstraintViolations();
            
            String msg = "Please correct the following input problems:";
            msg += "<ul>";
            for (ConstraintViolation cv : violations) {
                msg += "<li>" + cv.getMessage() + "</li>";
            }
            msg += "</ul>";
            request.getSession().setAttribute("validation", msg);
            response.sendRedirect("create-account.jsp");
            
        } catch (Exception ex) {
            String msg = new DaoExceptionMapper().messageFromException(ex);
            request.getSession().setAttribute("validation", msg);
            response.sendRedirect("create-account.jsp");
        }
        
    }

}
