package lastshixun_jiemian;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import lastshixun.CategoryDAOImpl;
import lastshixun.DeskDAOImpl;
import lastshixun.DishDAOImpl;

public class CategoryManagePane2 extends JFrame{
	CategoryManagePane2() throws SQLException{
		setTitle("��Ʒ�����");
		setSize(500, 500);
		setLocation(700, 400);
		setLayout(new FlowLayout());
		JScrollPane scrollPane = new JScrollPane();
		
		JButton bt1 = new JButton("��Ӳ�Ʒ��");
		add(bt1);
		bt1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == bt1) {
				try {
					new CaAdd();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				}
			}
        	
		});
		
		
		JButton bt2 = new JButton("������Ʒ��");
		add(bt2);
		bt2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == bt2) {
				try {
					new CaQuery();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				}
			}
        	
		});
		
		JButton bt3 = new JButton("ɾ����Ʒ��");
		add(bt3);
		bt3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == bt3) {
				try {
					new CaDelete();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				}
			}
        	
		});
		
		JButton bt4 = new JButton("�޸Ĳ�Ʒ��");
		add(bt4);
		bt4.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == bt4) {
				try {
					new CaUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				}
			}
        	
		});
		
		
		JButton bt5 = new JButton("�˳�");
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
		
		CategoryDAOImpl category = new CategoryDAOImpl();
		ResultSet rs = category.query();
		Vector<Vector<Object>> list = new Vector<Vector<Object>>();
		
		while(rs.next()) {
			Vector<Object> s=new Vector<Object>();
			s.add(rs.getInt("id"));
			s.add(rs.getString("name"));
			s.add(rs.getString("describ"));
			list.add(s);
		}
		
		Vector<Object> p = new Vector<Object>();
		p.add("���");
		p.add("����");
		p.add("����");
		JTable table = new JTable(list, p);
		table.getTableHeader();

		// �������ӵ� JScrollPane
		scrollPane.setViewportView(table);
		add(scrollPane);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
