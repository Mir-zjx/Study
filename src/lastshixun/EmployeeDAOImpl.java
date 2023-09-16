package lastshixun;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDAOImpl implements IBaseDAO<Employee>{
	private Connection conn;
	private Statement stmt;
	private PreparedStatement preStmt;
	
	public EmployeeDAOImpl() {
		JDBCConnection as = new JDBCConnection();
		this.conn = as.conn;
		this.stmt = as.stmt;
		this.preStmt = as.preStmt;
	}

	@Override
	public void add(Employee t) {
		// TODO Auto-generated method stub
		try {
			String sql = "insert into employee(id,name,sex,birthday,identityID,address,tel,position,freeze) values(?,?,?,?,?,?,?,?,?)";
			preStmt = conn.prepareStatement(sql);
			preStmt.setInt(1,t.getId());
			preStmt.setString(2, t.getName());
			preStmt.setString(3, t.getSex());
			preStmt.setString(4, t.getBirthday());
			preStmt.setString(5, t.getIdentityID());
			preStmt.setString(6, t.getAddress());
			preStmt.setString(7, t.getTel());
			preStmt.setString(8, t.getPosition());
			preStmt.setString(9, t.getFreeze());
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
			String sql = "delete from employee where id=?";
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
	public void update(int id, Employee t) {
		// TODO Auto-generated method stub
		try {
			String sql = "update employee set name=?,sex=?,birthday=?,identityID=?,address=?,tel=?,position=?,freeze=? where id=?";
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1,t.getName());
			preStmt.setString(2, t.getSex());
			preStmt.setString(3, t.getBirthday());
			preStmt.setString(4, t.getIdentityID());
			preStmt.setString(5, t.getAddress());
			preStmt.setString(6, t.getTel());
			preStmt.setString(7, t.getPosition());
			preStmt.setString(8, t.getFreeze());
			preStmt.setInt(9, id);
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
			String sql="select * from employee";
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
			String sql="select * from employee where id="+ID;
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
			String sql="select * from employee where name="+"'"+name+"'";
			ResultSet rs=stmt.executeQuery(sql);
			return rs;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
