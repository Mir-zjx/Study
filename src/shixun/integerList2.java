package shixun;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class integerList2 {
	private List<List<Integer>> integerList;
	
	private integerList2() {
		integerList= new ArrayList<List<Integer>>();
	}
	
	private List<Integer> add(int a){
		List<Integer> s = new ArrayList<Integer>();
		Random r = new Random();
		for(int i = 0;i<a;i++) {
			s.add(r.nextInt(35));
		}
		return s;
	}
	
	private void put(List<Integer> s) {
		integerList.add(s);
	}
	
	
	@Override
	public String toString() {
		String s="[";
		for(List<Integer> l : integerList) {
			s = s+l.toString()+",";
		}
		s=s.substring(0,s.length()-1);
		s=s+"]";
		return s;
		
	}

	public static void main(String[] args) {
		integerList2 list = new integerList2();
		list.put(list.add(4));
		list.put(list.add(3));
		
		System.out.println(list);
	}
}
