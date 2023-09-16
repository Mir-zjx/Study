package lastshixun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class JDBCConnection {
	Connection conn;
	Statement stmt;
	public PreparedStatement preStmt;
	
	public JDBCConnection() {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/rms?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "123456";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
