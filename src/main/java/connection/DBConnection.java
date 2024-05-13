package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	//parameters
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/alkem5";
	private static final String USER = "root";
	//remember to change the password to yours
	private static final String PASSWORD = "Brisa_2003";
	//declare connection
	private static Connection con = null;
	
	public static Connection getConnection() {
		
		try {
			//register driver
			Class.forName(DRIVER);
			//establish connection with the database
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}
