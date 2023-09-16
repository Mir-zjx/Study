package shixun;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;


public class integerList {
	List l = new ArrayList<List>();
	
	@SuppressWarnings("unchecked")
	void setNumber(int a) {
		for(int i = 0;i<a;i++) {
			Random rand = new Random();
			int b = rand.nextInt(35);
			this.l.add(b);
		}
	}
	
	
	public static void main(String[] args) {
		List<integerList>list1 = new ArrayList();
		for(int i = 0;i<5;i++) {
			integerList list = new integerList();
			list.setNumber(5);
			list1.add(list);
		}
		
		for(int j = 0;j<list1.size();j++) {
			for(int k = 0;k<list1.get(j).l.size();k++) {
				System.out.println(list1.get(j).l.get(k));
			}
		}
	}
}