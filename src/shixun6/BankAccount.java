package shixun6;

public class BankAccount {
	static Object lock;
	int count = 0;
	//��synchronized�ؼ�����ͬ����
	public synchronized void deposit(int money) {
		count+=money;
		//System.out.println("���"+money);
	}
	
	public synchronized void draw(int money) {
		if((count-money)<0) {
			System.out.println("����");
			return;
		}
		count-=money;
		System.out.println("ȡ����"+money);
	}
	public void find() {
		System.out.println("��"+count);
	}
}

