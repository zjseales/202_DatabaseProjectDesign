
import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.plus.webapp.EnvConfiguration;
import org.eclipse.jetty.plus.webapp.PlusConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.FragmentConfiguration;
import org.eclipse.jetty.webapp.MetaInfConfiguration;
import org.eclipse.jetty.webapp.WebAppConfiguration;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.webapp.WebInfConfiguration;
import org.eclipse.jetty.webapp.WebXmlConfiguration;

public class JettyServer {

	public static void main(String[] args) throws Exception {

		Server server = new Server(8080);

		WebAppContext context = new WebAppContext();

		context.setParentLoaderPriority(true);
		server.setHandler(context);

		context.setConfigurations(
			new Configuration[]{
				new AnnotationConfiguration(),
				new WebAppConfiguration(),
				new WebXmlConfiguration(),
				new WebInfConfiguration(),
				new PlusConfiguration(),
				new MetaInfConfiguration(),
				new FragmentConfiguration(),
				new EnvConfiguration()
			}
		);

		context.setResourceBase("deploy");
		context.setContextPath("/lab05");

		server.start();

		System.out.println("\nServer ready on:\n" +  server.getURI());

		server.join();
	}

}
