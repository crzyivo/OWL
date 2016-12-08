package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;

import facades.OWLFacade;
import Data.OwlUserVO;

/**
 * Servlet implementation class CrearUsuarioServlet
 */
public class LogoutServlet extends HttpServlet {

    /**
     * Default constructor. 
     */
    public LogoutServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 	
		boolean errores = true;
		
		
		if (request.getSession().getAttribute("user") != null){
			if (!request.getSession().getAttribute("user").equals(new String(""))){
				errores = false;
			}
		}
		if (!errores){
			try{

					request.getSession().invalidate();
					RequestDispatcher rd = request.getRequestDispatcher("Index.do");
	                rd.forward(request, response);


	
				
			}catch (Exception e){
				e.printStackTrace(System.err);
			}

		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
