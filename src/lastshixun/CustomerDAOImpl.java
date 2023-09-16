package lastshixun;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerDAOImpl implements IBaseDAO<Customer>{
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement preStmt;
	
	public CustomerDAOImpl() {
		JDBCConnection as = new JDBCConnection();
		this.conn = as.conn;
		this.stmt = as.stmt;
		this.preStmt = as.preStmt;
	}

	@Override
	public void add(Customer t) {
		// TODO Auto-generated method stub
		try {
			String sql = "insert into customer(id,name,sex,company,tel,cardID) values(?,?,?,?,?,?)";
			preStmt = conn.prepareStatement(sql);
			preStmt.setInt(1,t.getId());
			preStmt.setString(2, t.getName());
			preStmt.setString(3, t.getSex());
			preStmt.setString(4, t.getCompany());
			preStmt.setString(5, t.getTel());
			preStmt.setString(6, t.getCardID());
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
			String sql = "delete from customer where id=?";
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
	public void update(int id, Customer t) {
		// TODO Auto-generated method stub
		try {
			String sql = "update customer set name=?,sex=?,company=?,tel=?,cardID=? where id=?";
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1,t.getName());
			preStmt.setString(2, t.getSex());
			preStmt.setString(3, t.getCompany());
			preStmt.setString(4, t.getTel());
			preStmt.setString(5, t.getCardID());
			preStmt.setInt(6, id);
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
			String sql="select * from customer";
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
			String sql="select * from customer where id="+ID;
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
		String sql="select * from customer where name="+"'"+name+"'";
		ResultSet rs=stmt.executeQuery(sql);
		return rs;
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return null;
}

}
