package shixun2;

class point<X,Y>{
	private X x;
	private Y y;
	
	point(X x,Y y){
		this.x=x;
		this.y=y;
	}

	public X getX() {
		return x;
	}

	public void setX(X x) {
		this.x = x;
	}

	public Y getY() {
		return y;
	}

	public void setY(Y y) {
		this.y = y;
	}
}

interface BaseInterface1<X,Y>{
	public <K,V>boolean equalPoint(point<X,Y>p1,point<X,Y>p2);
}

class PointCompare<X,Y>implements BaseInterface1<X,Y>{

	@Override
	public <K, V> boolean equalPoint(point<X, Y> p1, point<X, Y> p2) {
		// TODO Auto-generated method stub
		return (p1.getX().equals(p2.getX()))&&(p1.getY().equals(p2.getY()));
	}
}

public class pointTest {
	public static void main(String[] args) {
		point<String,String>p1 = new point<String,String>("name","zhang");
		point<String,String>p2 = new point<String,String>("name","liu");
		BaseInterface1 utilBase = new PointCompare();
		System.out.println("比较结果：p1=p2\t" +utilBase.equalPoint(p1, p2));
		
		point<Integer,Integer>p3 = new point<Integer,Integer>(55,67);
		point<Integer,Integer>p4 = new point<Integer,Integer>(55,67);
		System.out.println("比较结果：p3=p4\t" +utilBase.equalPoint(p3, p4));
		
		point<Double,Double>p5 = new point<Double,Double>(3.14,3.15);
		point<Double,Double>p6 = new point<Double,Double>(2.13,2.55);
		boolean same = utilBase.equalPoint(p5, p6);
		System.out.println("比较结果：p5=p6\t" +same);
	}
}
