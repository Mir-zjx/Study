package lastshixun_jiemian;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
import javax.swing.table.DefaultTableModel;

import lastshixun.CategoryDAOImpl;
import lastshixun.OrderItemDAOImpl;

public class MarketPane2 extends JFrame {
    private JButton confirmButton;
    private JTextField startDateField;
    private JTextField endDateField;
    private JTable table;
    private DefaultTableModel tableModel;
    
    public MarketPane2() {
        // 初始化界面
        setTitle("销售统计");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // 日期输入区域
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel startLabel = new JLabel("开始日期:");
        startDateField = new JTextField(10);
        JLabel endLabel = new JLabel("截止日期:");
        endDateField = new JTextField(10);
        confirmButton = new JButton("确定");
        JButton bt1 = new JButton("退出");
		add(bt1);
		bt1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == bt1) {
				new MainFrame();
				dispose();
				}
			}
        	
		});
        inputPanel.add(startLabel);
        inputPanel.add(startDateField);
        inputPanel.add(endLabel);
        inputPanel.add(endDateField);
        inputPanel.add(confirmButton);
        inputPanel.add(bt1);
        
        add(inputPanel, BorderLayout.NORTH);
        
        // 拉伸表格容器宽度
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        add(scrollPane, BorderLayout.CENTER);

        // 注册事件监听
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String startDateStr = startDateField.getText().trim();
                String endDateStr = endDateField.getText().trim();
                if (startDateStr.equals("") || endDateStr.equals("")) {
                    JOptionPane.showMessageDialog(MarketPane2.this, "Please enter start date and end date", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                	OrderItemDAOImpl orderitem = new OrderItemDAOImpl();
            		ResultSet rs = orderitem.count(startDateStr, endDateStr);
            		Vector<Vector<Object>> list = new Vector<Vector<Object>>();
            		
            		try {
						while(rs.next()) {
							Vector<Object> s=new Vector<Object>();
							s.add(rs.getString("dish.name"));
							s.add(rs.getDouble("allamount"));
							s.add(rs.getDouble("allmoney"));
							list.add(s);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            		
            		Vector<Object> p = new Vector<Object>();
            		p.add("菜品名");
            		p.add("售出数量");
            		p.add("总金额");
                    tableModel = new DefaultTableModel(list, p);
                    table.setModel(tableModel);
                }
            }
        });

        // 设置窗口大小、位置，并显示
        setSize(600, 400);
        setLocationRelativeTo(null); // 居中显示
        setVisible(true);
    }
}