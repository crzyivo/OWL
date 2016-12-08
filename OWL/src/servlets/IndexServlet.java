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


/**
 * Servlet implementation class CrearUsuarioServlet
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public IndexServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	 	
		String category = request.getParameter("categoria");

		List<CategoriaVO> categorias = new ArrayList();
		List<String> listas = new ArrayList();
		try {
			OWLFacade fachada = new OWLFacade(); 
			categorias=fachada.mostrarCategorias();
			categorias=categorias.subList(0, 15);
			if((categorias!=null)){
				for(CategoriaVO cat:categorias){
					String s = cat.getNombre()+","+cat.getNLibros();
					
					listas.add(s);
				}
				request.setAttribute("categorias",listas);
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
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
