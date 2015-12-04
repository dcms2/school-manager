import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	private static Statement stmt;
	
	public static Statement getInstance() throws SQLException{
		 if(stmt == null){
			 Connection connection = DriverManager.getConnection("jdbc:sqlite:db");
			 stmt = connection.createStatement();
		 }
		 return stmt;
	}
	
}
