package shixun3;

interface Attention<T> {
	void beProtected(T t, boolean isProtected);

	void beWorth(T t, boolean isWorth);
}

class Animal<T> {
	T t;
	String name;
	int age;
	String food;
	boolean isProtected;
	boolean isWorth;

	Animal(T t) {
		this.t = t;
	}

	Animal() {
	}

	Animal(String name, int age, String food, boolean isProtected, boolean isWorth) {
		this.name = name;
		this.age = age;
		this.food = food;
		this.isProtected = isProtected;
		this.isWorth = isWorth;
	}

	T getT() {
		return t;
	}

	void setT(T t) {
		this.t = t;
	}

	@Override
	public String toString() {
		return "Animal{" + "name='" + name + '\'' + ", age=" + age + ", food='" + food + '\'' + ", isProtected="
				+ isProtected + ", isWorth=" + isWorth + '}';
	}
}

class Panda extends Animal<Panda> implements Attention<Panda> {
	Panda(String name, int age, String food, boolean isProtected, boolean isWorth) {
		super(name, age, food, isProtected, isWorth);
	}

	@Override
	public void beProtected(Panda panda, boolean isProtected) {
		System.out.println(isProtected);
	}

	@Override
	public void beWorth(Panda panda, boolean isWorth) {
		System.out.println(isWorth);
	}
}

class Tiger extends Animal<Tiger> implements Attention<Tiger> {
	Tiger(String name, int age, String food, boolean isProtected, boolean isWorth) {
		super(name, age, food, isProtected, isWorth);
	}

	@Override
	public void beProtected(Tiger tiger, boolean isProtected) {
		System.out.println(isProtected);
	}

	@Override
	public void beWorth(Tiger tiger, boolean isWorth) {
		System.out.println(isWorth);
	}
}

class Mouse extends Animal<Mouse> implements Attention<Mouse> {
	Mouse(String name, int age, String food, boolean isProtected, boolean isWorth) {
		super(name, age, food, isProtected, isWorth);
	}

	@Override
	public void beProtected(Mouse mouse, boolean isProtected) {
		System.out.println(isProtected);
	}

	@Override
	public void beWorth(Mouse mouse, boolean isWorth) {
		System.out.println(isWorth);
	}
}

public class AnimalTest {
	public static void main(String[] args) {
		Panda panda = new Panda("±´±´", 3, "Öñ×Ó", true, true);
		System.out.println(panda);

		Tiger tiger = new Tiger("ÀÏ»¢", 5, "Èâ", true, true);
		System.out.println(tiger);

		Mouse mouse = new Mouse("ºÄ×Ó", 4, "²Ð¸þÀäÖË", false, false);
		System.out.println(mouse);
	}
}
