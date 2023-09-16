package shixun4;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class stores {
	void save(Map<String, Map<String, Double>> students) throws IOException {
		FileWriter fw = new FileWriter("D:\\zjx2.txt", true);
		fw.write("姓名   语文   数学   英语");
		for (String name : students.keySet()) {
			fw.write('\n' + name + "   ");
			Map<String, Double> scores = students.get(name);
			for (String subject : scores.keySet()) {
				fw.write(scores.get(subject) + "   ");
			}
		}
		fw.close();
	}

	public static void main(String[] args) throws IOException {
		stores shixun = new stores();
		
		// 创建一个Map容器，用于存放多个学生的信息
		Map<String, Map<String, Double>> students = new HashMap<>();

		// 学生1的信息
		Map<String, Double> student1 = new HashMap<>();
		student1.put("语文", 90.0);
		student1.put("数学", 80.0);
		student1.put("英语", 85.0);
		students.put("张三", student1);

		// 学生2的信息
		Map<String, Double> student2 = new HashMap<>();
		student2.put("语文", 95.0);
		student2.put("数学", 92.0);
		student2.put("英语", 88.0);
		students.put("李四", student2);
		
		shixun.save(students);

		// 输出所有学生的信息
		System.out.println("姓名   语文   数学   英语");
		for (String name : students.keySet()) {
			System.out.print(name + "   ");
			Map<String, Double> scores = students.get(name);
			for (String subject : scores.keySet()) {
				System.out.print(scores.get(subject) + "   ");
			}
			System.out.println();
		}
	}
}
