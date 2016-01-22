
import java.util.*;
import java.math.*;
public class Shuoj1514 {
	public static void main(String[]args){
		Scanner input= new Scanner(System.in);
		BigInteger a;
		BigInteger b;
		while(input.hasNext()){
			a=new BigInteger(input.next());
			b=new BigInteger(input.next());
			System.out.println(a+"*"+b+"="+a.multiply(b));
		}
	}

}
