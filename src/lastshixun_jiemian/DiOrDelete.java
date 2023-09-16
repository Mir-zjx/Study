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

import lastshixun.DishDAOImpl;
import lastshixun.OrderItem;
import lastshixun.OrderItemDAOImpl;

public class DiOrDelete extends JFrame{
	DiOrDelete(int OrderId) throws SQLException{
		setTitle("请从下面你的购物车中选择菜品删除");
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
		
		GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);       
        panel.add(lb1, constraints);
        
        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 0, 10, 10);
        panel.add(tx1, constraints);
        
        add(panel);
        
        JButton bt1 = new JButton("删除");
		add(bt1);
		bt1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == bt1) {
					if (tx1.getText().equals("")){ 
						JOptionPane.showMessageDialog(null, "菜品序号不能为空"); }
					else {
				OrderItemDAOImpl delete = new OrderItemDAOImpl();
				delete.delete_1(Integer.parseInt(tx1.getText()),OrderId);
				JOptionPane.showMessageDialog(null, "删除成功");
				dispose();
				try {
					new DiOrDelete(OrderId);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
						}
			}
			}
        	
		});
		
		
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
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
	}
}
