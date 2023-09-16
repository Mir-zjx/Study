package shixun4;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class FileRecordScore extends RecordScore{
	private String filePath;
	public FileRecordScore(String filePath) {
		this.filePath = filePath;
	}
	
	@Override
	public void save() throws Exception {
		FileWriter fw = new FileWriter(filePath);
		//װ����
		PrintWriter pw = new PrintWriter(fw);
		
		pw.print("����\t");
		pw.print("����\t");
		pw.print("��ѧ\t");
		pw.print("Ӣ��\t");
		pw.println();
		
		
		Set<String> names = getRs().keySet();
		for(String name:names) {
			pw.print(name+"\t");
			List<Integer> scores = getRs().get(name);
			for(Integer score:scores) {
				pw.print(score+"\t");
			}
			pw.println();
		}
		pw.close();
	}
	public static void main(String[] args)throws Exception {
		FileRecordScore fr = new FileRecordScore("d:\\ttt.txt");
		fr.setScore("wang", 90, 1, 0);
		fr.setScore("zhang", Arrays.asList(91,0,0));
		fr.setScore("zhao", Arrays.asList(1,1,1));
		
		fr.save();
	}

}

