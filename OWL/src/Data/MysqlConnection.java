package Data;

import java.sql.SQLException;

import jdbc.JDBCTemplate;
import jdbc.MySQLConfiguration;


public class MysqlConnection{
    JDBCTemplate db;
    public MysqlConnection()throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException{
		db = new JDBCTemplate(new MySQLConfiguration("localhost","3306","OWL"),"data","u7i8hh9");
		
        
    }
    
    public static JDBCTemplate getConnection(){
    	try{
        MysqlConnection c=new MysqlConnection();
        return c.db;
    	}	catch (Exception e) {
    			System.out.println("Error: " + e.getMessage());
    			return null;
    	}
    }
}