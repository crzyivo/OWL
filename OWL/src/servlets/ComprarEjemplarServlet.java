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
 * Servlet implementation class CrearUsuarioServlet
 */
public class ComprarEjemplarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ComprarEjemplarServlet() {
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
		int libro = Integer.parseInt(request.getParameter("ejemplar"));
		EjemplarVO lib = new EjemplarVO();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date dateobj = new Date();
		try {
			OWLFacade fachada = new OWLFacade();
			lib = fachada.realizarCompra(usuario, libro, df.format(dateobj));
			RequestDispatcher rd = request.getRequestDispatcher("buy.jsp");
			response.setHeader("Refresh", "5;url=LibroEjemplar.do?id=" + lib.getLibro());
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
