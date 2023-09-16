package shixun5_1;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientBigFileWithUDP
{
	public static void main (String[] args)
	{
		DatagramSocket ds = null;
		DatagramPacket dp = null;
		DataInputStream dis = null;
		FileInputStream fis = null;

		String host = "127.0.0.1";
		int port = 4666;
		try
		{
			//创建数据报套接字，用于发送数据报包。将其绑定到指定的本地地址。
			ds = new DatagramSocket (3666, InetAddress.getByName ("127.0.0.1"));
			byte[] buf = new byte[1024*8];
			dp = new DatagramPacket(buf, buf.length, InetAddress.getByName(host), port);
			File file = new File ("D://zjx.txt");
			System.out.println("文件长度：" + (int) file.length());
			
			fis = new FileInputStream(file);
			dis = new DataInputStream (fis) ;
			
			//首先发送文件名
			System.out.println("文件名:" + file.getName());
			buf = file.getName().getBytes();
			dp.setData(buf, 0, buf.length);
		
			String fileLen = Long.toString ((long) file. length ());
			buf = fileLen. getBytes () ;
			System.out.println("buf文件长度" + new String (buf));
			dp.setData (buf, 0, buf.length) ;
			ds.send (dp);
			
			while (true)
			{
				int readLen = 0;
				if (fis != null)
				{ readLen = fis.read (buf); }
				if (readLen == -1)
				{ break; }
				dp.setData(buf, 0, readLen);
				ds.send(dp) ;
			}
			//给服务器发布一个终止信号
			dp.setData(buf, 0, 0);
			System.out.println("文件传输完成");
		}
		catch(Exception e)
		{
			System.out.println("服务器" + host + ":" + port + "失去连接");
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (fis != null)
				{ fis.close(); }
				if (ds != null)
				{ ds.close(); }
			}
			catch(Exception e)
			{ e.printStackTrace(); }
		}
	}
}
