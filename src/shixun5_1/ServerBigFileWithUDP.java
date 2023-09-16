package shixun5_1;


import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerBigFileWithUDP
{
	public static void main(String[] args)
	{
		// 用于存成接收的数据报包
		DatagramPacket dp = null;
		//用于接收数据报包
		DatagramSocket ds = null;
		// 文件的保存路径
		String fileDir = "D://zjx.txt";
		// socket 服务器端口号
		int port = 4666;
		byte[] buf = new byte [1024 * 8];
		//文件粉出流
		DataOutputStream fileOut = null;
		// 完成传输的大小
		long passedlen = 0;
		// 文件的大小
		long len = 0;
		// 每次读取数据的大小
		int readSize = 0;
		// 接受的文件名
		String fileName = null;
		try
		{
			dp = new DatagramPacket(buf, buf.length);
			ds = new DatagramSocket(port, InetAddress.getByName("localhost"));
			
			System.out.println("正在等待客户端连接。。。");
			//获取文件名
			ds.receive(dp);
			fileName = new String(dp.getData(), 0, dp.getData().length).trim();
			System.out.println(fileName);
			File file = new File(fileDir + fileName);
			if (!file.exists())
			{ file.createNewFile(); }
			
			fileOut = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("D://zjx.txt")));
			ds.receive(dp);
			len = Long.parseLong (new String (buf, 0, dp.getLength()));
			System.out.println("文件长度: " + len);
			System.out.println("开始接收文件！" + '\n');
			ds.receive (dp);
			while ((readSize = dp.getLength ()) != 0)
			{
				passedlen += readSize;
				fileOut.write (buf, 0, readSize);
				fileOut.flush ();
				ds.receive(dp);
			}
			
			// 将缺损文件删除
			if (passedlen != len)
			{ System.out.printf("IP:%s发来的%s传输过程中失去连接\n", dp.getAddress(), file.delete()); }
			else
			{ System.out.println("接收完成，文件存为" + file + '\n'); }
		}
		catch (Exception e)
		{
			System.out.println("接收消息错误" +"n");
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
			{ System.out.printf("IP:%s发来的%s传输过程中失去连接\n", dp.getAddress(), fileName); }
		}
	}
}
