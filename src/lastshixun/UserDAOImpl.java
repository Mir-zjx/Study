package lastshixun;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAOImpl implements IBaseDAO<User>{
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement preStmt;
	
	public UserDAOImpl() {
		JDBCConnection as = new JDBCConnection();
		this.conn = as.conn;
		this.stmt = as.stmt;
		this.preStmt = as.preStmt;
	}

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		try {
			String sql = "insert into user(username,password) values(?,?)";
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, user.getUsername());
			preStmt.setString(2, user.getPassword());
			preStmt.execute();
			preStmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		try {
			String sql = "delete from user where id=?";
			preStmt = conn.prepareStatement(sql);
			preStmt.setInt(1, id);
			preStmt.execute();
			preStmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(int id,User user) {
		// TODO Auto-generated method stub
		try {
			String sql = "update user set username=?,password=? where id=?";
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, user.getUsername());
			preStmt.setString(2, user.getPassword());
			preStmt.setInt(3, id);
			preStmt.execute();
			preStmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ResultSet query() {
		// TODO Auto-generated method stub
		try {
			stmt=conn.createStatement();
			String sql="select * from user";
			ResultSet rs=stmt.executeQuery(sql);
			return rs;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultSet query_1(int id) {
		// TODO Auto-generated method stub
		int id1 = id;
		String ID = String.valueOf(id1);
		try {
			stmt=conn.createStatement();
			String sql="select * from user where id="+ID;
			ResultSet rs=stmt.executeQuery(sql);
			return rs;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public User query_1(String username) {
		// TODO Auto-generated method stub
		try {
			stmt=conn.createStatement();
			String sql="select * from user where username="+"'"+username+"'";
			ResultSet rs=stmt.executeQuery(sql);
			while (rs.next()) {
	            User user = new User(rs.getString("username"), rs.getString("password"));
	            user.setId(rs.getInt("id"));
	            
	            return user;
	        }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
		
	}

}
