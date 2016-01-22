import java.util.*;
import java.math.*;
public class HDUOJ1133 {
	static final int maxn=205;
	static final int max=250;
	public static void main(String[]args){
		int tt=1;
		Scanner input=new Scanner(System.in);
		BigInteger t1=new BigInteger("1");
			BigInteger []je=new BigInteger[max];    //求  n!
			je[0]=BigInteger.valueOf(1);
			BigInteger sum=new BigInteger("1");
			BigInteger ii=new BigInteger("1");
			for(int k=1;k<max;k++){
				sum=sum.multiply(ii);
				ii=ii.add(t1);
				je[k]=sum;
			}
			while(input.hasNext()){      //典型的递推过程     f(m,n)=f(m-1,n)+f(m,n-1); 
				int m=input.nextInt();
				int n=input.nextInt();
				if(n==0&&m==0)break;
				System.out.println("Test #"+tt+++":");   //考虑到人不一样  ，所以后面要把人全排
				if(m<n)System.out.println(0);
				else System.out.println(je[m+n].multiply(BigInteger.valueOf(m-n+1)).divide(BigInteger.valueOf(m+1)));
			}
	}
}
