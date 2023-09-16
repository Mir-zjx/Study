package shixun7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
	Connection conn;
	Statement stmt;
	public PreparedStatement preStmt;
	
	public DBManager(String driver, String url, String user, String password) {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("数据库连接成功！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class User {
	Connection conn;
	Statement stmt;
	PreparedStatement preStmt;

	public User() {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/book_db?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "123456";

		DBManager dbm = new DBManager(driver, url, user, password);
		this.conn = dbm.conn;
		this.stmt = dbm.stmt;
		this.preStmt = dbm.preStmt;
	}
}

class UserDAO {
	Connection conn;
	Statement stmt;
	PreparedStatement preStmt;
	
	public UserDAO() {
		User user = new User();
		this.conn = user.conn;
		this.stmt = user.stmt;
		this.preStmt = user.preStmt;
	}

	public void insertBookP(String bookno, String bookname, String author) {
		try {
			String sql = "insert into bookinfo(bookno,bookname,author) values(?,?,?)";
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, bookno);
			preStmt.setString(2, bookname);
			preStmt.setString(3, author);
			preStmt.execute();
			preStmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void queryBook() {
		try {
			stmt=conn.createStatement();
			String sql="select * from bookinfo";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.print(rs.getInt("id")+"\t");
				System.out.print(rs.getString("bookno")+"\t");
				System.out.print(rs.getString("bookname")+"\t");
				System.out.print(rs.getString("author")+"\t");
				System.out.println();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void Update(String bookno, String bookname, String author) throws SQLException {
		try {
			String sql = "update bookinfo set bookname=?,author=? where bookno=?";
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, bookname);
			preStmt.setString(2, author);
			preStmt.setString(3, bookno);
			preStmt.execute();
			preStmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Delete(String bookno) throws SQLException {
		try {
			String sql = "delete from bookinfo where bookno=?";
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, bookno);
			preStmt.execute();
			preStmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


