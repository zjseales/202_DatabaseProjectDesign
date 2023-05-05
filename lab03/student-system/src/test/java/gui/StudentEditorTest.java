package gui;

import dao.StudentDAO;
import domain.Student;
import java.util.ArrayList;
import java.util.Collection;
import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import org.assertj.swing.fixture.DialogFixture;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class StudentEditorTest {

	private StudentDAO dao;
	private DialogFixture fixture;
	private Robot robot;

	@BeforeEach
	public void setUp() {
		robot = BasicRobot.robotWithNewAwtHierarchy();

		// Slow down the robot a little bit - default is 30 (milliseconds).
		// Do NOT make it less than 10 or you will have thread-race problems.
		robot.settings().delayBetweenEvents(30);

		// add some majors for testing with
		Collection<String> majors = new ArrayList<>();
		majors.add("Knitting");
		majors.add("Ninjutsu");

		// create a mock for the DAO
		dao = mock(StudentDAO.class);

		// stub the getMajors method to return the test majors
		when(dao.getMajors()).thenReturn(majors);
	}

	@AfterEach
	public void tearDown() {
		// clean up fixture so that it is ready for the next test
		fixture.cleanUp();
	}


	@Test
	public void testSave() {
		// create the dialog passing in the mocked DAO
		StudentEditor dialog = new StudentEditor(null, true, dao);
		//StudentEditor dialog = new StudentEditor(null, true);

		// use AssertJ to control the dialog
		fixture = new DialogFixture(robot, dialog);

		// show the dialog on the screen, and ensure it is visible
		fixture.show().requireVisible();

		// click the dialog to ensure the robot is focused in the correct window
		// (can get confused by multi-monitor and virtual desktop setups)
		fixture.click();

		// enter some details into the UI components
		fixture.textBox("txtId").enterText("11111");
		fixture.textBox("txtName").enterText("Jack");
		fixture.comboBox("cmbMajor").selectItem("Knitting");

		// click the save button
		fixture.button("btnSave").click();

		// create a Mockito argument captor to use to retrieve the passed student from the mocked DAO
		ArgumentCaptor<Student> argument = ArgumentCaptor.forClass(Student.class);

		// verify that the DAO.save method was called, and capture the passed student
		verify(dao).save(argument.capture());

		// retrieve the passed student from the captor
		Student savedStudent = argument.getValue();

		// test that the student's details were properly saved
		assertThat("Ensure the ID was saved", savedStudent, hasProperty("id", equalTo(11111)));
		assertThat("Ensure the name was saved", savedStudent, hasProperty("name", equalTo("Jack")));
		assertThat("Ensure the major was saved", savedStudent, hasProperty("major", equalTo("Knitting")));
	}

}
