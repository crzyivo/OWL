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
public class LibrosEjemplaresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LibrosEjemplaresServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	 	String titulo = request.getParameter("titulo");
	 	String autor = request.getParameter("autor");
	 	String descripcion = request.getParameter("desc");
	 	int id = Integer.parseInt(request.getParameter("id"));
		String origen;

		List<EjemplarVO> ejemplaresvarios = new ArrayList();
		List<String> listas = new ArrayList();
		try {
			OWLFacade fachada = new OWLFacade(); 
			ejemplaresvarios=fachada.EjemplaresLibro(id);
			RequestDispatcher rd = request.getRequestDispatcher("book.jsp");
			if((!ejemplaresvarios.isEmpty())){
				for(EjemplarVO libro:ejemplaresvarios){
					origen = fachada.verUsuario(libro.getVendedor()).getProvincia();
					String s = libro.getEditorial()+","+libro.getAnno()+","+libro.getPrecio()+","+libro.getISBN()+","+libro.getVendedor()+","+origen+","+libro.getEstado();
					listas.add(s);
				}
				
				request.setAttribute("libros",listas);
				request.setAttribute("titulo", titulo);
				request.setAttribute("autor",autor);
				request.setAttribute("descripcion",descripcion);
				request.setAttribute("id", id);
			}else{
				
				request.setAttribute("noLibros", "1");
				request.setAttribute("libros",listas);
				request.setAttribute("titulo", titulo);
				request.setAttribute("autor",autor);
				request.setAttribute("descripcion",descripcion);
				request.setAttribute("id", id);
			}
			rd.forward(request, response);
			
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
