package shixun5_1;


import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerBigFileWithUDP
{
	public static void main(String[] args)
	{
		// ���ڴ�ɽ��յ����ݱ���
		DatagramPacket dp = null;
		//���ڽ������ݱ���
		DatagramSocket ds = null;
		// �ļ��ı���·��
		String fileDir = "D://zjx.txt";
		// socket �������˿ں�
		int port = 4666;
		byte[] buf = new byte [1024 * 8];
		//�ļ��۳���
		DataOutputStream fileOut = null;
		// ��ɴ���Ĵ�С
		long passedlen = 0;
		// �ļ��Ĵ�С
		long len = 0;
		// ÿ�ζ�ȡ���ݵĴ�С
		int readSize = 0;
		// ���ܵ��ļ���
		String fileName = null;
		try
		{
			dp = new DatagramPacket(buf, buf.length);
			ds = new DatagramSocket(port, InetAddress.getByName("localhost"));
			
			System.out.println("���ڵȴ��ͻ������ӡ�����");
			//��ȡ�ļ���
			ds.receive(dp);
			fileName = new String(dp.getData(), 0, dp.getData().length).trim();
			System.out.println(fileName);
			File file = new File(fileDir + fileName);
			if (!file.exists())
			{ file.createNewFile(); }
			
			fileOut = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("D://zjx.txt")));
			ds.receive(dp);
			len = Long.parseLong (new String (buf, 0, dp.getLength()));
			System.out.println("�ļ�����: " + len);
			System.out.println("��ʼ�����ļ���" + '\n');
			ds.receive (dp);
			while ((readSize = dp.getLength ()) != 0)
			{
				passedlen += readSize;
				fileOut.write (buf, 0, readSize);
				fileOut.flush ();
				ds.receive(dp);
			}
			
			// ��ȱ���ļ�ɾ��
			if (passedlen != len)
			{ System.out.printf("IP:%s������%s���������ʧȥ����\n", dp.getAddress(), file.delete()); }
			else
			{ System.out.println("������ɣ��ļ���Ϊ" + file + '\n'); }
		}
		catch (Exception e)
		{
			System.out.println("������Ϣ����" +"n");
			e.printStackTrace();
			return;
		}
		finally
		{
			if (fileOut != null)
			{
				try
				{ fileOut.close (); }
				catch (Exception e1)
				{ e1.printStackTrace (); }
			}				
			if (ds != null)
			{ ds.close (); }
			if (passedlen != len)
			{ System.out.printf("IP:%s������%s���������ʧȥ����\n", dp.getAddress(), fileName); }
		}
	}
}
