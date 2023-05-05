package dao;

import domain.Student;
import java.util.Collection;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsNull.nullValue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentDAOTest {

	private StudentDAO dao;

	private Student s1;
	private Student s2;
	private Student s3;

	@BeforeEach
	public void setUp() {
		dao = new StudentCollectionsDAO();

		s1 = new Student(1111, "S1_NAME", "S1_ADDRESS", "S1_PHONE", "MAJOR1");
		s2 = new Student(2222, "S2_NAME", "S2_ADDRESS", "S2_PHONE", "MAJOR2");
		s3 = new Student(3333, "S3_NAME", "S3_ADDRESS", "S3_PHONE", "MAJOR3");

		dao.save(s1);
		dao.save(s2);

		// intentionally not saving s3
	}

	@AfterEach
	public void tearDown() {
		dao.delete(s1);
		dao.delete(s2);
		dao.delete(s3);
	}

	@Test
	public void testSave() {
		// make sure that s3 does not yet exist
		assertThat(dao.getByID(s3.getId()), is(nullValue()));
		assertThat(dao.getAll(), hasSize(2));

		// save s3
		dao.save(s3);

		// make sure that s3 now exists
		assertThat(dao.getByID(s3.getId()), is(s3));
		assertThat(dao.getAll(), hasSize(3));
	}

	@Test
	public void testDelete() {
		// make sure that s1 already exists
		assertThat(dao.getByID(s1.getId()), is(s1));
		assertThat(dao.getAll(), hasSize(2));

		// delete s1
		dao.delete(s1);

		// make sure that s1 no longer exists
		assertThat(dao.getByID(s1.getId()), is(nullValue()));
		assertThat(dao.getAll(), hasSize(1));
	}

	@Test
	public void testGetAll() {
		Collection<Student> students = dao.getAll();

		assertThat(students, hasSize(2));
		assertThat(students, hasItem(s1));
		assertThat(students, hasItem(s2));

		// make sure that we haven't swapped/lost any fields
		Student result = students.stream().filter(s -> s.getId().equals(s1.getId())).findFirst().get();
		assertThat(result, samePropertyValuesAs(s1));
	}

	@Test
	public void testGetByID() {
		Student result = dao.getByID(s1.getId());

		assertThat(result, is(s1));

		// make sure that we haven't swapped/lost any fields
		assertThat(result, samePropertyValuesAs(s1));
	}

	@Test
	public void testFilterByMajor() {
		assertThat(dao.filterByMajor("MAJOR1"), contains(s1));
		assertThat(dao.filterByMajor("MAJOR2"), contains(s2));
		assertThat(dao.filterByMajor("MAJOR3"), hasSize(0));

		// make sure that we haven't swapped/lost any fields
		Student result = dao.filterByMajor("MAJOR1").stream().filter(s -> s.getId().equals(s1.getId())).findFirst().get();
		assertThat(result, samePropertyValuesAs(s1));
	}

	@Test
	public void testGetMajors() {
		assertThat(dao.getMajors(), contains(s1.getMajor(), s2.getMajor()));
	}

}
