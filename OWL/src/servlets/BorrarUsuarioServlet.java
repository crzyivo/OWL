package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facades.OWLFacade;
import Data.OwlUserVO;

/**
 * Servlet implementation class BorrarUsuarioServlet Borrar una cuenta de
 * usuario,borrando su usuario pero no sus libros o transcacciones Como
 * alternativa se podria marcar la cuenta para mantener los datos pero
 * inutilizarla o borrar en cascada para eliminar todos los datos relacionados
 */
public class BorrarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public BorrarUsuarioServlet() {
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
		String email = (String) request.getSession().getAttribute("user");
		if (email != null) {
			if (!email.trim().equals(new String(""))) {
				errores = false;
			}
		}
		if (!errores) {
			try {
				OWLFacade fachada = new OWLFacade();
				fachada.borrarCuenta(email);
				request.getSession().removeAttribute("user");
				RequestDispatcher rd = request.getRequestDispatcher("exito_borrar.jsp");
				response.setHeader("Refresh", "3;url=Index.do");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace(System.err);
			}
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
