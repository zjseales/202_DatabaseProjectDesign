
import dao.StudentCollectionsDAO;
import dao.StudentDAO;
import gui.MainMenu;
import java.awt.EventQueue;

public class App {

    public static void main(String[] args) {

            StudentDAO dao = new StudentCollectionsDAO();
            EventQueue.invokeLater(() -> {
		new MainMenu(dao).setVisible(true);
            });

    }
}
