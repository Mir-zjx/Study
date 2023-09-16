package shixun5;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

//�ͻ��˷����߳���
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
		//��ȡ����
		this.name = name;
		reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			dos = new DataOutputStream(client.getOutputStream());
			//�����û��������������û�������ע�ᣬ��Ҫ����send()����
			send(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//�ͷ���Ӧ����Դ������������������������׽���
			release();
		}
	}
	
	//�̴߳��룬ֻҪ��ǰ������״̬����һֱ��ȡ�ַ����ͷ�����Ϣ
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(isRunning) {
			String msg = null;
			try {
				msg = reader.readLine();
			}catch(IOException e) {
				System.out.println("����д��ʧ��");
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
			System.out.println("����д��ʧ��");
			release();
		}
	}
	
	//�ͷ���Դ
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
