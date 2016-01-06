package p1;
import java.util.*;
import java.math.*;
public class Shuoj1561 {
	public static void main(String[]args){
		Scanner input=new Scanner(System.in);
		BigInteger []a=new BigInteger[5000];
		a[0]=new BigInteger("1");
		a[1]=new BigInteger("1");
		for(int i=2;i<5000;i++)a[i]=a[i-1].add(a[i-2]);
		int n;
		while(input.hasNext()){
			n=input.nextInt();
			System.out.println(a[n-1]);
		}
	}

}
