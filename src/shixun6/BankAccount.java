package shixun6;

public class BankAccount {
	static Object lock;
	int count = 0;
	//加synchronized关键字来同步。
	public synchronized void deposit(int money) {
		count+=money;
		//System.out.println("存进"+money);
	}
	
	public synchronized void draw(int money) {
		if((count-money)<0) {
			System.out.println("余额不足");
			return;
		}
		count-=money;
		System.out.println("取出："+money);
	}
	public void find() {
		System.out.println("余额："+count);
	}
}

