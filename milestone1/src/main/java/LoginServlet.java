import dao.CustomerDAO;
import dao.DaoFactory;
import domain.Customer;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Zac Seales - 6687905
 */
@WebServlet(urlPatterns = {"/sign-in"})
public class LoginServlet extends HttpServlet {

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

        CustomerDAO dao = DaoFactory.getCustomerDAO();
             
        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        // Store customer in the session and redirect to products page
        if (dao.isValidLogin(user, pass)) {
            //make validation null so error doesnt show up again.
            request.getSession().setAttribute("validation", null);
            Customer customer = dao.getByUsername(user);
            HttpSession session = request.getSession();
            session.setAttribute("customer", customer);
            response.sendRedirect("browse.jsp");
        } else {
            request.getSession().setAttribute(
                    "validation", "Error: Incorrect Sign-in Details.");
            response.sendRedirect("sign-in.jsp");
        }
    }


}
