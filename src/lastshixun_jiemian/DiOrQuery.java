package lastshixun_jiemian;

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

import lastshixun.DishDAOImpl;
import lastshixun.OrderItemDAOImpl;

public class DiOrQuery extends JFrame{
	DiOrQuery(int OrderId) throws SQLException{
		setTitle("购物车");
		setSize(500, 550);
		setLayout(new FlowLayout());
		setLocation(700, 400);
		
		JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        JScrollPane scrollPane = new JScrollPane();
        
        OrderItemDAOImpl query = new OrderItemDAOImpl();
		ResultSet rs = query.query_2(OrderId);
		Vector<Vector<Object>> list = new Vector<Vector<Object>>();
		
		while(rs.next()) {
			Vector<Object> s=new Vector<Object>();
			s.add(rs.getInt("dishId"));
			s.add(rs.getString("name"));
			s.add(rs.getDouble("amount"));
			s.add(rs.getDouble("price"));
			list.add(s);
		}
		
		Vector<Object> p = new Vector<Object>();
		p.add("菜品序号");
		p.add("菜品名");
		p.add("数量");
		p.add("单价");
		JTable table = new JTable(list, p);
		table.getTableHeader();

		// 将表格添加到 JScrollPane
		scrollPane.setViewportView(table);
		add(scrollPane);
		
		JButton bt2 = new JButton("退出");
		add(bt2);
		bt2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == bt2) {
					new DishesOrderesManagePane2(OrderId);
				} 
				dispose();
			}
        	
		});
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
