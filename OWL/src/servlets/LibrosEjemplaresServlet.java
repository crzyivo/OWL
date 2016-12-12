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
import Data.CategoriaVO;
import Data.EjemplarVO;
import Data.LibroVO;
import Data.OwlUserVO;

/**
 * Servlet implementation class LibrosEjemplarServlet
 * Servlet que obtiene los ejemplares de un libro dado y que estan disponibles 
 * para su venta, es decir, que no han sido comprados ya.
 */
public class LibrosEjemplaresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public LibrosEjemplaresServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		int id = Integer.parseInt(request.getParameter("id"));
		String origen;

		List<EjemplarVO> ejemplaresvarios = new ArrayList();
		List<String> listas = new ArrayList();
		LibroVO l = new LibroVO();
		List<CategoriaVO> categorias = new ArrayList();
		List<String> listasCategoria = new ArrayList();
		List<String> listasLibrosLeidos = new ArrayList();
		List<LibroVO> masLeidos = new ArrayList();
		try {
			OWLFacade fachada = new OWLFacade();
			l = fachada.VerLibro(id);
			RequestDispatcher rd = request.getRequestDispatcher("book.jsp");
			if (l != null) {
				ejemplaresvarios = fachada.EjemplaresLibro(id);
				categorias = fachada.mostrarCategorias();
				categorias = categorias.subList(0, 15);
				masLeidos = fachada.librosMasLeidos();
				if ((categorias != null)) {
					for (CategoriaVO cat : categorias) {
						String s = cat.getNombre() + "," + cat.getNLibros();

						listasCategoria.add(s);
					}
					if ((masLeidos != null)) {
						for (LibroVO lib : masLeidos) {
							String s = lib.getTitulo() + "," + lib.getAutor() + "," + lib.getDescripcion() + ","
									+ lib.getId();

							listasLibrosLeidos.add(s);
						}
					}
				}

				if ((!ejemplaresvarios.isEmpty())) {
					for (EjemplarVO libro : ejemplaresvarios) {
						if (libro.getComprador() == null) {
							origen = fachada.verUsuario(libro.getVendedor()).getProvincia();
							String s = libro.getEditorial() + "," + libro.getAnno() + "," + libro.getPrecio() + ","
									+ libro.getISBN() + "," + libro.getVendedor() + "," + origen + ","
									+ libro.getEstado() + "," + libro.getId();
							listas.add(s);
						}
					}

					request.setAttribute("libros", listas);
					request.setAttribute("titulo", l.getTitulo());
					request.setAttribute("autor", l.getAutor());
					request.setAttribute("descripcion", l.getDescripcion());
					request.setAttribute("id", id);
				} else {

					request.setAttribute("noLibros", "1");
					request.setAttribute("libros", listas);
					request.setAttribute("titulo", l.getTitulo());
					request.setAttribute("autor", l.getAutor());
					request.setAttribute("descripcion", l.getDescripcion());
					request.setAttribute("id", id);
				}
			}
			request.setAttribute("categorias", listasCategoria);
			request.setAttribute("masLeidos", listasLibrosLeidos);
			rd.forward(request, response);

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
