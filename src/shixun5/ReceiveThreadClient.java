package shixun5;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

//�ͻ��˽����߳���
public class ReceiveThreadClient implements Runnable{
	private boolean isRunning;
	private DataInputStream dis;
	private Socket client;
	
	//�̴߳��룬ֻҪ��ǰ������״̬����һֱ�������ݡ�
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
			System.out.println("���ݽ���ʧ��");
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
