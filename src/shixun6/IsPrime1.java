package shixun6;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class IsPrime1 extends Thread {
    private final Map<Integer, String> map = new HashMap<>();

    private boolean checkPrime(int number) {
        if(number < 2) {
            return false; // 0��1��������
        }
        for (int i = 2; i <= Math.sqrt(number); i++) { // �Ż�������Χ
            if (number % i == 0) {
                return false; // ������ʾ��������
            }
        }
        return true;
    }

    private void generateNumbers(int count) {
        for(int i = 0; i < count; i++) {
            Random r = new Random();
            int number = r.nextInt(100);
            String isPrime = checkPrime(number) ? "��" : "��";
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
            isPrime.join(); // �ȴ��߳�ִ�����
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
