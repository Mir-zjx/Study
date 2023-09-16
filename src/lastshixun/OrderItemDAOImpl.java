package lastshixun;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderItemDAOImpl implements IBaseDAO<OrderItem>{
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement preStmt;
	
	public OrderItemDAOImpl() {
		JDBCConnection as = new JDBCConnection();
		this.conn = as.conn;
		this.stmt = as.stmt;
		this.preStmt = as.preStmt;
	}

	@Override
	public void add(OrderItem t) {
		// TODO Auto-generated method stub
		try {
			String sql = "insert into orderitem(id,orderId,dishId,amount) values(?,?,?,?)";
			preStmt = conn.prepareStatement(sql);
			preStmt.setInt(1,t.getId());
			preStmt.setInt(2, t.getOrderId());
			preStmt.setInt(3, t.getDishId());
			preStmt.setDouble(4, t.getAmount());
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
			String sql = "delete from orderitem where id=?";
			preStmt = conn.prepareStatement(sql);
			preStmt.setInt(1, id);
			preStmt.execute();
			preStmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete_1(int dishId,int orderId) {
		// TODO Auto-generated method stub
		try {
			String sql = "delete from orderitem where dishId=? and orderId=?";
			preStmt = conn.prepareStatement(sql);
			preStmt.setInt(1, dishId);
			preStmt.setInt(2, orderId);
			preStmt.execute();
			preStmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(int id, OrderItem t) {
		// TODO Auto-generated method stub
		try {
			String sql = "update orderitem set orderId=?,dishId=?,amount=? where id=?";
			preStmt = conn.prepareStatement(sql);
			preStmt.setInt(1,t.getOrderId());
			preStmt.setInt(2, t.getDishId());
			preStmt.setDouble(3, t.getAmount());
			preStmt.setInt(4, id);
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
			String sql="select * from orderitem";
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
			String sql="select * from orderitem where id="+ID;
			ResultSet rs=stmt.executeQuery(sql);
			
			return rs;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet query_2(int orderId) {
		// TODO Auto-generated method stub
		int id1 = orderId;
		String ID = String.valueOf(id1);
		try {
			stmt=conn.createStatement();
			String sql="select * from dish join orderitem on dishId=dish.id where orderId="+ID;
			ResultSet rs=stmt.executeQuery(sql);
			
			return rs;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet count(int orderId) {
		// TODO Auto-generated method stub
		int id1 = orderId;
		String ID = String.valueOf(id1);
		try {
			stmt=conn.createStatement();
			String sql="SELECT SUM(orderitem.amount * dish.price) AS totalPrice\r\n" + 
					"FROM `order`\r\n" + 
					"JOIN desk ON desk.id = `order`.deskId\r\n" + 
					"JOIN orderitem ON orderitem.orderId = `order`.id\r\n" + 
					"JOIN dish ON orderitem.dishId = dish.id\r\n" + 
					"WHERE order.id ="+ID;
			ResultSet rs=stmt.executeQuery(sql);
			
			return rs;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet count(String begin,String end) {
		// TODO Auto-generated method stub
		try {
			stmt=conn.createStatement();
			String sql="select dish.name,sum(amount)as allamount,sum(amount*price)as allmoney "
					+ "from `order` join orderitem on `order`.id=orderitem.orderId "
					+ "join dish on dishId = dish.id "
					+ "where createtime between "+"'"+begin+"'"+"and "+"'"+end+"'"
					+ "group by dish.id "
					+ "order by allmoney desc";
			ResultSet rs=stmt.executeQuery(sql);
			
			return rs;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
