package shixun4;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    Map<String, Integer> map = new HashMap<>();
    String sno = null;
    String sname = null;
    String id = null;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    void inputScore(Student a) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("D:\\student.dat"));
        out.writeObject(a);
        out.close();

    }

    void readStu() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("D:\\student.dat"));
        Student a = (Student) in.readObject();
        in.close();
        System.out.println("********************ѧ����Ϣ********************");
        System.out.println("ѧ��ѧ�ţ�"+a.getSno());
        System.out.println("ѧ��������"+a.getSname());
        System.out.println("���֤�ţ�"+a.getId()); 
        System.out.println("********���Ƴɼ�********");
        System.out.println("�γ�   �ɼ�");
        System.out.println(a.map);
    }

    void pack(String a, int b) {
        map.put(a, b);
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
    	String course = null;
    	int score = 0;
        Student zjx = new Student();
        Scanner sc = new Scanner(System.in);
        System.out.println("********************������ѧ����Ϣ********************");
        System.out.println("ѧ��ѧ�ţ�");
        String number = sc.next();
        zjx.setSno(number);
        System.out.println("ѧ��������");
        String name = sc.next();
        zjx.setSname(name);
        System.out.println("���֤�ţ�");
        String id = sc.next();
        zjx.setId(id);
        System.out.println("������ѧ���γ�����");
        int coNumber = sc.nextInt();
        System.out.println("������ѧ���ɼ���");
        for(int i = 1;i<=coNumber;i++) {
        	System.out.println("������ѧ����"+i+"�ųɼ�");
        	System.out.println("�γ̣�");
        	course = sc.next();
        	System.out.println("�ɼ���");
        	score = sc.nextInt();
        	zjx.pack(course, score);
        }
        zjx.inputScore(zjx);
        zjx.readStu();

    }
}