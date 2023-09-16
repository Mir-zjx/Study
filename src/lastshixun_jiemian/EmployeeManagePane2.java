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

import lastshixun.CategoryDAOImpl;
import lastshixun.Employee;
import lastshixun.EmployeeDAOImpl;
import lastshixun.User;
import lastshixun.UserDAOImpl;

public class EmployeeManagePane2 extends JFrame{
	EmployeeManagePane2() throws SQLException{
		setTitle("Ա������");
		setSize(1200, 600);
		setLayout(new FlowLayout());
		setLocation(700, 400);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(1200, 400));
        panel.setLayout(new GridBagLayout());
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(1150, 500));
        
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
		p.add("���");
		p.add("�û���");
		p.add("�Ա�");
		p.add("��������");
		p.add("���֤��");
		p.add("��ͥסַ");
		p.add("�绰");
		p.add("ְλ");
		p.add("�Ƿ���ְ");
		JTable table = new JTable(list, p);
		table.getTableHeader();
		table.setPreferredSize(new Dimension(1100, 500));
		// �������ӵ� JScrollPane
		scrollPane.setViewportView(table);
		add(scrollPane);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		JButton bt1 = new JButton("���Ա��");
		add(bt1);
		bt1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == bt1) {
				try {
					new EmAdd();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				}
			}
        	
		});
		
		
		JButton bt2 = new JButton("����Ա��");
		add(bt2);
		bt2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == bt2) {
				new EmQuery();
				dispose();
				}
			}
        	
		});
		
		JButton bt3 = new JButton("ɾ��Ա��");
		add(bt3);
		bt3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == bt3) {
				new EmDelete();
				dispose();
				}
			}
        	
		});
		
		JButton bt4 = new JButton("�޸�Ա��");
		add(bt4);
		bt4.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == bt4) {
				new EmUpdate();
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
		
		
	}
}


