import java.math.BigInteger;
import java.util.*;
public class HDUOJ1715 {
	static final int maxn=1001;
	public static void main(String[]args){
		Scanner input=new Scanner(System.in);
		BigInteger []a=new BigInteger[maxn+1];
		a[1]=new BigInteger("1");
		a[2]=new BigInteger("1");
		for(int i=3;i<=maxn;i++)a[i]=a[i-1].add(a[i-2]);
		int n=input.nextInt();
		while(n-->0){
			int b=input.nextInt();
			System.out.println(a[b]);
		}
	}
}
