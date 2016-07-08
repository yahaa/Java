import java.util.*;
import javafx.geometry.*;
public class Main {
	private static Scanner input=new Scanner(System.in);
	public static void main(String[]args){
		//test1();
		test2();
	}
	
	public static void test1(){
		char []a=new char[3];
		while(input.hasNext()){
			String s=input.next();
			a[0]=s.charAt(0);
			a[1]=s.charAt(1);
			a[2]=s.charAt(2);
			Arrays.sort(a);
			System.out.println(a[0]+" "+a[1]+" "+a[2]);
		}
	}
	
	public static void test2(){
		while(input.hasNext()){
			Point2D a=new Point2D(input.nextDouble(),input.nextDouble());
			Point2D b=new Point2D(input.nextDouble(),input.nextDouble());
			System.out.printf("%.2f\n", a.distance(b));
		}
	}
}
