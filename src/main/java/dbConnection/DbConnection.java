package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con= DriverManager.getConnection( "jdbc:mysql://localhost:4928/test","ecwDbUser","Pwd4db@114");
		return con;
	}

}
