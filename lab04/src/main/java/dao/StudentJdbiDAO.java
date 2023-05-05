package dao;

import domain.Student;
import java.util.Collection;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.*;

/**
 *
 * @author seaza886
 */
public interface StudentJdbiDAO extends StudentDAO {

	@Override
	@SqlQuery("SELECT * FROM STUDENT WHERE ID = :id")
        @RegisterBeanMapper(Student.class)
	public Student getByID(@Bind("id")Integer studentID);

	@Override
	@SqlQuery ("SELECT * FROM STUDENT ORDER BY ID")
        @RegisterBeanMapper(Student.class)
	public Collection<Student> getAll();

	@Override
	@SqlUpdate("DELETE FROM STUDENT WHERE ID = :id")
	public void delete(@BindBean Student aStudent);

	@Override
	@SqlUpdate("MERGE INTO STUDENT (ID, NAME, PHONE_NUMBER, ADDRESS, MAJOR) KEY (ID)"
                    + " VALUES (:id, :name, :phoneNumber, :address, :major)")
	public void save(@BindBean Student aStudent);
        
        @Override
        @SqlQuery("SELECT * FROM STUDENT WHERE MAJOR = :major")
        @RegisterBeanMapper(Student.class)
        public Collection<Student> filterByMajor(@Bind("major") String major);
        
        @Override
        @SqlQuery("SELECT MAJOR FROM STUDENT")
        public Collection<String> getMajors();
	
}
