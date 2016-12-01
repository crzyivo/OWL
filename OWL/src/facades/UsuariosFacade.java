package facades;

import Data.MysqlConnection;
import Data.OwlUserVO;
import Data.OwlUserDAO;
import java.sql.SQLException;
import jdbc.JDBCTemplate;
import facades.PasswordAuthentication;
import java.util.List;

public class UsuariosFacade{
	
	public void insertarNuevoUsuario(OwlUserVO usuario,List<String> errores){
		JDBCTemplate mysql=MysqlConnection.getConnection();
		try{
			mysql.connect();
			OwlUserDAO OwlDAO=new OwlUserDAO();
			
			PasswordAuthentication passauth= new PasswordAuthentication();
			String hashpass=passauth.hash(usuario.getPassword());
			usuario.setPassword(hashpass);
			OwlDAO.insertarUsuario(usuario,mysql);
			mysql.disconnect();
			
			}catch (Exception e) {
				       e.printStackTrace(System.err);
			}finally{
				mysql.disconnect();
			}
		
	}
	
	public void modificarUsuario(OwlUserVO usuario){
		JDBCTemplate mysql=MysqlConnection.getConnection();
		try{
			mysql.connect();
			OwlUserDAO OwlDAO=new OwlUserDAO();
			OwlDAO.actualizarUsuario(usuario,mysql);
			mysql.disconnect();
			
			}catch (Exception e) {
				       e.printStackTrace(System.err);
			}finally{
				mysql.disconnect();
			}
		
	}
	//Obtiene datos de un usuario a partir de su mail.
	public void verUsuario(String email,OwlUserVO userdata){
		JDBCTemplate mysql=MysqlConnection.getConnection();
		try{
			mysql.connect();
			OwlUserDAO OwlDAO=new OwlUserDAO();
			userdata=OwlDAO.obtenerUsuario(email,mysql);
			mysql.disconnect();
			
			}catch (Exception e) {
				       e.printStackTrace(System.err);
			}finally{
				mysql.disconnect();
			}
	}
	public void borrarCuenta(String email){
		JDBCTemplate mysql=MysqlConnection.getConnection();
		try{
			mysql.connect();
			OwlUserDAO OwlDAO=new OwlUserDAO();
			OwlDAO.borrarUsuario(email,mysql);
			mysql.disconnect();
			
			}catch (Exception e) {
				       e.printStackTrace(System.err);
			}finally{
				mysql.disconnect();
			}
		
	}
	
	public boolean comprobarLogin(String usuario,String pass){
		JDBCTemplate mysql=MysqlConnection.getConnection();
		try{
			mysql.connect();
			OwlUserDAO OwlDAO=new OwlUserDAO();
			String current=OwlDAO.passcheck(usuario,mysql);
			mysql.disconnect();
			PasswordAuthentication passauth= new PasswordAuthentication();
			return passauth.authenticate(pass,current);
			
			
			}catch (Exception e) {
				       e.printStackTrace(System.err);
				       return false;
			}finally{
				mysql.disconnect();
			}
	}
	
}