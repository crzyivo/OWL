package jdbc;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.es.SpanishAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.document.IntField;
import org.apache.lucene.document.StringField;

/**
 * Clase para acceder a una BD Oracle
 */
public class JDBCTemplate {

	/**
	 * CaDena de caracteres con el nombre de usuario, o login, a emplear para
	 * conectarse a la BD
	 */
	String user = "";
	/**
	 * Cadena de caracteres con el password, o contrase??a, a emplear para
	 * conectarse a la BD
	 */
	String password = "";
	/**
	 * Conexion con la BD
	 */
	Connection connection = null;

	Configuration config = null;

	/**
	 * Metodo constructor. Asigna los valores de usuario, password, host, puerto
	 * y nombre de la bd, para que posteriormente pueda hacerse la conexion
	 * 
	 */
	public JDBCTemplate(Configuration config, String user, String password)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		this.config = config;
		this.user = user;
		this.password = password;

		Class.forName(config.getDriver()).newInstance();
	}

	/**
	 * Metodo para establecer la conexion JDBC con la BD
	 * <p>
	 * 
	 * @throws SQLException
	 * 
	 * @exception Lanza
	 *                una excepcion en caso de que se produzca algun error
	 */
	public void connect() throws SQLException {
		// Estableciendo la conexion con la BD
		connection = DriverManager.getConnection(config.getURL(), user, password);
	}

	@Override
	public String toString() {
		return config.getURL();
	}

	/**
	 * Metodo para cerrar la conexion JDBC con la BD
	 */
	public void disconnect() {
		try {
			if (connection != null) {
				connection.close();
			}
			connection = null;
		} catch (SQLException sqlE) {
			connection = null;
		}
	}

	/**
	 * Metodo para realizar una pregunta SQL a la BD (una sentencia SELECT)
	 * 
	 * @param sql
	 *            sentencia SQL
	 */
	public void executeQuery(String sql) {

		// Creamos una sentencia para poder usarla con la conexion que
		// tenemos abierta
		Statement stmt = null;
		try {
			System.out
					.println("---------------------------------------------------------------------------------------");
			stmt = connection.createStatement();
			// Formulamos la pregunta y obtenemos el resultado
			ResultSet rs = stmt.executeQuery(sql);

			// Convertiremos el resutlado obtenido (tabla), en una cadena de
			// caracteres
			// que en pantalla tenga aspecto de tabla...

			// Creamos la cabecera de la tabla...
			ResultSetMetaData rsmd = rs.getMetaData();
			int numberOfColumns = rsmd.getColumnCount();

			for (int i = 1; i <= numberOfColumns; i++) {
				System.out.print(" " + rsmd.getColumnLabel(i) + "\t | ");
			}
			System.out.println();
			System.out
					.println("---------------------------------------------------------------------------------------");

			// Creamos las filas de la tabla con la informacion de la tuplas
			// obtenidas
			while (rs.next()) {// Por cada tupla
				// creamos una linea con la informacion:
				for (int j = 1; j <= numberOfColumns; j++) {
					System.out.print(" " + rs.getString(j) + "\t | ");
				}
				System.out.println();
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			System.out
					.println("---------------------------------------------------------------------------------------");
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	public ResultSet executeQueryResult(String sqlorig, String email) {

		// Creamos una sentencia para poder usarla con la conexion que
		// tenemos abierta
		Statement stmt = null;
		ResultSet rs;
		String sql = sqlorig.substring(0, sqlorig.length() - 1);
		sql += email;
		try {
			System.out
					.println("---------------------------------------------------------------------------------------");
			stmt = connection.createStatement();
			// Formulamos la pregunta y obtenemos el resultado
			rs = stmt.executeQuery(sql);

			// Convertiremos el resutlado obtenido (tabla), en una cadena de
			// caracteres
			// que en pantalla tenga aspecto de tabla...

			// Creamos la cabecera de la tabla...
			ResultSetMetaData rsmd = rs.getMetaData();
			int numberOfColumns = rsmd.getColumnCount();

			for (int i = 1; i <= numberOfColumns; i++) {
				System.out.print(" " + rsmd.getColumnLabel(i) + "\t | ");
			}
			System.out.println();
			System.out
					.println("---------------------------------------------------------------------------------------");

			// Creamos las filas de la tabla con la informacion de la tuplas
			// obtenidas
			while (rs.next()) {// Por cada tupla
				// creamos una linea con la informacion:
				for (int j = 1; j <= numberOfColumns; j++) {
					System.out.print(" " + rs.getString(j) + "\t | ");
				}
				System.out.println();
			}
			return rs;
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
			rs = null;
		} finally {
			System.out
					.println("---------------------------------------------------------------------------------------");
			if (stmt != null) {
				try {
					stmt.close();

				} catch (SQLException e) {
				}
			}
		}
		return rs;

	}

	/**
	 * Metodo para ejecutar una sentencia SQL que no sea una pregunta, es decir,
	 * que no devuelva una tabla como resultado.
	 * 
	 * @param sql
	 *            sentencia SQL
	 */
	public void executeSentence(String sql) {
		Statement stmt = null;
		try {
			System.out
					.println("---------------------------------------------------------------------------------------");
			stmt = connection.createStatement();
			int resultado = stmt.executeUpdate(sql);
			System.out.println(resultado);
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			System.out
					.println("---------------------------------------------------------------------------------------");
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	public void executeSentence(String sql, Object... params) {
		PreparedStatement stmt = null;
		try {
			System.out
					.println("---------------------------------------------------------------------------------------");
			stmt = connection.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				stmt.setObject(i + 1, params[i]);
			}
			int resultado = stmt.executeUpdate();
			System.out.println(resultado);
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			System.out
					.println("---------------------------------------------------------------------------------------");
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	public ArrayList<Object> executeSentenceResult(String sql, Object... params) {
		PreparedStatement stmt = null;
		ArrayList<Object> list = new ArrayList<Object>();
		ResultSet rs;
		try {
			System.out
					.println("---------------------------------------------------------------------------------------");
			stmt = connection.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				stmt.setObject(i + 1, params[i]);
			}
			// int resultado = stmt.executeUpdate();
			// rs=stmt.executeUpdate();
			rs = stmt.executeQuery();
			// System.out.println(resultado);
			ResultSetMetaData rsmd = rs.getMetaData();
			int numberOfColumns = rsmd.getColumnCount();

			for (int i = 1; i <= numberOfColumns; i++) {
				System.out.print(" " + rsmd.getColumnLabel(i) + "\t | ");
			}
			System.out.println();
			System.out
					.println("---------------------------------------------------------------------------------------");

			// Creamos las filas de la tabla con la informacion de la tuplas
			// obtenidas
			while (rs.next()) {// Por cada tupla
				// creamos una linea con la informacion:
				for (int j = 1; j <= numberOfColumns; j++) {
					System.out.print(" " + rs.getString(j) + "\t | ");
					list.add(rs.getString(j));
				}
				System.out.println();
			}
			// return rs;
			return list;

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
			rs = null;
		} finally {
			System.out
					.println("---------------------------------------------------------------------------------------");
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			}
		}
		// return rs;
		return list;
	}

	public Cursor executeQueryAndGetCursor(String sql) {
		Statement stmt = null;
		try {
			stmt = connection.createStatement();
			return new Cursor(stmt.executeQuery(sql));
		} catch (SQLException e1) {
			System.out.println("Error: " + e1.getMessage());
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e2) {
				}
			}
		}
		return null;
	}

	public Directory indexaLibroSQL() throws IOException {
		File INDEX_DIRECTORY = new File("../Database/Index");
		PreparedStatement stmt = null;
		IndexWriter indice = null;
		ResultSet rs;
		Analyzer analizador = new SpanishAnalyzer(Version.LUCENE_40);
		String mysql ="select * from libro";
		try {
			System.out
					.println("---------------------------------------------------------------------------------------");
			stmt = connection.prepareStatement(mysql);
			rs=stmt.executeQuery(mysql); 
			Directory directorioAlmacenarIndice = FSDirectory.open(INDEX_DIRECTORY);

			IndexWriterConfig configuracionIndice = new IndexWriterConfig(Version.LUCENE_40, analizador);

			indice = new IndexWriter(directorioAlmacenarIndice, configuracionIndice);
			int count = 0;
			while (rs.next()) {
			    Document doc = new Document();
			    doc.add(new Field("id", rs.getString("id"), Field.Store.YES, Field.Index.NOT_ANALYZED));
			    doc.add(new Field("titulo", rs.getString("titulo"), Field.Store.YES, Field.Index.ANALYZED)); 
			    doc.add(new Field("autor", rs.getString("autor"), Field.Store.YES, Field.Index.ANALYZED));
			    doc.add(new Field("descripcion", rs.getString("descripcion"), Field.Store.YES, Field.Index.NOT_ANALYZED));
			    doc.add(new Field("ventas", rs.getString("ventas"), Field.Store.YES,Field.Index.NOT_ANALYZED ));
			    indice.addDocument(doc);
			    count++;
			    System.out.println(doc.get("titulo"));
			}
			System.out.println(count+" añadido");
			indice.close();
			return directorioAlmacenarIndice;
			
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
			return null;
		} finally {
			System.out
					.println("---------------------------------------------------------------------------------------");
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			}
		}
	}
}