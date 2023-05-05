package dao;

/**
 *
 * @author Zac Seales
 */
public class DaoFactory {
    
    public static StudentDAO getStudentDAO() {
        return JdbiDaoFactory.getStudentDAO();
        //return new StudentCollectionsDAO();
    }
}
