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
import Data.LibroVO;
import Data.OwlUserVO;

/**
 * Servlet implementation class CrearUsuarioServlet
 */
public class LibrosCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LibrosCategoriaServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	 	
		String category = request.getParameter("categoria");

		List<LibroVO> librosvarios = new ArrayList();
		List<String> listas = new ArrayList();
		try {
			OWLFacade fachada = new OWLFacade(); 
			librosvarios=fachada.librosPorCategoria(category);
			librosvarios=librosvarios.subList(0, 45);
			if((librosvarios!=null)){
				for(LibroVO libro:librosvarios){
					String s = libro.getTitulo()+","+libro.getAutor()+","+libro.getVentas()+","+libro.getId();
					
					listas.add(s);
				}
				request.setAttribute("libros",listas);
				request.setAttribute("categoria", category);
				RequestDispatcher rd = request.getRequestDispatcher("category.jsp");
	            rd.forward(request, response);
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	            rd.forward(request, response);
			}
			
		}catch (Exception e){
				e.printStackTrace(System.err);
			}
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
