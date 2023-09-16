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
		setTitle("��̨����");
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
		
		JLabel lb3 = new JLabel("��̨��:");
		add(lb3);
		JTextField tx3 = new JTextField(40);
		add(tx3);
		
		JLabel lb6 = new JLabel("�ͻ����:");
		add(lb6);
		JTextField tx6 = new JTextField(40);
		add(tx6);
		
		JLabel lb8 = new JLabel("�Ͳ�����:");
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
        
        JButton bt1 = new JButton("��̨");
		add(bt1);
		bt1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == bt1) {
					if (tx1.getText().equals("")){ 
						JOptionPane.showMessageDialog(null, "id����Ϊ��"); }
					else if (tx3.getText().equals("")){ 
						JOptionPane.showMessageDialog(null, "��̨�Ų���Ϊ��"); }
					else if (tx6.getText().equals("")){ 
						JOptionPane.showMessageDialog(null, "�ͻ���Ų���Ϊ��"); }
					else if (tx8.getText().equals("")){ 
						JOptionPane.showMessageDialog(null, "�Ͳ���������Ϊ��"); }
					else {
				int id = Integer.parseInt(tx1.getText());
				Order order = new Order(id,
						Integer.parseInt(tx3.getText()),
						Integer.parseInt(tx6.getText()),Integer.parseInt(tx8.getText()));
				OrderDAOImpl add = new OrderDAOImpl();
				add.add(order);
				DeskDAOImpl update = new DeskDAOImpl();
				update.update(Integer.parseInt(tx3.getText()), "��Ԥ��");
				JOptionPane.showMessageDialog(null, "��̨�ɹ�");
				dispose();
				new DishesOrderesManagePane2(id);
						}
			}
			}
        	
		});
		
		
		JButton bt2 = new JButton("ȡ��");
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
		
		JButton bt3 = new JButton("ˢ��");
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
		
		JButton bt4 = new JButton("��ʷ");
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
		
		JButton bt5 = new JButton("�޸Ķ���");
		add(bt5);
		bt5.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == bt5) {
					if (tx1.getText().equals("")){ 
						JOptionPane.showMessageDialog(null, "id����Ϊ��"); }
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
		p.add("��̨���");
		p.add("��̨���");
		p.add("��λ��");
		p.add("״̬");
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
