package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jdbc.JDBCTemplate;


public class OwlUserDAO {

	public void insertarUsuario (OwlUserVO usuario, JDBCTemplate jdbctemp){
		//No Connectuion, se trabajara con jdbtemplate
		try{
			 /* Create "preparedStatement". */
            String queryString = "INSERT INTO usuario " +
                "(email, nombre, apellidos, nacimiento, tlfn, calle, numero, piso, poblacion,"+
            		" provincia, pass) " +
            		"VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            
            
            jdbctemp.executeSentence(queryString, usuario.getEmail(),
            usuario.getNombre(),
            usuario.getApellidos(),
            usuario.getNacimiento(),
            usuario.getTlfn(),
            usuario.getCalle(),
            usuario.getNumero(),
            usuario.getPiso(),
            usuario.getPoblacion(),
            usuario.getProvincia(),
            usuario.getPassword());
           // PreparedStatement preparedStatement = jdbctemp.prepareStatement(queryString);
          //  jdbctemp.
            
            /* Fill "preparedStatement". */    
           /* preparedStatement.setString(1, usuario.getEmail());
            preparedStatement.setString(2, usuario.getNombre());
            preparedStatement.setString(3, usuario.getApellidos());
            preparedStatement.setInt(4, usuario.getNacimiento());
            preparedStatement.setInt(5, usuario.getTlfn());
            preparedStatement.setString(6, usuario.getCalle());
            preparedStatement.setString(7, usuario.getNumero());
            preparedStatement.setString(8, usuario.getPiso());
            preparedStatement.setString(9, usuario.getPoblacion());
            preparedStatement.setString(10, usuario.getProvincia());
            preparedStatement.setString(11, usuario.getPass()); */
		}catch (Exception e){
			System.out.println("DAO-Error al insertar: ");
			System.out.println("DAO-Error: " + e.getMessage());
		}
		
	}
	
	public void actualizarUsuario (OwlUserVO usuario, JDBCTemplate jdbctemp) {     
        try{
            /* Create "preparedStatement". */
        	// (email, nombre, apellidos, nacimiento, tlfn, calle, numero, piso, poblacion,"+
    		//" provincia, pass)
            String queryString = "UPDATE usuario " +
                "SET  nombre = ?, apellidos = ?, nacimiento = ?, tlfn = ?, " +
            	" numero = ?, piso = ?, provincia = ?, pass = ? WHERE  email = ?)";  
            jdbctemp.executeSentence(queryString, usuario.getNombre(),
                    usuario.getApellidos(),
                    usuario.getNacimiento(),
                    usuario.getTlfn(),
                    usuario.getCalle(),
                    usuario.getNumero(),
                    usuario.getPiso(),
                    usuario.getPoblacion(),
                    usuario.getProvincia(),
                    usuario.getPassword(),
                    usuario.getEmail());
            
            
            
            
            
            
  /*          PreparedStatement preparedStatement = 
                connection.prepareStatement(queryString);
            
            // Fill "preparedStatement".   
            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(2, usuario.getApellidos());
            Boolean esMujer = usuario.getSexo();
            String sexo = null;
            if (esMujer != null){
            	if (esMujer.booleanValue()){ 
            		sexo="M";
            	}else{
            		sexo="V";
            	}
            }
            preparedStatement.setString(3, sexo);
            preparedStatement.setString(4, usuario.getClaveEncriptada());
            preparedStatement.setString(5, usuario.getComentarios());
            preparedStatement.setString(6, usuario.getEmail());
            preparedStatement.setString(7, usuario.getLogin());*/
              
            /* Execute query. */                    
            //int insertedRows=0;
            //= preparedStatement.executeUpdate();
              
        } catch (Exception e) {
        	System.out.println("DAO-Error al actualizar: ");
           // e.printStackTrace(System.err);
        }                
    } 
            
    public OwlUserVO obtenerUsuario (String usuario, JDBCTemplate jdbctemp){     
    	OwlUserVO usuarioVO = null;
    	try{
            /* Create "preparedStatement". */
            String queryString = "SELECT  nombre, apellidos, nacimiento, tlfn, calle, numero, piso, poblacion,"+
            		" provincia, pass FROM usuario WHERE  email = ?";                    
            //PreparedStatement preparedStatement = 
                //connection.prepareStatement(queryString);
            
            /* Execute query. */   
            ResultSet resultSet=  jdbctemp.executeQueryResult(usuario);
                   
            /* Execute query. */                    
          //  ResultSet resultSet = preparedStatement.executeQuery();
               
            if (!resultSet.first()) {
                throw new SQLException( "Usuario no encontrado!!!!");
            }
            
            /* Execute query. */                    
            String nombre = resultSet.getString(1);
            String apellidos = resultSet.getString(2);
            Integer tlfn = resultSet.getInt(3);
            Integer nacimiento = resultSet.getInt(4);
            String calle = resultSet.getString(5);
            String numero = resultSet.getString(6);
            String piso_puerta = resultSet.getString(7);
            String poblacion = resultSet.getString(8);
            String provincia = resultSet.getString(9);
            String pass = resultSet.getString(10);
 
            usuarioVO = new OwlUserVO (usuario, nombre, apellidos, tlfn, nacimiento,
            							calle, numero, piso_puerta,
            							poblacion, provincia, pass);
                
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    	return usuarioVO;
    }
    
    public OwlUserVO passckeck (String usuario, JDBCTemplate jdbctemp){     
    	OwlUserVO usuarioVO = null;
    	try{
            /* Create "preparedStatement". */
            String queryString = "SELECT pass FROM usuario WHERE  email = ?";                    
            //PreparedStatement preparedStatement = 
                //connection.prepareStatement(queryString);
            
            /* Execute query. */   
            ResultSet resultSet=  jdbctemp.executeQueryResult(usuario);
                   
            /* Execute query. */                    
          //  ResultSet resultSet = preparedStatement.executeQuery();
               
            if (!resultSet.first()) {
                throw new SQLException( "Usuario no encontrado!!!!");
            }
            
            /* Execute query. */                    
            String nombre = resultSet.getString(1);
            String apellidos = resultSet.getString(2);
            Integer tlfn = resultSet.getInt(3);
            Integer nacimiento = resultSet.getInt(4);
            String calle = resultSet.getString(5);
            String numero = resultSet.getString(6);
            String piso_puerta = resultSet.getString(7);
            String poblacion = resultSet.getString(8);
            String provincia = resultSet.getString(9);
            String pass = resultSet.getString(10);
 
            usuarioVO = new OwlUserVO (usuario, nombre, apellidos, tlfn, nacimiento,
            							calle, numero, piso_puerta,
            							poblacion, provincia, pass);
                
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    	return usuarioVO;
    }

}
