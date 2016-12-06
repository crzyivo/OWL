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
		String email = (String) request.getSession().getAttribute("user");
		String nombre = request.getParameter("nnombre");
		String apellidos = request.getParameter("napellidos");
		int telefono = Integer.parseInt(request.getParameter("ntelefono"));
		int nacimiento = Integer.parseInt(request.getParameter("nnacimiento"));
		String calle = request.getParameter("ncalle");
		String numero = request.getParameter("nnumero");
		String piso = request.getParameter("npiso");
		String poblacion = request.getParameter("npoblacion");
		String provincia = request.getParameter("nprovincia");
		String pass = (String) request.getSession().getAttribute("password");
		
		
		if (request.getSession().getAttribute("user") != null){
			if (!request.getSession().getAttribute("user").equals(new String(""))){
				errores = false;
			}
		}
		if (!errores){
			OwlUserVO usuario = new OwlUserVO (email, nombre, apellidos, telefono, nacimiento,calle, numero, piso,poblacion, provincia, pass);
			try{
				UsuariosFacade fachada = new UsuariosFacade();
				fachada.modificarUsuario(usuario,false);
			}catch (Exception e){
				e.printStackTrace(System.err);
			}
			if(usuario.getPassword()==null){
				response.getWriter().append("no pass");
			}
			else if(usuario.getNumero()==null){
				response.getWriter().append("no numero");
			}
			else if(usuario.getPiso()==null){
				response.getWriter().append("no piso");
			}
			else if(usuario.getProvincia()==null){
				response.getWriter().append("no provincia");
			}
			else if(usuario.getPoblacion()==null){
				response.getWriter().append("no poblacion");
			}
			else{
			response.sendRedirect("account.jsp");
			}
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
