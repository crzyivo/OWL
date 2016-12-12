package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jdbc.JDBCTemplate;

public class OwlUserDAO {

	public void insertarUsuario(OwlUserVO usuario, JDBCTemplate jdbctemp) {
		// No Connectuion, se trabajara con jdbtemplate
		try {
			/* Create "preparedStatement". */
			String queryString = "INSERT INTO usuario "
					+ "(email, nombre, apellidos, nacimiento, tlfn, calle, numero, piso, poblacion,"
					+ " provincia, pass) " + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";

			jdbctemp.executeSentence(queryString, usuario.getEmail(), usuario.getNombre(), usuario.getApellidos(),
					usuario.getNacimiento(), usuario.getTlfn(), usuario.getCalle(), usuario.getNumero(),
					usuario.getPiso(), usuario.getPoblacion(), usuario.getProvincia(), usuario.getPassword());

		} catch (Exception e) {
			System.out.println("Usuario ya existente. ");
		}

	}

	public void actualizarUsuario(OwlUserVO usuario, JDBCTemplate jdbctemp) {
		try {
			/* Create "preparedStatement". */
			// (email, nombre, apellidos, nacimiento, tlfn, calle, numero, piso,
			// poblacion,"+
			// " provincia, pass)
			String queryString = "UPDATE usuario "
					+ "SET  nombre = ?, apellidos = ?, nacimiento = ?, tlfn = ?, calle = ?"
					+ ",numero = ?, piso = ?, poblacion = ?, provincia = ?, pass = ? WHERE  email = '"
					+ usuario.getEmail() + "'";
			jdbctemp.executeSentence(queryString, usuario.getNombre(), usuario.getApellidos(), usuario.getNacimiento(),
					usuario.getTlfn(), usuario.getCalle(), usuario.getNumero(), usuario.getPiso(),
					usuario.getPoblacion(), usuario.getProvincia(), usuario.getPassword());

			

		} catch (Exception e) {
			System.out.println("DAO-Error al actualizar: ");
			// e.printStackTrace(System.err);
		}
	}

	public OwlUserVO obtenerUsuario(String usuario, JDBCTemplate jdbctemp) {
		OwlUserVO usuarioVO = new OwlUserVO();
		try {
			/* Create "preparedStatement". */
			String sql = "SELECT  nombre, apellidos, nacimiento, tlfn, calle, numero, piso, poblacion,"
					+ " provincia, pass,email FROM usuario WHERE  email = '" + usuario + "'";
			// PreparedStatement preparedStatement =
			// connection.prepareStatement(queryString);

			/* Execute query. */
			ArrayList<Object> resultSet = jdbctemp.executeSentenceResult(sql);

		

			/* Execute query. */
			if (!resultSet.isEmpty()) {
				String nombre = (String) resultSet.get(0);
				String apellidos = (String) resultSet.get(1);
				Integer tlfn = Integer.parseInt((String) resultSet.get(3));
				Integer nacimiento = Integer.parseInt((String) resultSet.get(2));
				String calle = (String) resultSet.get(4);
				String numero = (String) resultSet.get(5);
				String piso_puerta = (String) resultSet.get(6);
				String poblacion = (String) resultSet.get(7);
				String provincia = (String) resultSet.get(8);
				String pass = (String) resultSet.get(9);
				String email = (String) resultSet.get(10);

				usuarioVO = new OwlUserVO(usuario, nombre, apellidos, tlfn, nacimiento, calle, numero, piso_puerta,
						poblacion, provincia, pass);
				return usuarioVO;
			}

		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return usuarioVO;
	}

	public void borrarUsuario(String usuario, JDBCTemplate jdbctemp) {
		// No Connection, se trabajara con jdbtemplate
		try {
			/* Create "preparedStatement". */
			String queryString = "DELETE FROM ejemplar " + "WHERE vendedor = '" + usuario + "'"
					+ " and comprador is NULL";
			jdbctemp.executeSentence(queryString);

			queryString = "UPDATE ejemplar " + "Set ejemplar.vendedor = NULL " + "WHERE vendedor = '" + usuario + "'";
			jdbctemp.executeSentence(queryString);

			queryString = "DELETE FROM usuario " + "WHERE email = '" + usuario + "'";

			jdbctemp.executeSentence(queryString);

		} catch (Exception e) {
			System.out.println("DAO-Error al borrar: ");
			System.out.println("DAO-Error: " + e.getMessage());
		}

	}

}
