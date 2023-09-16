package shixun;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class ContainersPrint2 {
	public static Collection<String> fill(Collection<String> c, String[] args){
		for(String str:args) {
			c.add(str);
		}
		return c;
	}
	
	public static void main(String[] args) {
		String[] str = {"java","program","name","ok","name"};
		System.out.println(fill(new ArrayList<String>(),str));
		System.out.println(fill(new LinkedList<String>(),str));
		System.out.println(fill(new HashSet<String>(),str));
		System.out.println(fill(new TreeSet<String>(),str));
	}
}
