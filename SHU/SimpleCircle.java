import java.util.*;
public class SimpleCircle {
	public static void main(String[] args){
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

}
class Circle{
	double radius;
	Circle(){
		radius=1;
		System.out.println("kdsjklfjdslakjfksdjf");
	}
	
	Circle(double n){
		radius=n;
	}
	
	double getPerimeter(){
		return 2*radius*Math.PI;
	}
	double getArea(){
		return radius*radius*Math.PI;
	}
	void setRadius(double newRadius){
		radius=newRadius;
	}
}
