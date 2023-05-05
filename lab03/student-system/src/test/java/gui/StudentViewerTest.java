package gui;

import dao.StudentDAO;
import domain.Student;
import gui.helpers.SimpleListModel;
import java.util.ArrayList;
import java.util.Collection;
import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import org.assertj.swing.fixture.DialogFixture;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class StudentViewerTest {

        private Collection<Student> students = new ArrayList<>();
        
        private Student s1;
        private Student s2;
        
	private StudentDAO dao;
	private DialogFixture fixture;
	private Robot robot;

	@BeforeEach
	public void setUp() {
		robot = BasicRobot.robotWithNewAwtHierarchy();

		// Slow down the robot a little bit - default is 30 (milliseconds).
		// Do NOT make it less than 10 or you will have thread-race problems.
		robot.settings().delayBetweenEvents(30);
                
                // add some Students for testing with
		//Collection<Student> students = new ArrayList<>();
                s1 = new Student(1234, "name one", "Comp Sci");
                s2 = new Student(2468, "name two", "Economics");
		students.add(s1);
		students.add(s2);

		// create a mock for the DAO
		dao = mock(StudentDAO.class);
                
                when(dao.getAll()).thenReturn(students);
                when(dao.getByID(1234)).thenReturn(s1);
                when(dao.getByID(2468)).thenReturn(s2);

	}

	@AfterEach
	public void tearDown() {
		// clean up fixture so that it is ready for the next test
		fixture.cleanUp();
	}

	@Test
	public void testView() {
            
            // create the dialog passing in the mocked DAO
            StudentViewer dialog = new StudentViewer(null, true, dao);
            
            fixture = new DialogFixture(robot, dialog);
            // show the dialog on the screen, and ensure it is visible
            fixture.show().requireVisible();
            verify(dao).getAll();
            
            SimpleListModel model = (SimpleListModel)
            fixture.list("lstStudents").target().getModel();
            
            assertThat(model, containsInAnyOrder(s1, s2));
            
	}

	@Test
	public void testSearch() {
            
            StudentViewer dialog = new StudentViewer(null, true, dao);
            
            fixture = new DialogFixture(robot, dialog);
            fixture.show().requireVisible();
            verify(dao).getAll();
            //focus on the correct window
            fixture.click();

            // enter an id number into the search box
            fixture.textBox("txtID").enterText("1234");
            
            //click the search button
            fixture.button("btnSearch").click();
            
            //get the list contents
            SimpleListModel model = (SimpleListModel)
            fixture.list("lstStudents").target().getModel();
            
            //test against expected results
            assertThat(model, containsInAnyOrder(s1));
            
            //try again with student 2 for a more comprehensive test
            fixture.textBox("txtID").deleteText();
            fixture.textBox("txtID").enterText("2468");
            fixture.button("btnSearch").click();
            model = (SimpleListModel)
            fixture.list("lstStudents").target().getModel();
            
            assertThat(model, containsInAnyOrder(s2));
	}

}
