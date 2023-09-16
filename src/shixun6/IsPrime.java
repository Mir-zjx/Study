package shixun6;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class IsPrime extends Thread{
	Map<Integer,String> map = new HashMap<>();
	
	public void isprime() {
		int a = 0;
		int b = 0;
		for(int i=0;i<10;i++) {
			Random r = new Random();
			a = r.nextInt(100);
			a++;
			for(int j=2;j<a;j++) {
				if(a%j==0) {
					b=1;
				}
			}
			if(b==0) {
				this.map.put(a,"是");
			}else 
			{
				this.map.put(a,"否");
			}
			b = 0;
		}
	}
	public void run() {
		isprime();
	}
	
	public static void main(String[] args) {
		IsPrime isPrime = new IsPrime();
        isPrime.start();
        try {
            isPrime.join(); // 等待线程执行完成
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(Map.Entry<Integer, String> entry : isPrime.map.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key +"\t"+ value);
        }
    }
}

