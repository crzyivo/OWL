package servlets;

import facades.OWLFacade;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class IndexarLibrosListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent event) {
    	try {
    		
			OWLFacade fachada = new OWLFacade();
			fachada.indexInicial();

		} catch (Exception e) {
			e.printStackTrace(System.err);

		}
    }
    public void contextDestroyed(ServletContextEvent event) {
        // Do your thing during webapp's shutdown.
    }
}
