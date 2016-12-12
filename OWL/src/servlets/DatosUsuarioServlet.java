package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facades.OWLFacade;
import Data.OwlUserVO;

/**
 * Servlet implementation class DatosUsuarioServlet Servlet que obtiene los
 * datos de un usuario dado su email, para poder mostrarlos mediante atributos
 */
public class DatosUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public DatosUsuarioServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		boolean errores = true;

		if (request.getSession().getAttribute("user") != null) {
			if (!request.getSession().getAttribute("user").equals(new String(""))) {

				errores = false;
			}
		}
		if (!errores) {
			OwlUserVO usuario = new OwlUserVO();
			try {

				OWLFacade fachada = new OWLFacade();
				String usuario_sesion = (String) request.getSession().getAttribute("user");
				usuario = fachada.verUsuario(usuario_sesion);
				String email = usuario.getEmail();
				String nombre = usuario.getNombre();
				String apellidos = usuario.getApellidos();
				int telefono = usuario.getTlfn();
				int nacimiento = usuario.getNacimiento();
				String calle = usuario.getCalle();
				String numero = usuario.getNumero();
				String piso = usuario.getPiso();
				String poblacion = usuario.getPoblacion();
				String provincia = usuario.getProvincia();
				String pass = usuario.getPassword();
				request.setAttribute("correo", email);
				request.setAttribute("nombre", nombre);
				request.setAttribute("apellidos", apellidos);
				request.setAttribute("telefono", telefono);
				request.setAttribute("nacimiento", nacimiento);
				request.setAttribute("calle", calle);
				request.setAttribute("numero", numero);
				request.setAttribute("piso", piso);
				request.setAttribute("poblacion", poblacion);
				request.setAttribute("provincia", provincia);
				request.getSession().setAttribute("password", pass);
			} catch (Exception e) {
				e.printStackTrace(System.err);
			}
			RequestDispatcher rd = request.getRequestDispatcher("account_personal.jsp");
			rd.forward(request, response);

		} else {
			response.sendRedirect("errorInterno.html");
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
