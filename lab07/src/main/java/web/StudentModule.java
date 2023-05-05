package web;

import dao.StudentDAO;
import domain.Student;
import io.jooby.Jooby;
import io.jooby.StatusCode;
import java.util.Collection;

/**
 *
 * @author Zac Seales - 6687905
 */
public class StudentModule extends Jooby {

    public StudentModule(StudentDAO dao) {
        
        //retrieve all students in the database.
        get("/api/students", ctx -> dao.getAll());
		  
		  // retrieve all student majors
		  get("/api/majors", ctx -> dao.getMajors());
		  
		  // retrieve students filtered by major
		  get("/api/majors/{major}", ctx -> {
			   
			  String major = ctx.path("major").value();
			  
			  Collection<Student> students = dao.filterByMajor(major);
			  
			  // no students with specified major found.
			  if(students == null) {
                return ctx.send(StatusCode.NOT_FOUND); //404 error
            } else {
                return students;
            }
			  
		  });
        
        //retrieve a student by id
        get("/api/students/{id}", ctx -> {

            Integer id = ctx.path("id").intValue();

            Student student = dao.getByID(id);

            if(student == null) {
                // no student with that ID found, so return a 404/Not Found error
                return ctx.send(StatusCode.NOT_FOUND);
            } else {
                return student;
            }
        });
        
        //create a student
        post("/api/students", ctx -> {
            Student student = ctx.body().to(Student.class);
            dao.save(student);
            return ctx.send(StatusCode.CREATED);
        });
    }//end constructor
    
}//end StudentModule class
