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

import lastshixun.DeskDAOImpl;
import lastshixun.Employee;
import lastshixun.EmployeeDAOImpl;
import lastshixun.Order;
import lastshixun.OrderDAOImpl;

public class OrderesManagePane2 extends JFrame{
	OrderesManagePane2() throws SQLException{
		setTitle("开台界面");
		setSize(500, 800);
		setLayout(new FlowLayout());
		setLocation(700, 400);
		
		JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        JScrollPane scrollPane = new JScrollPane();
		
		JLabel lb1 = new JLabel("id:");
		add(lb1);
		JTextField tx1 = new JTextField(40);
		add(tx1);
		
		JLabel lb3 = new JLabel("餐台号:");
		add(lb3);
		JTextField tx3 = new JTextField(40);
		add(tx3);
		
		JLabel lb6 = new JLabel("客户编号:");
		add(lb6);
		JTextField tx6 = new JTextField(40);
		add(tx6);
		
		JLabel lb8 = new JLabel("就餐人数:");
		add(lb8);
		JTextField tx8 = new JTextField(40);
		add(tx8);
		
		GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);       
        panel.add(lb1, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        panel.add(lb3, constraints);
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        panel.add(lb6, constraints);
        constraints.gridx = 0;
        constraints.gridy = 7;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        panel.add(lb8, constraints);
        
        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 0, 10, 10);
        panel.add(tx1, constraints);
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 0, 10, 10);
        panel.add(tx3, constraints);
        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 0, 10, 10);
        panel.add(tx6, constraints);
        constraints.gridx = 1;
        constraints.gridy = 7;
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 0, 10, 10);
        panel.add(tx8, constraints);
        
        add(panel);
        
        JButton bt1 = new JButton("开台");
		add(bt1);
		bt1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == bt1) {
					if (tx1.getText().equals("")){ 
						JOptionPane.showMessageDialog(null, "id不能为空"); }
					else if (tx3.getText().equals("")){ 
						JOptionPane.showMessageDialog(null, "餐台号不能为空"); }
					else if (tx6.getText().equals("")){ 
						JOptionPane.showMessageDialog(null, "客户编号不能为空"); }
					else if (tx8.getText().equals("")){ 
						JOptionPane.showMessageDialog(null, "就餐人数不能为空"); }
					else {
				int id = Integer.parseInt(tx1.getText());
				Order order = new Order(id,
						Integer.parseInt(tx3.getText()),
						Integer.parseInt(tx6.getText()),Integer.parseInt(tx8.getText()));
				OrderDAOImpl add = new OrderDAOImpl();
				add.add(order);
				DeskDAOImpl update = new DeskDAOImpl();
				update.update(Integer.parseInt(tx3.getText()), "已预定");
				JOptionPane.showMessageDialog(null, "开台成功");
				dispose();
				new DishesOrderesManagePane2(id);
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
					new MainFrame();
				} 
				dispose();
			}
        	
		});
		
		JButton bt3 = new JButton("刷新");
		add(bt3);
		bt3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == bt3) {
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
		
		JButton bt4 = new JButton("历史");
		add(bt4);
		bt4.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == bt4) {
					try {
						new OrQuery();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				} 
				dispose();
			}
        	
		});
		
		JButton bt5 = new JButton("修改订单");
		add(bt5);
		bt5.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == bt5) {
					if (tx1.getText().equals("")){ 
						JOptionPane.showMessageDialog(null, "id不能为空"); }
					else {
				int id = Integer.parseInt(tx1.getText());
				dispose();
				new DishesOrderesManagePane2(id);
						}
			}
			}
        	
		});
		
		
		DeskDAOImpl desk = new DeskDAOImpl();
		ResultSet rs = desk.query();
		Vector<Vector<Object>> list = new Vector<Vector<Object>>();
		
		while(rs.next()) {
			Vector<Object> s=new Vector<Object>();
			s.add(rs.getInt("id"));
			s.add(rs.getString("no"));
			s.add(rs.getString("seating"));
			s.add(rs.getString("status"));
			list.add(s);
		}
		
		Vector<Object> p = new Vector<Object>();
		p.add("餐台序号");
		p.add("餐台编号");
		p.add("座位数");
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
