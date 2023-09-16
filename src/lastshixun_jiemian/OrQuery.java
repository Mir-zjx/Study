package lastshixun_jiemian;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import lastshixun.DeskDAOImpl;
import lastshixun.OrderDAOImpl;

public class OrQuery extends JFrame{
	OrQuery() throws SQLException{
		setTitle("历史记录");
		setSize(1200, 600);
		setLayout(new FlowLayout());
		setLocation(700, 400);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(1200, 400));
        panel.setLayout(new GridBagLayout());
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(1150, 500));
        
        OrderDAOImpl order = new OrderDAOImpl();
		ResultSet rs = order.query();
		Vector<Vector<Object>> list = new Vector<Vector<Object>>();
		
		while(rs.next()) {
			Vector<Object> s=new Vector<Object>();
			s.add(rs.getInt("id"));
			s.add(rs.getString("OrderNo"));
			s.add(rs.getInt("deskId"));
			s.add(rs.getString("createtime"));
			s.add(rs.getDouble("money"));
			s.add(rs.getInt("customerId"));
			s.add(rs.getString("status"));
			s.add(rs.getInt("number"));
			list.add(s);
		}
		
		Vector<Object> p = new Vector<Object>();
		p.add("序号");
		p.add("订单编号");
		p.add("餐台号");
		p.add("就餐日期时间");
		p.add("金额");
		p.add("客户编号");
		p.add("状态");
		p.add("就餐人数");
		JTable table = new JTable(list, p);
		table.setPreferredSize(new Dimension(1100, 500));
		table.getTableHeader();
		
        
        scrollPane.setViewportView(table);
		add(scrollPane);
		
		JButton bt1 = new JButton("退出");
		add(bt1);
		bt1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == bt1) {
					try {
						new OrderesManagePane2();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} 
				dispose();
			}
        	
		});
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
