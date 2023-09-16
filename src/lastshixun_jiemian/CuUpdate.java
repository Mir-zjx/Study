package lastshixun_jiemian;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import lastshixun.Customer;
import lastshixun.CustomerDAOImpl;
import lastshixun.Employee;
import lastshixun.EmployeeDAOImpl;

public class CuUpdate extends JFrame{
	CuUpdate(){
		setTitle("修改客户");
		setSize(330, 500);
		setLayout(new FlowLayout());
		setLocation(700, 400);
		
		JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
		
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
		
		JLabel lb4 = new JLabel("单位:");
		add(lb4);
		JTextField tx4 = new JTextField(22);
		add(tx4);
		
		JLabel lb5 = new JLabel("电话:");
		add(lb5);
		JTextField tx5 = new JTextField(22);
		add(tx5);
		
		JLabel lb6 = new JLabel("VIP号:");
		add(lb6);
		JTextField tx6 = new JTextField(22);
		add(tx6);
		
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
        
        add(panel);
        
        JButton bt1 = new JButton("修改");
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
				Customer customer = new Customer(id,
						tx2.getText(),tx3.getText(),tx4.getText(),tx5.getText(),
						tx6.getText());
				CustomerDAOImpl update = new CustomerDAOImpl();
				update.update(id, customer);
				JOptionPane.showMessageDialog(null, "修改成功");
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
						new CustomerManagePane2();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} 
				dispose();
			}
        	
		});
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
