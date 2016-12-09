package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facades.OWLFacade;
import Data.OwlUserVO;

/**
 * Servlet implementation class CrearUsuarioServlet
 */
public class NuevoUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public NuevoUsuarioServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String email = request.getParameter("correo");
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		int telefono = Integer.parseInt(request.getParameter("telefono"));
		int nacimiento = Integer.parseInt(request.getParameter("nacimiento"));
		String calle = request.getParameter("calle");
		String numero = request.getParameter("numero");
		String piso = request.getParameter("piso");
		String poblacion = request.getParameter("poblacion");
		String provincia = request.getParameter("provincia");
		String pass = request.getParameter("clave");
		String cpass = request.getParameter("confirmarclave");
		List<String> errorList = new ArrayList();
		if (!(pass.equals(cpass))) {
			errorList.add("Las contraseñas no coinciden");
			pass = "";
		}

		OwlUserVO usuario = new OwlUserVO(email, nombre, apellidos, telefono, nacimiento, calle, numero, piso,
				poblacion, provincia, pass);
		try {
			OWLFacade fachada = new OWLFacade();
			fachada.insertarNuevoUsuario(usuario, errorList);
			if (errorList.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("Index.do");
				request.getSession().setAttribute("user", email);
				request.getSession().setAttribute("username", nombre);
				rd.forward(request, response);
			} else {
				request.setAttribute("errors", errorList);
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
				RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
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
