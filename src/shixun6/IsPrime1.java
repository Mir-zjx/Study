package shixun6;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class IsPrime1 extends Thread {
    private final Map<Integer, String> map = new HashMap<>();

    private boolean checkPrime(int number) {
        if(number < 2) {
            return false; // 0，1不是素数
        }
        for (int i = 2; i <= Math.sqrt(number); i++) { // 优化遍历范围
            if (number % i == 0) {
                return false; // 整除表示不是素数
            }
        }
        return true;
    }

    private void generateNumbers(int count) {
        for(int i = 0; i < count; i++) {
            Random r = new Random();
            int number = r.nextInt(100);
            String isPrime = checkPrime(number) ? "是" : "否";
            map.put(number, isPrime);
        }
    }

    @Override
    public void run() {
        generateNumbers(10);
    }

    public static void main(String[] args) {
        IsPrime1 isPrime = new IsPrime1();
        isPrime.start();
        try {
            isPrime.join(); // 等待线程执行完成
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(Map.Entry<Integer, String> entry : isPrime.map.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println("Key: " + key + " -> Value: " + value);
        }
    }
}
