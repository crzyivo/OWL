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
 * Servlet implementation class LoginServlet 
 * Gestiona los login de los usuarios
 */
public class LoginServlet extends HttpServlet {

	/**
	 * Default constructor.
	 */
	public LoginServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		boolean errores = true;

		// Pametros de login introucidos por el usuario
		String email = request.getParameter("owlbooks-correo");
		String pass = request.getParameter("owlbooks-clave");
		boolean goodLogin;

		if (email != null) {
			if (!email.trim().equals(new String(""))) {
				errores = false;
			}
		}
		if (!errores) {
			try {

				OWLFacade fachada = new OWLFacade();
				/* Se comprueba el login */
				goodLogin = fachada.comprobarLogin(email, pass);
				/* Se obtienen los datos del usuario para pasarlos */
				OwlUserVO user = fachada.verUsuario(email);
				if (goodLogin) {
					/* Exito en el login */
					request.getSession().setAttribute("user", email);
					request.getSession().setAttribute("username", user.getNombre());
					RequestDispatcher rd = request.getRequestDispatcher("Index.do");
					rd.forward(request, response);
				} else {
					/* Fallo en el login */
					request.getSession().setAttribute("errorMessage", "Email o contraseña erroneos");
					RequestDispatcher rd = request.getRequestDispatcher("Index.do");
					rd.forward(request, response);
				}

			} catch (Exception e) {
				e.printStackTrace(System.err);
			}

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
