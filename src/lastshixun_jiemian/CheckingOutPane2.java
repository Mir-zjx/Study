package lastshixun_jiemian;
import javax.swing.*;

import lastshixun.DeskDAOImpl;
import lastshixun.OrderDAOImpl;
import lastshixun.OrderItemDAOImpl;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckingOutPane2 extends JFrame implements ActionListener {
    JLabel orderNumberLabel, paymentLabel, discountLabel, receivableAmountLabel, changeAmountLabel;
    JTextField orderNumberField, paymentField, discountField, receivableAmountField, changeAmountField;
    JButton confirmButton;

    public CheckingOutPane2() {
        setTitle("���˹���");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        orderNumberLabel = new JLabel("�����ţ�");
        paymentLabel = new JLabel("ʵ�ս�");
        discountLabel = new JLabel("�Żݣ�");
        receivableAmountLabel = new JLabel("Ӧ�ս�");
        changeAmountLabel = new JLabel("�����");

        orderNumberField = new JTextField();
        paymentField = new JTextField();
        discountField = new JTextField();
        receivableAmountField = new JTextField("0.00"); //���ó�ʼֵ
        receivableAmountField.setEditable(false); //������༭
        changeAmountField = new JTextField("0.00"); //���ó�ʼֵ
        changeAmountField.setEditable(false); //������༭

        confirmButton = new JButton("ȷ��");
        confirmButton.addActionListener(this);
        
        JButton bt1 = new JButton("����");
		add(bt1);
		bt1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == bt1) {
				DeskDAOImpl desk = new DeskDAOImpl();
				OrderDAOImpl order = new OrderDAOImpl();
				desk.update(order.query_desk(Integer.parseInt(orderNumberField.getText())), "����");
				order.update_desk(Integer.parseInt(orderNumberField.getText()), "�ѽ���");
				JOptionPane.showMessageDialog(null, "���˳ɹ�");
				}
			}
        	
		});
		
		JButton bt2 = new JButton("�˳�");
		add(bt2);
		bt2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == bt2) {
				new MainFrame();
				dispose();
				}
			}
        	
		});

        JPanel panel1 = new JPanel(new GridLayout(3, 2));
        panel1.add(orderNumberLabel);
        panel1.add(orderNumberField);
        panel1.add(paymentLabel);
        panel1.add(paymentField);
        panel1.add(discountLabel);
        panel1.add(discountField);

        JPanel panel2 = new JPanel(new GridLayout(2, 2));
        panel2.add(receivableAmountLabel);
        panel2.add(receivableAmountField);
        panel2.add(changeAmountLabel);
        panel2.add(changeAmountField);

        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel3.add(confirmButton);
        panel3.add(bt1);
        panel3.add(bt2);

        setLayout(new BorderLayout());
        add(panel1, BorderLayout.NORTH);
        add(panel2, BorderLayout.CENTER);
        add(panel3, BorderLayout.SOUTH);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (orderNumberField.getText().equals("") || paymentField.getText().equals("")||discountField.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "����������ź�ʵ�ս����Żݣ�", "��ʾ", JOptionPane.WARNING_MESSAGE);
        } else {
            double payment = Double.parseDouble(paymentField.getText());
            double discount = Double.parseDouble(discountField.getText());

            //����Ӧ�տ����������.
            OrderItemDAOImpl orderitem = new OrderItemDAOImpl();
            ResultSet rs = orderitem.count(Integer.parseInt(orderNumberField.getText()));
            double receivableAmount = 0;
			try {
				while(rs.next()) {
				receivableAmount = rs.getDouble("totalPrice");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			try {
				rs.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}//���Ը���ʵ�ʼ������ı�ֵ
            OrderDAOImpl order = new OrderDAOImpl();
            order.update_money(Integer.parseInt(orderNumberField.getText()),receivableAmount );
            double changeAmount = Double.parseDouble(paymentField.getText())-(receivableAmount-discount); //���Ը���ʵ�ʼ������ı�ֵ

            receivableAmountField.setText(String.format("%.2f", receivableAmount)); //��ʽ�����
            changeAmountField.setText(String.format("%.2f", changeAmount)); //��ʽ�����
        }
    }
}