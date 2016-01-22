import java.util.*;
import java.math.*;
public class HDUOJ1316 {
	static final int maxn=10000;
	public static void main(String[]args){
		Scanner input=new Scanner(System.in);
		BigInteger []a=new BigInteger[maxn];
		a[0]=new BigInteger("1");
		a[1]=new BigInteger("1");
		for(int i=2;i<maxn;i++)a[i]=a[i-1].add(a[i-2]);
		while(input.hasNext()){
			BigInteger aa=input.nextBigInteger();
			BigInteger bb=input.nextBigInteger();
			if(aa.toString()=="0"&&bb.toString()=="0")break;
			int ans=0;
			for(int i=1;i<maxn;i++){
				if(a[i].compareTo(aa)>=0&&a[i].compareTo(bb)<=0)ans++;
			}
			System.out.println(ans);
		}
	}
}
