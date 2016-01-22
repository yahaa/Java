
import java.util.*;
import java.math.*;
public class Shu1171 {
	public static void main(String []args){
		Scanner input=new Scanner(System.in);
		while(input.hasNext()){
		Integer a=new Integer(input.nextInt());
		System.out.printf("%11d", a);
		System.out.print("-->");
		if(a>=0)System.out.println(Integer.toBinaryString(a));
		else System.out.println("-"+Integer.toBinaryString(Math.abs(a)));
		}
	}

}
