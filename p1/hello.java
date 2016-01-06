import java.util.*;
public class hello {
	
	public static void main(String[] args){
		final double PI=3.1415;
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		//System.out.println("input radius");
		double radius;
		int n=10;
		while(n-->=0){
		radius=input.nextDouble();
		
		double area;	
		area=radius*radius*PI;
		System.out.println("the area for the ircle of radius "+
		radius+"is "+area);
		}
		
   }
}
