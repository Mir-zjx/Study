package shixun5;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

//客户端发送线程类
public class SendThreadClient implements Runnable{
	private static final String ChatUtils = null;
	private BufferedReader reader;
	private DataOutputStream dos;
	private Socket clientSocket;
	private boolean isRunning;
	private String name;
	
	public SendThreadClient(Socket client,String name) throws IOException {
		this.clientSocket = client;
		this.isRunning = true;
		//获取名称
		this.name = name;
		reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			dos = new DataOutputStream(client.getOutputStream());
			//发送用户名给服务器，用户名用于注册，需要调用send()方法
			send(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//释放相应的资源，包括：输入流、输出流即套接字
			release();
		}
	}
	
	//线程代码，只要当前是连接状态，就一直读取字符串和发送消息
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(isRunning) {
			String msg = null;
			try {
				msg = reader.readLine();
			}catch(IOException e) {
				System.out.println("数据写入失败");
				release();
			}
			send(msg);
		}
	}
	
	public void send(String msg) {
		try {
			dos.writeUTF(msg);
			dos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("数据写入失败");
			release();
		}
	}
	
	//释放资源
	public void release() {
		try {
			this.dos.close();
			this.clientSocket.close();
			this.reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
