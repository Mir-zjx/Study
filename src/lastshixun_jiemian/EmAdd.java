package lastshixun_jiemian;

import java.awt.Dimension;
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

import lastshixun.Employee;
import lastshixun.EmployeeDAOImpl;

public class EmAdd extends JFrame{
	EmAdd() throws SQLException{
		setSize(1200, 800);
		setLayout(new FlowLayout());
		setLocation(700, 400);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(1200, 400));
        panel.setLayout(new GridBagLayout());
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(1150, 500));
		
		JLabel lb1 = new JLabel("id:");
		add(lb1);
		JTextField tx1 = new JTextField(22);
		add(tx1);
		
		JLabel lb2 = new JLabel("用户名:");
		add(lb2);
		JTextField tx2 = new JTextField(22);
		add(tx2);
		
		JLabel lb3 = new JLabel("性别:");
		add(lb3);
		JTextField tx3 = new JTextField(22);
		add(tx3);
		
		JLabel lb4 = new JLabel("出生日期:");
		add(lb4);
		JTextField tx4 = new JTextField(22);
		add(tx4);
		
		JLabel lb5 = new JLabel("身份证号:");
		add(lb5);
		JTextField tx5 = new JTextField(22);
		add(tx5);
		
		JLabel lb6 = new JLabel("家庭住址:");
		add(lb6);
		JTextField tx6 = new JTextField(22);
		add(tx6);
		
		JLabel lb7 = new JLabel("电话:");
		add(lb7);
		JTextField tx7 = new JTextField(22);
		add(tx7);
		
		JLabel lb8 = new JLabel("职位:");
		add(lb8);
		JTextField tx8 = new JTextField(22);
		add(tx8);
		
		JLabel lb9 = new JLabel("是否在职:");
		add(lb9);
		JTextField tx9 = new JTextField(22);
		add(tx9);
		
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
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        panel.add(lb3, constraints);
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        panel.add(lb4, constraints);
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        panel.add(lb5, constraints);
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        panel.add(lb6, constraints);
        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        panel.add(lb7, constraints);
        constraints.gridx = 0;
        constraints.gridy = 7;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        panel.add(lb8, constraints);
        constraints.gridx = 0;
        constraints.gridy = 8;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        panel.add(lb9, constraints);
        
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
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 0, 10, 10);
        panel.add(tx3, constraints);
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 0, 10, 10);
        panel.add(tx4, constraints);
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 0, 10, 10);
        panel.add(tx5, constraints);
        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 0, 10, 10);
        panel.add(tx6, constraints);
        constraints.gridx = 1;
        constraints.gridy = 6;
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 0, 10, 10);
        panel.add(tx7, constraints);
        constraints.gridx = 1;
        constraints.gridy = 7;
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 0, 10, 10);
        panel.add(tx8, constraints);
        constraints.gridx = 1;
        constraints.gridy = 8;
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 0, 10, 10);
        panel.add(tx9, constraints);
        
        add(panel);
        
        JButton bt1 = new JButton("添加");
		add(bt1);
		bt1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == bt1) {
					if (tx1.getText().equals("")){ 
						JOptionPane.showMessageDialog(null, "id不能为空"); }
					else if (tx2.getText().equals("")){ 
						JOptionPane.showMessageDialog(null, "用户名不能为空"); }else {
				int id = Integer.parseInt(tx1.getText());
				Employee employee = new Employee(id,
						tx2.getText(),tx3.getText(),tx4.getText(),tx5.getText(),
						tx6.getText(),tx7.getText(),tx8.getText(),tx9.getText());
				EmployeeDAOImpl add = new EmployeeDAOImpl();
				add.add(employee);
				JOptionPane.showMessageDialog(null, "添加成功");
				try {
					new EmAdd();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
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
						new EmployeeManagePane2();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} 
				dispose();
			}
        	
		});
        
        EmployeeDAOImpl employee = new EmployeeDAOImpl();
		ResultSet rs = employee.query();
		Vector<Vector<Object>> list = new Vector<Vector<Object>>();
		
		while(rs.next()) {
			Vector<Object> s=new Vector<Object>();
			s.add(rs.getInt("id"));
			s.add(rs.getString("name"));
			s.add(rs.getString("sex"));
			s.add(rs.getString("birthday"));
			s.add(rs.getString("identityID"));
			s.add(rs.getString("address"));
			s.add(rs.getString("tel"));
			s.add(rs.getString("position"));
			s.add(rs.getString("freeze"));
			list.add(s);
		}
		
		Vector<Object> p = new Vector<Object>();
		p.add("序号");
		p.add("用户名");
		p.add("性别");
		p.add("出生日期");
		p.add("身份证号");
		p.add("家庭住址");
		p.add("电话");
		p.add("职位");
		p.add("是否在职");
		JTable table = new JTable(list, p);
		table.getTableHeader();
		table.setPreferredSize(new Dimension(1100, 500));
		// 将表格添加到 JScrollPane
		scrollPane.setViewportView(table);
		add(scrollPane);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
}
