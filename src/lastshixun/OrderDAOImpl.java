package lastshixun;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Random;

public class OrderDAOImpl implements IBaseDAO<Order>{

	private Connection conn;
	private Statement stmt;
	private PreparedStatement preStmt;
	
	public OrderDAOImpl() {
		JDBCConnection as = new JDBCConnection();
		this.conn = as.conn;
		this.stmt = as.stmt;
		this.preStmt = as.preStmt;
	}

	@Override
	public void add(Order t) {
		// TODO Auto-generated method stub
		try {
			Date date = new Date();
		    Random random = new Random();
		    int number = random.nextInt(9000) + 1000; // 生成四位随机数
		    String result = String.format("%tF-%tT-%04d", date, date, number); //拼接当前时间和随机数
			String sql = "insert into `order`(id,orderNo,deskId,createtime,customerId,number) values(?,?,?,DATE_FORMAT(CURRENT_TIMESTAMP(), '%Y-%m-%d %H:%i'),?,?)";
			preStmt = conn.prepareStatement(sql);
			preStmt.setInt(1,t.getId());
			preStmt.setString(2, result);
			preStmt.setInt(3, t.getDeskId());
			preStmt.setInt(4, t.getCustomerId());
			preStmt.setInt(5, t.getNumber());
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
			String sql = "delete from `order` where id=?";
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
	public void update(int id, Order t) {
		// TODO Auto-generated method stub
		try {
			String sql = "update `order` set deskId=?,createtime=?,money=?,customerId=?,status=?,number=? where id=?";
			preStmt = conn.prepareStatement(sql);
			preStmt.setInt(1, t.getDeskId());
			preStmt.setString(2,t.getCreatetime());
			preStmt.setDouble(3,t.getMoney());
			preStmt.setInt(4,t.getCustomerId());
			preStmt.setString(5,t.getStatus());
			preStmt.setInt(6,t.getNumber());
			preStmt.setInt(7, id);
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
			String sql = "update `order` set status=? where id=?";
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
	
	public void update_desk(int id, String status) {
		// TODO Auto-generated method stub
		try {
			String sql = "update `order` set status=? where id=?";
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
	
	public void update_money(int id, Double money) {
		// TODO Auto-generated method stub
		try {
			String sql = "update `order` set money=? where id=?";
			preStmt = conn.prepareStatement(sql);
			preStmt.setDouble(1, money);
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
			String sql="select * from `order`";
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
			String sql="select * from `order` where id="+ID;
			ResultSet rs=stmt.executeQuery(sql);
			return rs;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public int query_desk(int id) {
		// TODO Auto-generated method stub
		int id1 = id;
		String ID = String.valueOf(id1);
		try {
			stmt=conn.createStatement();
			String sql="select deskId from `order` where id="+ID;
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
			return rs.getInt("deskId");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

}
