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
import lastshixun.DishDAOImpl;

public class DishManagePane2 extends JFrame{
	DishManagePane2() throws SQLException{
		setTitle("��Ʒ����");
		setSize(800, 600);
		setLayout(new FlowLayout());
		setLocation(700, 400);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(800, 400));
        panel.setLayout(new GridBagLayout());
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(750, 500));
        
        DishDAOImpl dish = new DishDAOImpl();
		ResultSet rs = dish.query();
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
		p.add("���");
		p.add("��Ʒ��");
		p.add("�����");
		p.add("��Ʒ����");
		p.add("��λ");
		p.add("�۸�");
		p.add("״̬");
		JTable table = new JTable(list, p);
		table.getTableHeader();
		table.setPreferredSize(new Dimension(700, 500));
		// �������ӵ� JScrollPane
		scrollPane.setViewportView(table);
		add(scrollPane);
		
		JButton bt1 = new JButton("��Ӳ�Ʒ");
		add(bt1);
		bt1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == bt1) {
				new DiAdd();
				dispose();
				}
			}
        	
		});
		
		
		JButton bt2 = new JButton("������Ʒ");
		add(bt2);
		bt2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == bt2) {
				new DiQuery();
				dispose();
				}
			}
        	
		});
		
		JButton bt3 = new JButton("ɾ����Ʒ");
		add(bt3);
		bt3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == bt3) {
				new DiDelete();
				dispose();
				}
			}
        	
		});
		
		JButton bt4 = new JButton("�޸Ĳ�Ʒ");
		add(bt4);
		bt4.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == bt4) {
				new DiUpdate();
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
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
