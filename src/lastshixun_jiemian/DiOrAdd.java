package lastshixun_jiemian;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import lastshixun.Desk;
import lastshixun.DeskDAOImpl;
import lastshixun.DishDAOImpl;
import lastshixun.OrderItem;
import lastshixun.OrderItemDAOImpl;

public class DiOrAdd extends JFrame{
	DiOrAdd(int OrderId) throws SQLException{
		setTitle("请从下面的表格中选择菜品添加");
		setSize(500, 500);
		setLayout(new FlowLayout());
		setLocation(700, 400);
		
		JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        JScrollPane scrollPane = new JScrollPane();
		
		JLabel lb1 = new JLabel("菜品序号:");
		add(lb1);
		JTextField tx1 = new JTextField(22);
		add(tx1);
		
		JLabel lb2 = new JLabel("菜品数量:");
		add(lb2);
		JTextField tx2 = new JTextField(22);
		add(tx2);
		
		GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);       
        panel.add(lb1, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        panel.add(lb2, constraints);
        
        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 0, 10, 10);
        panel.add(tx1, constraints);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 0, 10, 10);
        panel.add(tx2, constraints);
        
        add(panel);
        
        JButton bt1 = new JButton("添加");
		add(bt1);
		bt1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == bt1) {
					if (tx1.getText().equals("")){ 
						JOptionPane.showMessageDialog(null, "菜品序号不能为空"); }
					else {
				OrderItem orderitem = new OrderItem(OrderId,
						Integer.parseInt(tx1.getText()),Double.parseDouble(tx2.getText()));
				OrderItemDAOImpl add = new OrderItemDAOImpl();
				add.add(orderitem);
				JOptionPane.showMessageDialog(null, "点菜成功");
						}
			}
			}
        	
		});
		
		
		JButton bt2 = new JButton("取消");
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
		
		DishDAOImpl query = new DishDAOImpl();
		ResultSet rs = query.query();
		Vector<Vector<Object>> list = new Vector<Vector<Object>>();
		
		while(rs.next()) {
			Vector<Object> s=new Vector<Object>();
			s.add(rs.getInt("id"));
			s.add(rs.getString("name"));
			s.add(rs.getInt("categoryId"));
			s.add(rs.getString("code"));
			s.add(rs.getString("unit"));
			s.add(rs.getDouble("price"));
			s.add(rs.getString("status"));
			list.add(s);
		}
		Vector<Object> p = new Vector<Object>();
		p.add("序号");
		p.add("菜品名");
		p.add("类别编号");
		p.add("菜品代码");
		p.add("单位");
		p.add("价格");
		p.add("状态");
		JTable table = new JTable(list, p);
		table.getTableHeader();

		// 将表格添加到 JScrollPane
		scrollPane.setViewportView(table);
		add(scrollPane);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
