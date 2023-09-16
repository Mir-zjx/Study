package lastshixun;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeskDAOImpl implements IBaseDAO<Desk>{
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement preStmt;
	
	public DeskDAOImpl() {
		JDBCConnection as = new JDBCConnection();
		this.conn = as.conn;
		this.stmt = as.stmt;
		this.preStmt = as.preStmt;
	}

	@Override
	public void add(Desk t) {
		// TODO Auto-generated method stub
		try {
			String sql = "insert into desk(id,no,seating,status) values(?,?,?,?)";
			preStmt = conn.prepareStatement(sql);
			preStmt.setInt(1,t.getId());
			preStmt.setString(2, t.getNo());
			preStmt.setInt(3, t.getSeating());
			preStmt.setString(4, t.getStatus());
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
			String sql = "delete from desk where id=?";
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
	public void update(int id, Desk t) {
		// TODO Auto-generated method stub
		try {
			String sql = "update desk set no=?,seating=?,status=? where id=?";
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1,t.getNo());
			preStmt.setInt(2, t.getSeating());
			preStmt.setString(3, t.getStatus());
			preStmt.setInt(4, id);
			preStmt.execute();
			preStmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update(int id, String status) {
		// TODO Auto-generated method stub
		try {
			String sql = "update desk set status=? where id=?";
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, status);
			preStmt.setInt(2, id);
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
			String sql="select * from desk";
			ResultSet rs=stmt.executeQuery(sql);
			return rs;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet query_2() {
		// TODO Auto-generated method stub
		try {
			stmt=conn.createStatement();
			String sql="SELECT desk.id, desk.status, `order`.createtime, `order`.id, dish.name, COUNT(*)\r\n" + 
					"FROM desk\r\n" + 
					"LEFT JOIN `order` ON desk.id = deskId\r\n" + 
					"LEFT JOIN orderitem ON orderId = `order`.id\r\n" + 
					"LEFT JOIN dish ON dishId = dish.id\r\n" + 
					"GROUP BY desk.id,order.id\r\n" + 
					"ORDER BY desk.id ASC";
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
			String sql="select * from desk where id="+ID;
			ResultSet rs=stmt.executeQuery(sql);
			return rs;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet query_1(String no) {
		// TODO Auto-generated method stub
		try {
			stmt=conn.createStatement();
			String sql="select * from desk where no="+no;
			ResultSet rs=stmt.executeQuery(sql);
			return rs;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet query_3(int deskId) {
		// TODO Auto-generated method stub
		int id1 = deskId;
		String ID = String.valueOf(id1);
		try {
			stmt=conn.createStatement();
			String sql="select * from desk where id="+ID;
			ResultSet rs=stmt.executeQuery(sql);
			return rs;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
