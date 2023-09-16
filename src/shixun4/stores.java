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
		fw.write("����   ����   ��ѧ   Ӣ��");
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
		
		// ����һ��Map���������ڴ�Ŷ��ѧ������Ϣ
		Map<String, Map<String, Double>> students = new HashMap<>();

		// ѧ��1����Ϣ
		Map<String, Double> student1 = new HashMap<>();
		student1.put("����", 90.0);
		student1.put("��ѧ", 80.0);
		student1.put("Ӣ��", 85.0);
		students.put("����", student1);

		// ѧ��2����Ϣ
		Map<String, Double> student2 = new HashMap<>();
		student2.put("����", 95.0);
		student2.put("��ѧ", 92.0);
		student2.put("Ӣ��", 88.0);
		students.put("����", student2);
		
		shixun.save(students);

		// �������ѧ������Ϣ
		System.out.println("����   ����   ��ѧ   Ӣ��");
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
