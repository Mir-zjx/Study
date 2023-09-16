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
		return "Panda[���ƣ�"+name+" ���䣺"+age+" �Ե�ʳ�"+food+" �Ƿ��м�ֵ��"+isProtected+" �Ƿ��м�ֵ��"+isWorth+"]";
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
		return "Tiger[���ƣ�"+name+" ���䣺"+age+" �Ե�ʳ�"+food+" �Ƿ��м�ֵ��"+isProtected+" �Ƿ��м�ֵ��"+isWorth+"]";
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
		return "mouse[���ƣ�"+name+" ���䣺"+age+" �Ե�ʳ�"+food+" �Ƿ��м�ֵ��"+isProtected+" �Ƿ��м�ֵ��"+isWorth+"]";
	}
}

public class AnimalTest {
	public static void main(String[] args) {
		Panda panda = new Panda("����",3,"����",true,true);
		System.out.println(panda);
		
		Tiger tiger = new Tiger("�ϻ�",5,"��",true,true);
		System.out.println(tiger);
		
		Mouse mouse = new Mouse("����",4,"�и�����",false,false);
		System.out.println(mouse);
	}
	
}

