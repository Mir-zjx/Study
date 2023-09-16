package shixun5;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

//客户端接收线程类
public class ReceiveThreadClient implements Runnable{
	private boolean isRunning;
	private DataInputStream dis;
	private Socket client;
	
	//线程代码，只要当前是连接状态，就一直接收数据。
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(isRunning) {
			String msg = "";
			msg = receive();
			if(!msg.equals("")) {
				System.out.println(msg);
			}
		}
	}
	public String receive() {
		String msg = null;
		try {
			msg = dis.readUTF();
			return msg;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("数据接收失败");
			release();
		}
		return"";
		
	}
	public void release() {
		isRunning = false;
		try {
			this.dis.close(); 
			this.client.close();;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
