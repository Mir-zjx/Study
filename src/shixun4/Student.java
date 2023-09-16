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
        System.out.println("********************学生信息********************");
        System.out.println("学生学号："+a.getSno());
        System.out.println("学生姓名："+a.getSname());
        System.out.println("身份证号："+a.getId()); 
        System.out.println("********各科成绩********");
        System.out.println("课程   成绩");
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
        System.out.println("********************请输入学生信息********************");
        System.out.println("学生学号：");
        String number = sc.next();
        zjx.setSno(number);
        System.out.println("学生姓名：");
        String name = sc.next();
        zjx.setSname(name);
        System.out.println("身份证号：");
        String id = sc.next();
        zjx.setId(id);
        System.out.println("请输入学生课程数：");
        int coNumber = sc.nextInt();
        System.out.println("请输入学生成绩：");
        for(int i = 1;i<=coNumber;i++) {
        	System.out.println("请输入学生第"+i+"门成绩");
        	System.out.println("课程：");
        	course = sc.next();
        	System.out.println("成绩：");
        	score = sc.nextInt();
        	zjx.pack(course, score);
        }
        zjx.inputScore(zjx);
        zjx.readStu();

    }
}