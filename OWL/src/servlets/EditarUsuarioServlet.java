package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facades.UsuariosFacade;
import Data.OwlUserVO;

/**
 * Servlet implementation class CrearUsuarioServlet
 */
public class EditarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EditarUsuarioServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	 	
		boolean errores = true;
		String email = request.getParameter("correo");
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		int telefono = Integer.parseInt(request.getParameter("telefono"));
		int nacimiento = Integer.parseInt(request.getParameter("nacimiento"));
		String calle = request.getParameter("calle");
		String numero = request.getParameter("numero");
		String piso = request.getParameter("piso");
		String poblacion = request.getParameter("poblacion");
		String provincia = request.getParameter("provincia");
		
		
		if (email != null){
			if (!email.trim().equals(new String(""))){
				errores = false;
			}
		}
		if (!errores){
			OwlUserVO usuario = new OwlUserVO();
			try{
				UsuariosFacade fachada = new UsuariosFacade();
				fachada.modificarUsuario(usuario);
			}catch (Exception e){
				e.printStackTrace(System.err);
			}
			response.sendRedirect("exito.html");
		}else{
			response.sendRedirect("errorInterno.html");
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
