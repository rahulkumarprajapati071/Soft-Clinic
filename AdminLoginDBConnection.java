package softclinic;

import java.sql.Connection;
import java.sql.DriverManager;
public class AdminLoginDBConnection {
	
	static Connection connection;
	public static Connection connectAdminLoginDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String DB_URL = "jdbc:mysql://localhost:3306/admindatabases";
			String USER = "root";
			String PASS = "9786";
			//register jdbc drivr, not required for newer version of jdk
			//open a connection
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			return connection;
			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}
