package facades;

import Data.CategoriaDAO;
import Data.CategoriaVO;
import Data.EjemplarDAO;
import Data.EjemplarVO;
import Data.LibroDAO;
import Data.LibroVO;
import Data.MysqlConnection;
import Data.OwlUserVO;
import Data.OwlUserDAO;
import java.sql.SQLException;
import jdbc.JDBCTemplate;
import facades.PasswordAuthentication;

import java.util.ArrayList;
import java.util.List;
import facades.ErrorsStrings;

import java.sql.Connection;

public class OWLFacade {

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

	public List<LibroVO> librosPorCategoria(String cat) {
		JDBCTemplate mysql = MysqlConnection.getConnection();
		try {
			mysql.connect();
			CategoriaDAO OwlDAO = new CategoriaDAO();
			List<LibroVO> resultado = new ArrayList();
			resultado = OwlDAO.obtenerLibrosInCategoria(cat, mysql, "lecturas");
			if (resultado.isEmpty()) {
				mysql.disconnect();
				return null;

			} else {
				mysql.disconnect();
				return resultado;
			}

		} catch (Exception e) {
			e.printStackTrace(System.err);
			return null;
		} finally {
			mysql.disconnect();
		}
	}

	public LibroVO VerLibro(int id) {
		JDBCTemplate mysql = MysqlConnection.getConnection();
		try {
			mysql.connect();
			LibroDAO OwlDAO = new LibroDAO();
			LibroVO resultado = new LibroVO();
			resultado = OwlDAO.obtenerlibro(id, mysql);
			if (resultado.getId() == -1) {
				mysql.disconnect();
				return null;

			} else {
				mysql.disconnect();
				return resultado;
			}

		} catch (Exception e) {
			e.printStackTrace(System.err);
			return null;
		} finally {
			mysql.disconnect();
		}
	}

	public void librosPorCategorian() {
		JDBCTemplate mysql = MysqlConnection.getConnection();
		try {
			mysql.connect();
			CategoriaDAO OwlDAO = new CategoriaDAO();
			List<LibroVO> resultado = new ArrayList();
			OwlDAO.actualizarCategorian(mysql);

		} catch (Exception e) {
			e.printStackTrace(System.err);

		} finally {
			mysql.disconnect();
		}
	}

	public List<CategoriaVO> mostrarCategorias() {
		JDBCTemplate mysql = MysqlConnection.getConnection();
		try {
			mysql.connect();
			CategoriaDAO OwlDAO = new CategoriaDAO();
			List<CategoriaVO> resultado = new ArrayList();
			resultado = OwlDAO.obtenerCategorias(mysql);
			return resultado;

		} catch (Exception e) {
			e.printStackTrace(System.err);
			return null;

		} finally {
			mysql.disconnect();
		}
	}

	public List<LibroVO> librosMasLeidos() {
		JDBCTemplate mysql = MysqlConnection.getConnection();
		try {
			mysql.connect();
			LibroDAO OwlDAO = new LibroDAO();
			List<LibroVO> resultado = new ArrayList();
			resultado = OwlDAO.obtenerLibrosByVenta(mysql);
			if (resultado.isEmpty()) {
				mysql.disconnect();
				return null;

			} else {
				mysql.disconnect();
				return resultado;
			}

		} catch (Exception e) {
			e.printStackTrace(System.err);
			return null;
		} finally {
			mysql.disconnect();
		}
	}

	public List<EjemplarVO> EjemplaresLibro(int id) {
		JDBCTemplate mysql = MysqlConnection.getConnection();
		try {
			mysql.connect();
			EjemplarDAO OwlDAO = new EjemplarDAO();
			List<EjemplarVO> resultado = new ArrayList();
			resultado = OwlDAO.obtenerEjemplaresBy("libro", "", id, mysql);
			if (resultado.isEmpty()) {
				mysql.disconnect();
				return new ArrayList();

			} else {
				mysql.disconnect();
				return resultado;
			}

		} catch (Exception e) {
			e.printStackTrace(System.err);
			return null;
		} finally {
			mysql.disconnect();
		}
	}

	public void insertarNuevoEjemplar(EjemplarVO ejemplar, List<String> errores) throws SQLException {
		JDBCTemplate mysql = null;
		try {
			mysql = MysqlConnection.getConnection();
			mysql.connect();
			EjemplarDAO OwlDAO = new EjemplarDAO();
			ErrorsStringsEjemplares.compruebaDatos(ejemplar, errores);
			if (errores.isEmpty()) {
				OwlDAO.insertarEjemplar(ejemplar, mysql);

			}
			mysql.disconnect();

		} catch (Exception e) {
			errores.add(e.getMessage());
			e.printStackTrace(System.err);

		} finally {
			mysql.disconnect();
		}

	}

	public List<List<EjemplarVO>> movimientosUsuario(String user) {
		JDBCTemplate mysql = MysqlConnection.getConnection();
		try {
			mysql.connect();
			EjemplarDAO OwlDAO = new EjemplarDAO();
			List<EjemplarVO> ventas = OwlDAO.obtenerEjemplaresBy("vendedor", user, 0, mysql);
			List<EjemplarVO> compras = OwlDAO.obtenerEjemplaresBy("comprador", user, 0, mysql);
			List<List<EjemplarVO>> resultado = new ArrayList();
			resultado.add(ventas);
			resultado.add(compras);
			return resultado;

		} catch (Exception e) {
			e.printStackTrace(System.err);
			return null;

		} finally {
			mysql.disconnect();
		}
	}

	public EjemplarVO realizarCompra(String user, int id, String fcompra) {
		JDBCTemplate mysql = MysqlConnection.getConnection();
		try {
			mysql.connect();
			EjemplarDAO OwlDAO = new EjemplarDAO();
			EjemplarVO ejemplar = OwlDAO.obtenerEjemplar(id, mysql);
			ejemplar.setComprador(user);
			ejemplar.setfcompra(fcompra);
			OwlDAO.actualizarEjemplar(ejemplar, mysql);
			return ejemplar;

		} catch (Exception e) {
			e.printStackTrace(System.err);
			return null;

		} finally {
			mysql.disconnect();
		}
	}

}