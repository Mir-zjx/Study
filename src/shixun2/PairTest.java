package shixun2;

class Pair<K,V>{
	private K key;
	private V value;
	
	Pair (K key,V value){
		this.key=key;
		this.value=value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
}

interface BaseInterface<K,V>{
	public <K,V>boolean compare(Pair<K,V>p1,Pair<K,V>p2);
}

class PairUtil<K,V>implements BaseInterface<K,V>{

	@Override
	public <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
		// TODO Auto-generated method stub
		return (p1.getKey().equals(p2.getKey()))&&(p1.getValue().equals(p2.getValue()));
	}
	
}

public class PairTest {
	public static void main(String[] args) {
		Pair<String,String>p1 = new Pair<String,String>("name","zhang");
		Pair<String,String>p2 = new Pair<String,String>("name","liu");
		BaseInterface utilBase = new PairUtil();
		System.out.println("比较结果：p1=p2\t" +utilBase.compare(p1, p2));
		
		Pair<String,Integer>p3 = new Pair<String,Integer>("age",67);
		Pair<String,Integer>p4 = new Pair<String,Integer>("age",67);
		System.out.println("比较结果：p3=p4\t" +utilBase.compare(p3, p4));
		
		Pair<String,String>p5 = new Pair<String,String>("name","zhang");
		Pair<String,String>p6 = new Pair<String,String>("name","liu");
		boolean same = utilBase.compare(p5, p6);
		System.out.println("比较结果：p5=p6\t" +same);
		
	}
}
