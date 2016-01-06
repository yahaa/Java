
public class Cricle2 {
	public static void main(String[] arge){
		System.out.println("this is the test of Circle");
		Circle circle1=new Circle();
		Circle circle2=new Circle(10);
		Circle circle3=new Circle(20);
		System.out.println("the area of circle1 is "+circle1.getArea());
		System.out.println("the perimeter of circle1 is "+circle1.getPerimeter());
		System.out.println("the area of circle2 is "+circle2.getArea());
		System.out.println("the perimeter of circle2 is "+circle2.getPerimeter());
		System.out.println("the area of circle3 is "+circle3.getArea());
		System.out.println("the perimeter of circle3 is "+circle3.getPerimeter());
		
	}
	double radius;
	Cricle2(){
		radius=1;
	}
	Cricle2(double newRadius){
		radius=newRadius;
	}
	double getArea(){
		
		return Math.PI*radius*radius;
	}
	double getPerimeter(){
		return 2*Math.PI*radius;
	}
	void setRadius(double newRadius){
		radius=newRadius;
	}

}
