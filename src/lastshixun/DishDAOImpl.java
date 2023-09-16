package lastshixun;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DishDAOImpl implements IBaseDAO<Dish>{
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement preStmt;
	
	public DishDAOImpl() {
		JDBCConnection as = new JDBCConnection();
		this.conn = as.conn;
		this.stmt = as.stmt;
		this.preStmt = as.preStmt;
	}

	@Override
	public void add(Dish t) {
		// TODO Auto-generated method stub
		try {
			String sql = "insert into dish(id,name,categoryId,code,unit,price,status) values(?,?,?,?,?,?,?)";
			preStmt = conn.prepareStatement(sql);
			preStmt.setInt(1,t.getId());
			preStmt.setString(2, t.getName());
			preStmt.setInt(3, t.getCategoryId());
			preStmt.setString(4, t.getCode());
			preStmt.setString(5, t.getUnit());
			preStmt.setDouble(6, t.getPrice());
			preStmt.setString(7, t.getStatus());
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
			String sql = "delete from dish where id=?";
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
	public void update(int id, Dish t) {
		// TODO Auto-generated method stub
		try {
			String sql = "update dish set name=?,categoryId=?,code=?,unit=?,price=?,status=? where id=?";
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1,t.getName());
			preStmt.setInt(2, t.getCategoryId());
			preStmt.setString(3,t.getCode());
			preStmt.setString(4,t.getUnit());
			preStmt.setDouble(5,t.getPrice());
			preStmt.setString(6,t.getStatus());
			preStmt.setInt(7, id);
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
			String sql="select * from dish";
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
			String sql="select * from dish where id="+ID;
			ResultSet rs=stmt.executeQuery(sql);
			
			return rs;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet query_1(String name) {
		// TODO Auto-generated method stub
		try {
			stmt=conn.createStatement();
			String sql="select * from dish where name="+"'"+name+"'";
			ResultSet rs=stmt.executeQuery(sql);
			
			return rs;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
