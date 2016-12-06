package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;

import facades.UsuariosFacade;
import Data.OwlUserVO;

/**
 * Servlet implementation class CrearUsuarioServlet
 */
public class LoginServlet extends HttpServlet {

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 	
		boolean errores = false;
		String email = request.getParameter("owlbooks-correo");
		String pass = request.getParameter("owlbooks-clave");
		boolean goodLogin;
		
		
		if (email != null){
			if (!email.trim().equals(new String(""))){
				errores = false;
			}
		}
		if (!errores){
			try{

				UsuariosFacade fachada = new UsuariosFacade();
				goodLogin=fachada.comprobarLogin(email,pass);
				if(goodLogin){
					request.getSession().setAttribute("user", email);
					RequestDispatcher rd = request.getRequestDispatcher((String) request.getSession().getAttribute("current"));
	                rd.forward(request, response);
				}
				else{
					request.getSession().setAttribute("errorMessage", "Email o contraseña erroneos");
					RequestDispatcher rd = request.getRequestDispatcher((String) request.getSession().getAttribute("current"));
                    rd.forward(request, response);
				}
				
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
