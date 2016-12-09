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
import Data.EjemplarVO;
import Data.LibroVO;
import Data.OwlUserVO;

/**
 * Servlet implementation class CrearUsuarioServlet
 */
public class MovimientosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public MovimientosServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String user = (String) request.getSession().getAttribute("user");
		List<LibroVO> librosvarios = new ArrayList();
		List<String> listasV = new ArrayList();
		List<String> listasC = new ArrayList();
		List<EjemplarVO> ventas = new ArrayList();
		List<EjemplarVO> compras = new ArrayList();
		List<List<EjemplarVO>> mov = new ArrayList();
		try {
			OWLFacade fachada = new OWLFacade();
			mov = fachada.movimientosUsuario(user);
			ventas = mov.get(0);
			compras = mov.get(1);
			if (!(ventas.isEmpty())) {
				for (EjemplarVO libro : ventas) {
					LibroVO lib = fachada.VerLibro(libro.getLibro());
					String s = libro.getfventa() + "," + libro.getId() + "-" + lib.getTitulo() + " " + lib.getAutor()
							+ "," + libro.getPrecio() + ", Puesta a la Venta";

					listasV.add(s);
				}
				request.setAttribute("ventas", listasV);
			}
			if (!(compras.isEmpty())) {
				for (EjemplarVO libro : compras) {
					LibroVO lib = fachada.VerLibro(libro.getLibro());
					String s = libro.getfcompra() + "," + libro.getId() + "-" + lib.getTitulo() + " " + lib.getAutor()
							+ "," + libro.getPrecio() + ", Compra";

					listasC.add(s);
				}
				request.setAttribute("compras", listasC);
			}
			RequestDispatcher rd = request.getRequestDispatcher("account_activity.jsp");
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
