
package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
	private final String jdbcURL = "jdbc:mysql://localhost:3306/moylishmotors";
	private final String jdbcUsername = "root";
	private final String jdbcPassword = "";
	
	public Connection getConnection() {
		Connection connection = null;
		try {   
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
                        return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
                        System.out.println("SQL Expcetion in Connection: "+e);
                        return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
                        System.out.println("SQL Expcetion in Connection: "+e);
                        return null;
		}
	}

}
