package facades;

import Data.MysqlConnection;
import Data.OwlUserVO;
import Data.OwlUserDAO;
import java.sql.SQLException;
import jdbc.JDBCTemplate;
import facades.PasswordAuthentication;
import java.util.List;
import facades.ErrorsStrings;

import java.sql.Connection;

public class UsuariosFacade {

	public void insertarNuevoUsuario(OwlUserVO usuario, List<String> errores) throws SQLException {
		JDBCTemplate mysql = null;
		OwlUserVO test = new OwlUserVO();
		try {
			mysql = MysqlConnection.getConnection();
			mysql.connect();
			OwlUserDAO OwlDAO = new OwlUserDAO();
			ErrorsStrings.compruebaDatos(usuario, errores);
			if (errores.isEmpty()) {
				test = verUsuario(usuario.getEmail());
				if (test.getEmail() != null) {
					errores.add("Este correo ya esta en uso");
				} else {
					PasswordAuthentication passauth = new PasswordAuthentication();
					String hashpass = passauth.hash(usuario.getPassword());
					usuario.setPassword(hashpass);
					OwlDAO.insertarUsuario(usuario, mysql);
				}
			}
			mysql.disconnect();

		} catch (Exception e) {
			errores.add(e.getMessage());
			e.printStackTrace(System.err);

		} finally {
			mysql.disconnect();
		}

	}

	public void modificarUsuario(OwlUserVO usuario, boolean pass, List<String> errores) {
		JDBCTemplate mysql = MysqlConnection.getConnection();
		try {
			mysql.connect();
			OwlUserDAO OwlDAO = new OwlUserDAO();
			if (pass) {
				ErrorsStrings.compruebaDatos(usuario, errores);
				if (errores.isEmpty()) {
					PasswordAuthentication passauth = new PasswordAuthentication();
					String hashpass = passauth.hash(usuario.getPassword());
					usuario.setPassword(hashpass);
					OwlDAO.actualizarUsuario(usuario, mysql);
				}
			} else {
				ErrorsStrings.compruebaDatos(usuario, errores);
				if (errores.isEmpty()) {
					OwlDAO.actualizarUsuario(usuario, mysql);
				}
			}
			mysql.disconnect();

		} catch (Exception e) {
			e.printStackTrace(System.err);
		} finally {
			mysql.disconnect();
		}

	}

	// Obtiene datos de un usuario a partir de su mail.
	public OwlUserVO verUsuario(String email) {
		JDBCTemplate mysql = MysqlConnection.getConnection();
		try {
			mysql.connect();
			OwlUserDAO OwlDAO = new OwlUserDAO();
			OwlUserVO userdata = OwlDAO.obtenerUsuario(email, mysql);
			mysql.disconnect();
			return userdata;

		} catch (Exception e) {
			e.printStackTrace(System.err);
			return null;
		} finally {
			mysql.disconnect();
		}
	}

	public void borrarCuenta(String email) {
		JDBCTemplate mysql = MysqlConnection.getConnection();
		try {
			mysql.connect();
			OwlUserDAO OwlDAO = new OwlUserDAO();
			OwlDAO.borrarUsuario(email, mysql);
			mysql.disconnect();

		} catch (Exception e) {
			e.printStackTrace(System.err);
		} finally {
			mysql.disconnect();
		}

	}

	public boolean comprobarLogin(String usuario, String pass) {
		JDBCTemplate mysql = MysqlConnection.getConnection();
		try {
			mysql.connect();
			OwlUserDAO OwlDAO = new OwlUserDAO();
			String current = OwlDAO.obtenerUsuario(usuario, mysql).getPassword();
			mysql.disconnect();
			PasswordAuthentication passauth = new PasswordAuthentication();
			return passauth.authenticate(pass, current);

		} catch (Exception e) {
			e.printStackTrace(System.err);
			return false;
		} finally {
			mysql.disconnect();
		}
	}

}