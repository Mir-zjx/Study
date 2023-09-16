package shixun5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.Channel;
import java.util.concurrent.CopyOnWriteArrayList;

//��д�������
public class ServerMultiUser {
	static class Channel implements Runnable{
		private DataInputStream dis;
		private DataOutputStream dos;
		private Socket client;
		private boolean isRunning;
		private String name;
		
		public Channel(Socket client) throws IOException {
			this.client = client;
			this.isRunning = true;
			
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
				this.name = receive();
				this.send("��ӭ����������...");
				this.sendOther(this.name+"������������...",true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				release();
			}
			
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
	}
	
	public void sendOther(String msg,boolean isSys) {
		boolean isPrivate = msg.startsWith("@");
		if(isPrivate) {
			int index = msg.indexOf(":");
			String targetName = msg.substring(1,index);
			String datas = msg.substring(index+1);
			for(Channel other :allClient) {
				if(other.name.equals(targetName)) {
					other.send(this.name+"���Ķ���˵��"+datas);
				}
				
			}
			
		}else {
			for(Channel others:allClient) {
				if(other==this) {
					continue;
				}
				if(!isSys) {
					other.send(this.name+"�Դ��˵��"+msg);
				}else {
					other.send(msg);
				}
			}
		}
		
	}
	//���ڴ洢���пͻ��˵�һ���������漰���̵߳Ĳ�������
	//ʹ��CopyOnWriteArrayList
	private static CopyOnWriteArrayList<Channel>allClient = new CopyOnWriteArrayList<Channel>();
	
	public static void main(String[] args) throws IOException {
		System.out.println("-----Server-----");
		//����ServerSocket���󣬲��󶨱��ض˿�
		ServerSocket server = new ServerSocket(8989);
		
		while(true) {
			Socket clientSocket = server.accept();
			Channel client = new Channel(clientSocket);
			allClient.add(client);
			System.out.println("һ���ͻ��˽���������");
			new Thread(client).start();
		}
	}
	
}
