package shixun2;

class Father <T>{
	T fatherData;
	Father(T data){
		this.fatherData=data;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Father[fatherData="+fatherData+"]";
	}
}

class Son1 extends Father<String>{

	Son1(String data) {
		super(data);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Son1[childData="+fatherData+"]";
	}
}

class Son2<T> extends Father<T>{

	Son2(T data) {
		super(data);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Son2[childData="+fatherData+"]";
	}
}

class Son3<T> extends Father<String>{
	T otherData;

	Son3(String data,T otherData) {
		super(data);
		this.otherData=otherData;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Son3[childData="+fatherData+",其他数据" +otherData+"]";
	}
}

class Son4<E,T> extends Father<T>{
	E otherData;
	
	Son4(E e,T t) {
		super(t);
		this.otherData=e;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Son4[childData="+fatherData+",其他数据:" +otherData+"]";
	}
}

public class genericityTest {
	public static void main(String[] args) {
		Son1 son1 = new Son1("Hello");
		System.out.println(son1.toString());
		
		Son2<String> son2 = new Son2<String>("你好");
		System.out.println(son2.toString());
		
		Son3<Boolean> son3 = new Son3<Boolean>("你好",true);
		System.out.println(son3.toString());
		
		Son4<String,Double> son4 = new Son4<String,Double>("Hello",98.0);
		System.out.println(son4.toString());
	}
}
