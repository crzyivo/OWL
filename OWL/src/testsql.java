import java.sql.SQLException;

import Data.MysqlConnection;
import jdbc.JDBCTemplate;
public class testsql{
	
	public static void main(String args[]){
		try {
			JDBCTemplate mysql = MysqlConnection.getConnection();
			mysql.connect();
			System.out.println("Conectado a " + mysql);
			mysql.executeQuery("Select * from categoria");
		}
	 catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
}