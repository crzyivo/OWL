

import java.sql.ResultSet;
import java.sql.SQLException;



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

		}catch (Exception e){
			System.out.println("DAO-Error al insertar: ");
			System.out.println("DAO-Error: " + e.getMessage());
		}
		
	}
	
	public void actualizarUsuario (OwlUserVO usuario, JDBCTemplate jdbctemp) {     
        try{
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
           
              
        } catch (Exception e) {
        	System.out.println("DAO-Error al actualizar: ");
           // e.printStackTrace(System.err);
        }                
    } 
            
    public OwlUserVO encontrarDatosUsuario (OwlUserVO usuario, JDBCTemplate jdbctemp){     
    	OwlUserVO usuarioVO = null;
    	try{
            /* Create "preparedStatement". */                   
            
            /* Execute query. */   
            ResultSet resultSet=  jdbctemp.executeQueryResult(usuario.getEmail());
                   
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
 
            usuarioVO = new OwlUserVO (usuario.getEmail(), nombre, apellidos, tlfn, nacimiento,
            							calle, numero, piso_puerta,
            							poblacion, provincia, pass);
                
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    	return usuarioVO;
    }  
    
    public void borrarUsuario (String usuario, JDBCTemplate jdbctemp){
		//No Connection, se trabajara con jdbtemplate
		try{
			 /* Create "preparedStatement". */
            String queryString = "DELETE FROM ejemplar " +
                    "WHERE vendedor = '"+usuario+"'"+" and comprador is NULL";
                  jdbctemp.executeSentence(queryString);
			
             queryString = "UPDATE ejemplar "
             		+ "Set ejemplar.vendedor = 'usuario@borrado' " +
                "WHERE vendedor = '"+usuario+"'";
             jdbctemp.executeSentence(queryString);
             
             queryString = "DELETE FROM usuario " +
                     "WHERE email = '"+usuario+"'";
            
            
            jdbctemp.executeSentence(queryString);

		}catch (Exception e){
			System.out.println("DAO-Error al borrar: ");
			System.out.println("DAO-Error: " + e.getMessage());
		}
		
	}
}
