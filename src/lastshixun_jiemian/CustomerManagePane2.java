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

import lastshixun.CustomerDAOImpl;
import lastshixun.EmployeeDAOImpl;

public class CustomerManagePane2 extends JFrame{
	CustomerManagePane2() throws SQLException{
		setTitle("客户管理");
		setSize(800, 600);
		setLayout(new FlowLayout());
		setLocation(700, 400);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(800, 400));
        panel.setLayout(new GridBagLayout());
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(750, 500));
        
        CustomerDAOImpl customer = new CustomerDAOImpl();
		ResultSet rs = customer.query();
		Vector<Vector<Object>> list = new Vector<Vector<Object>>();
		
		while(rs.next()) {
			Vector<Object> s=new Vector<Object>();
			s.add(rs.getInt("id"));
			s.add(rs.getString("name"));
			s.add(rs.getString("sex"));
			s.add(rs.getString("company"));
			s.add(rs.getString("tel"));
			s.add(rs.getString("cardID"));
			list.add(s);
		}
		
		Vector<Object> p = new Vector<Object>();
		p.add("序号");
		p.add("用户名");
		p.add("性别");
		p.add("单位");
		p.add("电话");
		p.add("贵宾卡号");
		JTable table = new JTable(list, p);
		table.getTableHeader();
		table.setPreferredSize(new Dimension(1100, 500));
		// 将表格添加到 JScrollPane
		scrollPane.setViewportView(table);
		add(scrollPane);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		JButton bt1 = new JButton("添加客户");
		add(bt1);
		bt1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == bt1) {
				new CuAdd();
				dispose();
				}
			}
        	
		});
		
		
		JButton bt2 = new JButton("搜索客户");
		add(bt2);
		bt2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == bt2) {
				new CuQuery();
				dispose();
				}
			}
        	
		});
		
		JButton bt3 = new JButton("删除客户");
		add(bt3);
		bt3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == bt3) {
				new CuDelete();
				dispose();
				}
			}
        	
		});
		
		JButton bt4 = new JButton("修改客户");
		add(bt4);
		bt4.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == bt4) {
				new CuUpdate();
				dispose();
				}
			}
        	
		});
		
		
		JButton bt5 = new JButton("退出");
		add(bt5);
		bt5.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == bt5) {
				new MainFrame();
				dispose();
				}
			}
        	
		});
	}
}
