package dao;

import domain.Student;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * A DAO that uses collections for storing and managing student objects.
 */
public class StudentCollectionsDAO implements StudentDAO {

	private static final Map<Integer, Student> students = new TreeMap<>();
	private static final Set<String> majors = new TreeSet<>();

	@Override
	public void save(Student aStudent) {
		students.put(aStudent.getId(), aStudent);
		majors.add(aStudent.getMajor());
	}

	@Override
	public void delete(Student aStudent) {
		students.remove(aStudent.getId());
	}

	@Override
	public Collection<Student> getAll() {
		return students.values();
	}

	@Override
	public Collection<String> getMajors() {
		return majors;
	}

	@Override
	public Student getByID(Integer studentID) {
		return students.get(studentID);
	}


}
