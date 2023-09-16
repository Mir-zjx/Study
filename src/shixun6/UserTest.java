package shixun6;

public class UserTest {
    public static void main(String[] args) throws InterruptedException {
        BankAccount bank = new BankAccount();
        Object outputLock = new Object();

        Thread depositUser1 = new Thread(new Runnable() {
            public void run() {
                int Alice = 3000;
                while (true) {
                    if (Alice > 0) {
                        synchronized (outputLock) {
                            System.out.println("Alice ´æ1000");
                            bank.deposit(1000);// ´æÇ®
                            bank.find();// ²éÑ¯Óà¶î
                        }
                        Alice = Alice - 1000;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread depositUser2 = new Thread(new Runnable() {
            public void run() {
                int Bob = 3000;
                while (true) {
                    if (Bob > 0) {
                        synchronized (outputLock) {
                            System.out.println("Bob ´æ1000");
                            bank.deposit(1000);
                            bank.find();
                        }
                        Bob = Bob - 1000;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread drawUser = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    synchronized (outputLock) {
                        bank.draw(1000);
                        bank.find();
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        depositUser1.start();
        depositUser2.start();
        drawUser.start();
    }
}
