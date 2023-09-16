package lastshixun_jiemian;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import lastshixun.DeskDAOImpl;
import lastshixun.DishDAOImpl;

public class DeskManagePane2 extends JFrame{
	DeskManagePane2() throws SQLException{
		setTitle("餐台管理");
		setSize(800, 600);
		setLayout(new FlowLayout());
		setLocation(700, 400);
		
		BackgroundPanel panel = new BackgroundPanel("D:\\桌面\\食物2.jpg");
		panel.setPreferredSize(new Dimension(800, 400));
        panel.setLayout(new GridBagLayout());
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(750, 500));
        
        DeskDAOImpl desk = new DeskDAOImpl();
		ResultSet rs = desk.query();
		Vector<Vector<Object>> list = new Vector<Vector<Object>>();
		
		while(rs.next()) {
			Vector<Object> s=new Vector<Object>();
			s.add(rs.getInt("id"));
			s.add(rs.getString("no"));
			s.add(rs.getInt("seating"));
			s.add(rs.getString("status"));
			list.add(s);
		}
		
		Vector<Object> p = new Vector<Object>();
		p.add("序号");
		p.add("餐台编号");
		p.add("座位数");
		p.add("状态");
		JTable table = new JTable(list, p);
		table.getTableHeader();
		table.setPreferredSize(new Dimension(700, 500));
		// 将表格添加到 JScrollPane
		scrollPane.setViewportView(table);
		add(scrollPane);
		
		JButton bt1 = new JButton("添加餐台");
		add(bt1);
		bt1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == bt1) {
				new DeAdd();
				dispose();
				}
			}
        	
		});
		
		
		JButton bt2 = new JButton("搜索餐台");
		add(bt2);
		bt2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == bt2) {
				new DeQuery();
				dispose();
				}
			}
        	
		});
		
		JButton bt3 = new JButton("删除餐台");
		add(bt3);
		bt3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == bt3) {
				new DeDelete();
				dispose();
				}
			}
        	
		});
		
		JButton bt4 = new JButton("修改餐台");
		add(bt4);
		bt4.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == bt4) {
				new DeUpdate();
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
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel(String imagePath) {
        try {
            backgroundImage = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Dimension size = new Dimension(backgroundImage.getWidth(null), backgroundImage.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, null);
    }
}
