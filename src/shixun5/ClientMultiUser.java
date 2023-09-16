package shixun5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//�ͻ�����
public class ClientMultiUser {
	public static void main(String[] args) throws IOException {
		System.out.println("-----Client-----");
		System.out.println("�������û�����");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String name = reader.readLine();
		
		//����Socket,�󶨷�����IP��ַ�Ͷ˿ں�
		Socket client = new Socket("localhost",8989);
		
		//ʹ���̳߳ع��������̣߳�һ���Ƿ����̣߳���һ���ǽ����߳�
		ExecutorService pool = Executors.newFixedThreadPool(2);
		
		pool.submit(new SendThreadClient(client,name));
		pool.submit(new ReceiveThreadClient(client));
	}
}


