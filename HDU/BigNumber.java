import java.util.*;
import java.math.*;
public class BigNumber {
	public static void main(String[]args){
		Scanner input=new Scanner(System.in);
		BigInteger a,b;
		while(input.hasNext()){
			a=input.nextBigInteger();
			b=input.nextBigInteger();
			System.out.println(a.mod(b));
		}
	}

}
