package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
public class NuevoUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public NuevoUsuarioServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	 	
		boolean errores = false;
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
		String pass = request.getParameter("pass");
		//String pass = "hell";
		List<String> error_list = null;
		
	/*	if (email != null){
			if (!email.trim().equals(new String(""))){
				if(request.getSession().getAttribute("modo").equals(new String("NUEVO"))){
				errores = false;
				}
			}
		}*/
		if (!errores){
			OwlUserVO usuario = new OwlUserVO(email,nombre,apellidos,telefono,nacimiento,calle,numero,piso,poblacion,provincia,pass);
			//OwlUserVO usuario = new OwlUserVO("help@aaappaaa.com","pls","help me",688455211,1995,"Despair","89","0","Zaragoza","Zaragoza","hell");

			try{
				//Class.forName("com.mysql.jdbc.Driver");
				UsuariosFacade fachada = new UsuariosFacade();
				fachada.insertarNuevoUsuario(usuario,error_list);
			}catch (Exception e){
				e.printStackTrace(System.err);
			}
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
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
