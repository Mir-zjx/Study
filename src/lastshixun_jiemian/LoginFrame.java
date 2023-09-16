package lastshixun_jiemian;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import lastshixun.User;
import lastshixun.UserDAOImpl;

public class LoginFrame extends JFrame{
	LoginFrame(){
		setTitle("��¼����");
		setSize(300, 140);
		setLocation(700, 400);
		setLayout(new FlowLayout());
		
		//tx1 �����˺�
		JLabel lb1 = new JLabel("�˺�:");
		add(lb1);
		JTextField tx1 = new JTextField(22);
		add(tx1);
	    
		//tx2 ��������
		JLabel lb2 = new JLabel("����:");
		add(lb2);
		JTextField tx2 = new JTextField(22);
		add(tx2);
		
		//bt1 ע�ᰴť
		JButton bt1 = new JButton("ע��");
		add(bt1);
		bt1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == bt1) {
					if (tx1.getText().equals("")){ 
						JOptionPane.showMessageDialog(null, "�˺Ų���Ϊ��"); }
					else if (tx2.getText().equals("")){ 
						JOptionPane.showMessageDialog(null, "���벻��Ϊ��"); }
					else {
						User user = new User(tx1.getText(),tx2.getText());
						UserDAOImpl userdaoimpl = new UserDAOImpl();
						if (userdaoimpl.query_1(user.getUsername()) != null) {
						    JOptionPane.showMessageDialog(null, "�˺��ѱ�ʹ��");
						} else {
						    userdaoimpl.add(user);
						    JOptionPane.showMessageDialog(null, "ע��ɹ�");
						}
					}
					
				}
			}
        	
		});
		
		JButton bt2 = new JButton("��¼");
		add(bt2);
		bt2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == bt2) {
					if (tx1.getText().equals("")){ 
						JOptionPane.showMessageDialog(null, "�˺Ų���Ϊ��"); }
					else if (tx2.getText().equals("")){ 
						JOptionPane.showMessageDialog(null, "���벻��Ϊ��"); }
					else {
						User user = new User(tx1.getText(),tx2.getText());
						UserDAOImpl userdaoimpl = new UserDAOImpl();
						if (userdaoimpl.query_1(user.getUsername()) == null) {
						    JOptionPane.showMessageDialog(null, "�˺Ų�����");
						} else {
							User user1 = userdaoimpl.query_1(user.getUsername());
							if(tx2.getText().equals(user1.getPassword())) {
								JOptionPane.showMessageDialog(null, "��¼�ɹ�");
								new MainFrame();
								dispose();
							}else {
								JOptionPane.showMessageDialog(null, "��¼ʧ��");
							}
						}
					}
					
				}
			}
        	
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

