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
		setTitle("��������ϵͳ");
		
		setSize(1000, 500);
		
		setLayout(new FlowLayout());

		// �����˵���
		JMenuBar menuBar = new JMenuBar();

		// ����Ա������˵�
		JMenu ygglMenu = new JMenu("Ա������");
		JMenuItem openItem1 = new JMenuItem("��");
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

		// �����ͻ�����˵�
		JMenu khglMenu = new JMenu("�ͻ�����");
		JMenuItem openItem2 = new JMenuItem("��");
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

		// ������Ʒ����˵�
		JMenu cpglMenu = new JMenu("��Ʒ����");
		JMenuItem openItem3 = new JMenuItem("��Ʒ����");
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
		JMenuItem openItem4 = new JMenuItem("��Ʒ��Ϣ");
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

		// �������˹���˵�
		JMenu jzglMenu = new JMenu("���˹���");
		JMenuItem openItem6 = new JMenuItem("��");
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
		
		JMenu ctglMenu = new JMenu("��̨����");
		JMenuItem openItem7 = new JMenuItem("��");
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
		
		JMenu ktglMenu = new JMenu("��̨����");
		JMenuItem openItem8 = new JMenuItem("��");
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
		
		JMenu xstjMenu = new JMenu("����ͳ��");
		JMenuItem openItem9 = new JMenuItem("��");
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


		// �Ѳ˵���ӵ��˵���
		menuBar.add(ygglMenu);
		menuBar.add(khglMenu);
		menuBar.add(cpglMenu);
		menuBar.add(jzglMenu);
		menuBar.add(ctglMenu);
		menuBar.add(ktglMenu);
		menuBar.add(xstjMenu);

		// ���������˵�
		JMenu helpMenu = new JMenu("����");

		// �������ڲ˵���
		JMenuItem aboutItem = new JMenuItem("����");

		// �Ѳ˵�����ӵ��˵�
		helpMenu.add(aboutItem);
		menuBar.add(helpMenu);

		// �Ѳ˵�����ӵ�������
		setJMenuBar(menuBar);
		ImageIcon background = new ImageIcon("D:\\����\\ʳ��2.jpg");
		Image image = background.getImage();
		Image newImage = image.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
		background = new ImageIcon(newImage);
		JLabel label = new JLabel(background);
		label.setBounds(0, 0, this.getWidth(), this.getHeight());
		getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		((JPanel) getContentPane()).setOpaque(false);

		// ������ӭ��ǩ
		JLabel welcomeLabel = new JLabel("��ӭ������������ϵͳ");
		welcomeLabel.setFont(new Font("����", Font.BOLD, 30));
		welcomeLabel.setBounds(800, 800, 100, 50);
		//welcomeLabel.setSize(500, 100);
		//welcomeLabel.setLocation(getWidth() / 2 - welcomeLabel.getWidth() / 2, getHeight() / 2 - welcomeLabel.getHeight() / 2);
		add(welcomeLabel);
		


		// ���ô���λ������Ļ����
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);
	}
}
