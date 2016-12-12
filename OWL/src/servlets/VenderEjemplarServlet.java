package servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facades.OWLFacade;
import Data.EjemplarVO;
import Data.LibroVO;
import Data.OwlUserVO;

/**
 * Servlet implementation class VenderEjemplarServlet
 * Servlet que gestiona el registro de venta para un ejemplar de
 * un usuario logeado.
 * En caso de error en los campos, los detecta e informa de los mismos.
 */
public class VenderEjemplarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public VenderEjemplarServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usuario = (String) request.getSession().getAttribute("user");
		int libro = Integer.parseInt(request.getParameter("id"));
		String editorial = request.getParameter("neditorial");
		int año = Integer.parseInt(request.getParameter("nanyopub"));
		String estado = request.getParameter("nconservacion");
		String isbn = request.getParameter("nisbn");
		String precio = request.getParameter("nprecio");
		String cents = request.getParameter("npreciocentimos");
		String descripcion = request.getParameter("desc");
		String origen;
		Float nprecio = Float.parseFloat(precio + "." + cents);
		LibroVO lib = new LibroVO();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date dateobj = new Date();
		EjemplarVO ejemplar = new EjemplarVO(0, libro, editorial, estado, nprecio, usuario, null, isbn, año,
				df.format(dateobj), null);
		List<String> errores = new ArrayList();
		try {
			OWLFacade fachada = new OWLFacade();
			lib = fachada.VerLibro(libro);
			fachada.insertarNuevoEjemplar(ejemplar, errores);
			if (errores.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("LibroEjemplar.do?id=" + libro);
				request.setAttribute("titulo", lib.getTitulo());
				request.setAttribute("autor", lib.getAutor());
				request.setAttribute("id", libro);
				request.setAttribute("desc", lib.getDescripcion());
				rd.forward(request, response);
			} else {
				request.setAttribute("errors", errores);
				request.setAttribute("titulo", lib.getTitulo());
				request.setAttribute("autor", lib.getAutor());
				request.setAttribute("id", libro);
				request.setAttribute("editorial", editorial);
				request.setAttribute("anyo", año);
				request.setAttribute("estado", estado);
				request.setAttribute("isbn", isbn);
				request.setAttribute("precio", precio);
				request.setAttribute("cents", cents);
				RequestDispatcher rd = request.getRequestDispatcher("put_on_sale.jsp");
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
