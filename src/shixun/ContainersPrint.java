package shixun;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ContainersPrint {
	String a = "java";
	String b = "program";
	String c = "name";
	String d = "ok";
//	String e = "name";
	
	public static void main(String[] args) {
		List<ContainersPrint>list1 = new ArrayList();
		List<ContainersPrint>list2 = new LinkedList();
		Set<ContainersPrint>list3 = new HashSet();
		//Set<ContainersPrint>list4 = new TreeSet<ContainersPrint>();
		Set<ContainersPrint>list5 = new LinkedHashSet();
		
		ContainersPrint list11 = new ContainersPrint();
		
		list1.add(list11);
		list2.add(list11);
		list3.add(list11);
		//list4.add(list11);
		list5.add(list11);
		
		for(ContainersPrint s:list1) {
			System.out.println(s.a+" "+s.b+" "+s.c+" "+s.d+" ");
		}
		for(ContainersPrint s:list2) {
			System.out.println(s.a+" "+s.b+" "+s.c+" "+s.d+" ");
		}
		for(ContainersPrint s:list3) {
			System.out.println(s.a+" "+s.b+" "+s.c+" "+s.d+" ");
		}
		for(ContainersPrint s:list5) {
			System.out.println(s.a+" "+s.b+" "+s.c+" "+s.d+" ");
		}
	}
}
