package lastshixun_jiemian;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MainFrame extends JFrame{
	MainFrame(){
		setTitle("餐饮管理系统");
		
		setSize(1000, 500);
		
		setLayout(new FlowLayout());

		// 创建菜单栏
		JMenuBar menuBar = new JMenuBar();

		// 创建员工管理菜单
		JMenu ygglMenu = new JMenu("员工管理");
		JMenuItem openItem1 = new JMenuItem("打开");
		openItem1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == openItem1) {
				try {
					new EmployeeManagePane2();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				}
			}
        	
		});
		
		ygglMenu.add(openItem1);

		// 创建客户管理菜单
		JMenu khglMenu = new JMenu("客户管理");
		JMenuItem openItem2 = new JMenuItem("打开");
		openItem2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == openItem2) {
				try {
					new CustomerManagePane2();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				}
			}
        	
		});
		khglMenu.add(openItem2);

		// 创建菜品管理菜单
		JMenu cpglMenu = new JMenu("菜品管理");
		JMenuItem openItem3 = new JMenuItem("菜品分类");
		openItem3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == openItem3) {
				try {
					new CategoryManagePane2();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				}
			}
        	
		});
		JMenuItem openItem4 = new JMenuItem("菜品信息");
		openItem4.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == openItem4) {
				try {
					new DishManagePane2();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				}
			}
        	
		});
		cpglMenu.add(openItem3);
		cpglMenu.add(openItem4);

		// 创建结账管理菜单
		JMenu jzglMenu = new JMenu("结账管理");
		JMenuItem openItem6 = new JMenuItem("打开");
		openItem6.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == openItem6) {
				new CheckingOutPane2();
				dispose();
				}
			}
        	
		});
		jzglMenu.add(openItem6);
		
		JMenu ctglMenu = new JMenu("餐台管理");
		JMenuItem openItem7 = new JMenuItem("打开");
		openItem7.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == openItem7) {
				try {
					new DeskManagePane2();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				}
			}
        	
		});
		ctglMenu.add(openItem7);
		
		JMenu ktglMenu = new JMenu("开台管理");
		JMenuItem openItem8 = new JMenuItem("打开");
		openItem8.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == openItem8) {
				try {
					new OrderesManagePane2();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				}
			}
        	
		});
		ktglMenu.add(openItem8);
		
		JMenu xstjMenu = new JMenu("销售统计");
		JMenuItem openItem9 = new JMenuItem("打开");
		openItem9.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == openItem9) {
				new MarketPane2();
				dispose();
				}
			}
        	
		});
		xstjMenu.add(openItem9);


		// 把菜单添加到菜单栏
		menuBar.add(ygglMenu);
		menuBar.add(khglMenu);
		menuBar.add(cpglMenu);
		menuBar.add(jzglMenu);
		menuBar.add(ctglMenu);
		menuBar.add(ktglMenu);
		menuBar.add(xstjMenu);

		// 创建帮助菜单
		JMenu helpMenu = new JMenu("帮助");

		// 创建关于菜单项
		JMenuItem aboutItem = new JMenuItem("关于");

		// 把菜单项添加到菜单
		helpMenu.add(aboutItem);
		menuBar.add(helpMenu);

		// 把菜单栏添加到窗口中
		setJMenuBar(menuBar);
		ImageIcon background = new ImageIcon("D:\\桌面\\食物2.jpg");
		Image image = background.getImage();
		Image newImage = image.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
		background = new ImageIcon(newImage);
		JLabel label = new JLabel(background);
		label.setBounds(0, 0, this.getWidth(), this.getHeight());
		getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		((JPanel) getContentPane()).setOpaque(false);

		// 创建欢迎标签
		JLabel welcomeLabel = new JLabel("欢迎来到餐饮管理系统");
		welcomeLabel.setFont(new Font("黑体", Font.BOLD, 30));
		welcomeLabel.setBounds(800, 800, 100, 50);
		//welcomeLabel.setSize(500, 100);
		//welcomeLabel.setLocation(getWidth() / 2 - welcomeLabel.getWidth() / 2, getHeight() / 2 - welcomeLabel.getHeight() / 2);
		add(welcomeLabel);
		


		// 设置窗口位置在屏幕中央
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);
	}
}
