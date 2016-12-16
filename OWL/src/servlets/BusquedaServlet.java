package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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
 * Servlet implementation class LibrosCategoriaServlet Gestiona la obtencion de
 * los libros en una categoria
 */
public class BusquedaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public BusquedaServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String busqueda = request.getParameter("owlbooks-search");
		// final Pattern PATTERN_CATEGORIA = Pattern.compile("*;*");

		List<LibroVO> librosvarios = new ArrayList();
		List<String> listas = new ArrayList();
		boolean error = false;

			try {
				OWLFacade fachada = new OWLFacade();

				librosvarios = fachada.busquedaEnLibros(busqueda);

				if ((librosvarios != null)) {
					for (LibroVO libro : librosvarios) {
						String s = libro.getTitulo() + "," + libro.getAutor() + "," + libro.getVentas() + ","
								+ libro.getId();

						listas.add(s);
					}
					request.setAttribute("termino", busqueda);
					request.setAttribute("libros", listas);
					RequestDispatcher rd = request.getRequestDispatcher("searchRes.jsp");
					rd.forward(request, response);
				} else {
					request.setAttribute("termino", busqueda);
					RequestDispatcher rd = request.getRequestDispatcher("searchRes.jsp");
					rd.forward(request, response);
				}

			} catch (Exception e) {
				
				e.printStackTrace(response.getWriter());
				//response.getWriter().append(e.getStackTrace().toString());
				
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
