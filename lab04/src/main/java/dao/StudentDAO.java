package dao;

import domain.Student;
import java.util.Collection;

/**
 * A DAO for managing the storage of Student objects.
 */
public interface StudentDAO {

	/**
	 * Adds a student to the DAO.
	 *
	 * @param aStudent The student to add.
	 */
	void save(Student aStudent);

	/**
	 * Deletes a student from the DAO.
	 *
	 * @param aStudent The student to delete.
	 */
	void delete(Student aStudent);

	/**
	 * Returns all students that have been added to the DAO.
	 *
	 * @return The collection of students.
	 */
	Collection<Student> getAll();

	/**
	 * Returns the student matching the given ID.
	 *
	 * @param studentID The ID of the student to retrieve.
	 * @return The collection of majors.
	 */
	Student getByID(Integer studentID);
        
        /**
         * Takes a string parameter that represents a degree major
         * and returns all students with that major.
         * 
         * @param major The major being used to filter students.
         * @return The list of Students with the major given as the argument.
         */
        Collection<Student> filterByMajor(String major);
        
        /**
         * Returns a list of all majors currently being studied by the Students
         * in the system.
         * 
         * @return The list of all majors.
         */
        Collection<String> getMajors();

}
