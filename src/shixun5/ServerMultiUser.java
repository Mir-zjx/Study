package shixun5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.Channel;
import java.util.concurrent.CopyOnWriteArrayList;

//编写服务端类
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
				this.send("欢迎光临聊天室...");
				this.sendOther(this.name+"来到了聊天室...",true);
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
					other.send(this.name+"悄悄对你说："+datas);
				}
				
			}
			
		}else {
			for(Channel others:allClient) {
				if(other==this) {
					continue;
				}
				if(!isSys) {
					other.send(this.name+"对大家说："+msg);
				}else {
					other.send(msg);
				}
			}
		}
		
	}
	//用于存储所有客户端的一个容器，涉及多线程的并发操作
	//使用CopyOnWriteArrayList
	private static CopyOnWriteArrayList<Channel>allClient = new CopyOnWriteArrayList<Channel>();
	
	public static void main(String[] args) throws IOException {
		System.out.println("-----Server-----");
		//建立ServerSocket对象，并绑定本地端口
		ServerSocket server = new ServerSocket(8989);
		
		while(true) {
			Socket clientSocket = server.accept();
			Channel client = new Channel(clientSocket);
			allClient.add(client);
			System.out.println("一个客户端建立了连接");
			new Thread(client).start();
		}
	}
	
}
