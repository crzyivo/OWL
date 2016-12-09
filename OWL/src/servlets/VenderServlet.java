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
import Data.LibroVO;
import Data.OwlUserVO;

/**
 * Servlet implementation class CrearUsuarioServlet
 */
public class VenderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public VenderServlet() {
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
		LibroVO lib = new LibroVO();
		int libro = Integer.parseInt(request.getParameter("id"));

		if (request.getSession().getAttribute("user") != null) {
			if (!request.getSession().getAttribute("user").equals(new String(""))) {

				errores = false;
			}
		}
		if (!errores) {

			try {
				OWLFacade fachada = new OWLFacade();
				lib = fachada.VerLibro(libro);
				request.setAttribute("titulo", lib.getTitulo());
				request.setAttribute("id", libro);
				request.setAttribute("autor", lib.getAutor());
			} catch (Exception e) {
				e.printStackTrace(System.err);
			}
			RequestDispatcher rd = request.getRequestDispatcher("put_on_sale.jsp");
			rd.forward(request, response);

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("LibroEjemplar.do?id=" + libro);
			request.setAttribute("errorlogin", "1");
			rd.forward(request, response);
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
