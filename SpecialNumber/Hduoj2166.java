import java.util.*;
import java.math.*;
public class Hduoj2166 {
	public static void main(String []args){
		Scanner input=new Scanner(System.in);
		int k;
		BigInteger a,b;
		BigInteger t2=new BigInteger("2");
		BigInteger t1=new BigInteger("1");
		while(input.hasNext()){
			k=input.nextInt();
			a=input.nextBigInteger();
			b=input.nextBigInteger();
			BigInteger max=new BigInteger("1");
			BigInteger min=new BigInteger("-1");
			for(int i=1;i<k;i++){
				max=max.multiply(t2);
				min=min.multiply(t2);
			}
			max=max.subtract(t1);
			BigInteger sum=a.add(b);
			if((sum.compareTo(max)==-1&&sum.compareTo(min)==1)||
					sum.compareTo(max)==0||sum.compareTo(min)==0)
					System.out.println("WaHaHa");
			else System.out.println("Yes");
		
		}
	}

}
