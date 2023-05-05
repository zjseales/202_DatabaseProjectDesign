package web;

import dao.StudentCollectionsDAO;
import dao.StudentDAO;
import domain.Student;
import io.jooby.Jooby;
import io.jooby.ServerOptions;
import io.jooby.StatusCode;
import io.jooby.json.GsonModule;

public class Server extends Jooby {
    
    private StudentDAO dao = new StudentCollectionsDAO();
    
    public Server(){
        setServerOptions(new ServerOptions().setPort(8085));
        
        install(new GsonModule());
        mount(new StudentModule(dao));
		  
        mount(new StaticAssetModule());
        
    }

	public static void main(String[] args) {
		// some dummy data for testing with
		StudentDAO dao = new StudentCollectionsDAO();
		dao.save(new Student(1111, "Boris", "123 Some Street", "555 1234", "INFO"));
		dao.save(new Student(2222, "Doris", "23 Fake Street", "555 234", "INFO"));
		dao.save(new Student(3333, "Morris", "634 Another Street", "555 6545", "COSC"));
		dao.save(new Student(4444, "Delores", "3 Random Road", "555 2345", "SENG"));

		System.out.println("\nStarting Server.");
                new Server().start();
	}

}
