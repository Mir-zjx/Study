package lastshixun_jiemian;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import lastshixun.CustomerDAOImpl;
import lastshixun.DishDAOImpl;

public class DiQuery extends JFrame{
	DiQuery(){
		setTitle("搜索菜品");
		setSize(500, 500);
		setLayout(new FlowLayout());
		setLocation(700, 400);
		
		JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        JScrollPane scrollPane = new JScrollPane();
		
		JLabel lb1 = new JLabel("id:");
		add(lb1);
		JTextField tx1 = new JTextField(22);
		add(tx1);
		
		JLabel lb2 = new JLabel("菜品名:");
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
		
        JButton bt1 = new JButton("搜索");
        add(bt1);
		bt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == bt1) {
					if (tx1.getText().equals("") && tx2.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "id和菜品名不能同时为空");
					} else if (tx2.getText().equals("")) {
						int id = Integer.parseInt(tx1.getText());
						DishDAOImpl query = new DishDAOImpl();
						ResultSet rs = query.query_1(id);
						String[] p = { "id", "菜品名", "类别编号", "菜品代码", "单位", "价格","单位"};
						String[][] QResult = new String[1][7];
						String id1 = null;
						try {
							while (rs.next()) {
								id1 = String.valueOf(rs.getInt("id"));
								QResult[0][0] = id1;
								QResult[0][1] = rs.getString("name");
								QResult[0][2] = String.valueOf(rs.getInt("categoryId"));
								QResult[0][3] = rs.getString("code");
								QResult[0][4] = rs.getString("unit");
								QResult[0][5] = String.valueOf(rs.getDouble("price"));
								QResult[0][6] = rs.getString("status");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						try {
							rs.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						JTable table = new JTable(QResult, p);
						table.getTableHeader();

						// 将表格添加到 JScrollPane
						scrollPane.setViewportView(table);
						add(scrollPane);
					    setVisible(true);
					}else if (tx1.getText().equals("")) {
						DishDAOImpl query = new DishDAOImpl();
						ResultSet rs = query.query_1(tx2.getText());
						String[] p = { "id", "菜品名", "类别编号", "菜品代码", "单位", "价格","单位"};
						String[][] QResult = new String[1][7];
						String id1 = null;
						try {
							while (rs.next()) {
								id1 = String.valueOf(rs.getInt("id"));
								QResult[0][0] = id1;
								QResult[0][1] = rs.getString("name");
								QResult[0][2] = String.valueOf(rs.getInt("categoryId"));
								QResult[0][3] = rs.getString("code");
								QResult[0][4] = rs.getString("unit");
								QResult[0][5] = String.valueOf(rs.getDouble("price"));
								QResult[0][6] = rs.getString("status");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						try {
							rs.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						JTable table = new JTable(QResult, p);
						table.getTableHeader();

						// 将表格添加到 JScrollPane
						scrollPane.setViewportView(table);
						add(scrollPane);
					    setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "只能选择一个输入");
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
				try {
					new	DishManagePane2();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				}
			}
        	
		});
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
