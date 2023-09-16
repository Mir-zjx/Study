package shixun5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//客户端类
public class ClientMultiUser {
	public static void main(String[] args) throws IOException {
		System.out.println("-----Client-----");
		System.out.println("请输入用户名：");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String name = reader.readLine();
		
		//创建Socket,绑定服务器IP地址和端口号
		Socket client = new Socket("localhost",8989);
		
		//使用线程池管理两个线程，一个是发送线程，另一个是接受线程
		ExecutorService pool = Executors.newFixedThreadPool(2);
		
		pool.submit(new SendThreadClient(client,name));
		pool.submit(new ReceiveThreadClient(client));
	}
}


