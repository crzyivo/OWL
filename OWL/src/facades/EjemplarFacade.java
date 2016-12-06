package facades;

import Data.MysqlConnection;
import Data.EjemplarVO;
import Data.EjemplarDAO;
import java.sql.SQLException;
import jdbc.JDBCTemplate;
//import facades.PasswordAuthentication;
import java.util.List;
//import facades.ErrorsStrings;

import java.sql.Connection;

public class EjemplarFacade{
	
	public void insertarNuevoEjemplar(EjemplarVO ejemplar,List<String> errores) throws SQLException{
		JDBCTemplate mysql=null;
		EjemplarVO test = new EjemplarVO();
		try{
			mysql=MysqlConnection.getConnection();
			mysql.connect();
			EjemplarDAO OwlDAO=new EjemplarDAO();
			//ErrorsStrings.compruebaDatos(usuario,errores);
			//TODO: Control de errores mas fino si da tiempo
			verEjemplar(ejemplar.getId(),test);
			if(test.getEditorial()!=null){
				System.out.println("Repetido");
			}
			else{
			//PasswordAuthentication passauth= new PasswordAuthentication();
			//String hashpass=passauth.hash(usuario.getPassword());
			//usuario.setPassword(hashpass);
			OwlDAO.insertarEjemplar(ejemplar,mysql);
			}
			mysql.disconnect();
			
			}catch (Exception e) {
					errores.add(e.getMessage());
				       e.printStackTrace(System.err);
				       
			}finally{
				mysql.disconnect();
			}
		
	}
	
	public void modificarEjemplar(EjemplarVO ejemplar){
		JDBCTemplate mysql=MysqlConnection.getConnection();
		try{
			mysql.connect();
			EjemplarDAO OwlDAO=new EjemplarDAO();
			OwlDAO.actualizarEjemplar(ejemplar,mysql);
			mysql.disconnect();
			
			}catch (Exception e) {
				       e.printStackTrace(System.err);
			}finally{
				mysql.disconnect();
			}
		
	}
	//Obtiene datos de un ejemplar a partir de su id.
	public void verEjemplar(int id,EjemplarVO ejemplardata){
		JDBCTemplate mysql=MysqlConnection.getConnection();
		try{
			mysql.connect();
			EjemplarDAO OwlDAO=new EjemplarDAO();
			ejemplardata=OwlDAO.obtenerEjemplar(id,mysql);
			mysql.disconnect();
			
			}catch (Exception e) {
				       e.printStackTrace(System.err);
			}finally{
				mysql.disconnect();
			}
	}
	public void borrarEjemplar(int id){
		JDBCTemplate mysql=MysqlConnection.getConnection();
		try{
			mysql.connect();
			EjemplarDAO OwlDAO=new EjemplarDAO();
			OwlDAO.borrarEjemplar(id,mysql);
			mysql.disconnect();
			
			}catch (Exception e) {
				       e.printStackTrace(System.err);
			}finally{
				mysql.disconnect();
			}
		
	}
	
}
