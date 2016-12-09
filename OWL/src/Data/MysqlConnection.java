package Data;

import java.sql.SQLException;

import jdbc.JDBCTemplate;
import jdbc.MySQLConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace(System.err);
		}
	}

	public MysqlConnection()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

	}
	/*
	 * public MysqlConnection(){ }
	 */

	public static JDBCTemplate getConnection() {
		try {
			// MysqlConnection c=new MysqlConnection();
			return new JDBCTemplate(new MySQLConfiguration("localhost", "3306", "OWL"), "data", "u7i8hh9");
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return null;
		}
	}

	/*
	 * public final static Connection getConnection() throws SQLException {
	 * return DriverManager.getConnection("jdbc:mysql://localhost/OWL", "data",
	 * "u7i8hh9"); }
	 */
}