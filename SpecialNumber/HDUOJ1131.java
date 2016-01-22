
import java.util.*;
import java.math.*;
public class HDUOJ1131 {
	static final int max=105;
	public static void main(String[]args){           //卡特兰数   +斯特林公式求阶层
		Scanner input=new Scanner(System.in);                              
				BigInteger []a=new BigInteger[max];
				BigInteger t1=new BigInteger("1");
				BigInteger t2=new BigInteger("2");
				BigInteger t4=new BigInteger("4");
				a[0]=t1;
				a[1]=t1;
				BigInteger i=new BigInteger("2");
				BigInteger maxn=new BigInteger("101");
				int j=2;
				while(j<101){
					a[j]=a[j-1].multiply(t4.multiply(i).subtract(t2)).divide(i.add(t1));     //求卡特兰数
					i=i.add(t1);
					j++;
				}  
				
				BigInteger []je=new BigInteger[max];   //求  n!
				BigInteger sum=new BigInteger("1");
				BigInteger ii=new BigInteger("1");
				for(int k=1;k<max;k++){
					sum=sum.multiply(ii);
					ii=ii.add(t1);
					je[k]=sum;
				}
				
				while(input.hasNext()){
					int n=input.nextInt();
					if(n==0)break;
					System.out.println(a[n].multiply(je[n]));
				}
	}
}
