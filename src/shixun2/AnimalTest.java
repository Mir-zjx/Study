package shixun2;

interface Attention<T>{
	public <T>void beProtected(T t,boolean isProtected);
	
	public <T>void beWorth(T t,boolean isWorth);
}

class Animal<T>{
	T t;
	String name;
	int age;
	String food;
	boolean isProtected;
	boolean isWorth;
	
	Animal(T t){
		this.t=t;
	}
	
	T getT() {
		return t;
	}
	
	void setT(T t) {
		this.t=t;
	}
	
	Animal(){}
	
	Animal(String name,int age,String food) {
		this.name=name;
		this.age=age;
		this.food=food;
	}
}

class Panda extends Animal<Panda>implements Attention<Panda>{

	public <T> void beProtected(T t, boolean isProtected) {
		System.out.println(isProtected);
		
	}

	
	public <T> void beWorth(T t, boolean isWorth) {
		System.out.println(isWorth);
		
	}
	
	Panda(String name,int age,String food,boolean isProtected,boolean isWorth) {
		this.name=name;
		this.age=age;
		this.food=food;
		this.isProtected = isProtected;
		this.isWorth = isWorth;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Panda[名称："+name+" 年龄："+age+" 吃的食物："+food+" 是否有价值："+isProtected+" 是否有价值："+isWorth+"]";
	}
	
}

class Tiger extends Animal<Tiger>implements Attention<Tiger>{

	public <T> void beProtected(T t, boolean isProtected) {
		System.out.println(isProtected);
		
	}

	
	public <T> void beWorth(T t, boolean isWorth) {
		System.out.println(isWorth);
		
	}
	
	Tiger(String name,int age,String food,boolean isProtected,boolean isWorth) {
		this.name=name;
		this.age=age;
		this.food=food;
		this.isProtected = isProtected;
		this.isWorth = isWorth;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Tiger[名称："+name+" 年龄："+age+" 吃的食物："+food+" 是否有价值："+isProtected+" 是否有价值："+isWorth+"]";
	}
	
}

class Mouse extends Animal<Mouse>implements Attention<Mouse>{

	
	public <T> void beProtected(T t, boolean isProtected) {
		System.out.println(isProtected);
		
	}

	
	public <T> void beWorth(T t, boolean isWorth) {
		System.out.println(isWorth);
		
	}
	
	Mouse(String name,int age,String food,boolean isProtected,boolean isWorth) {
		this.name=name;
		this.age=age;
		this.food=food;
		this.isProtected = isProtected;
		this.isWorth = isWorth;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "mouse[名称："+name+" 年龄："+age+" 吃的食物："+food+" 是否有价值："+isProtected+" 是否有价值："+isWorth+"]";
	}
}

public class AnimalTest {
	public static void main(String[] args) {
		Panda panda = new Panda("贝贝",3,"竹子",true,true);
		System.out.println(panda);
		
		Tiger tiger = new Tiger("老虎",5,"肉",true,true);
		System.out.println(tiger);
		
		Mouse mouse = new Mouse("耗子",4,"残羹冷炙",false,false);
		System.out.println(mouse);
	}
	
}

