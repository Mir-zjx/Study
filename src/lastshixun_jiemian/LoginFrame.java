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
		setTitle("登录界面");
		setSize(300, 140);
		setLocation(700, 400);
		setLayout(new FlowLayout());
		
		//tx1 输入账号
		JLabel lb1 = new JLabel("账号:");
		add(lb1);
		JTextField tx1 = new JTextField(22);
		add(tx1);
	    
		//tx2 输入密码
		JLabel lb2 = new JLabel("密码:");
		add(lb2);
		JTextField tx2 = new JTextField(22);
		add(tx2);
		
		//bt1 注册按钮
		JButton bt1 = new JButton("注册");
		add(bt1);
		bt1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == bt1) {
					if (tx1.getText().equals("")){ 
						JOptionPane.showMessageDialog(null, "账号不能为空"); }
					else if (tx2.getText().equals("")){ 
						JOptionPane.showMessageDialog(null, "密码不能为空"); }
					else {
						User user = new User(tx1.getText(),tx2.getText());
						UserDAOImpl userdaoimpl = new UserDAOImpl();
						if (userdaoimpl.query_1(user.getUsername()) != null) {
						    JOptionPane.showMessageDialog(null, "账号已被使用");
						} else {
						    userdaoimpl.add(user);
						    JOptionPane.showMessageDialog(null, "注册成功");
						}
					}
					
				}
			}
        	
		});
		
		JButton bt2 = new JButton("登录");
		add(bt2);
		bt2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == bt2) {
					if (tx1.getText().equals("")){ 
						JOptionPane.showMessageDialog(null, "账号不能为空"); }
					else if (tx2.getText().equals("")){ 
						JOptionPane.showMessageDialog(null, "密码不能为空"); }
					else {
						User user = new User(tx1.getText(),tx2.getText());
						UserDAOImpl userdaoimpl = new UserDAOImpl();
						if (userdaoimpl.query_1(user.getUsername()) == null) {
						    JOptionPane.showMessageDialog(null, "账号不存在");
						} else {
							User user1 = userdaoimpl.query_1(user.getUsername());
							if(tx2.getText().equals(user1.getPassword())) {
								JOptionPane.showMessageDialog(null, "登录成功");
								new MainFrame();
								dispose();
							}else {
								JOptionPane.showMessageDialog(null, "登录失败");
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

