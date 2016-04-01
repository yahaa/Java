import java.util.*;
import java.math.*;
public class HDUOJ1207 {
	final static BigInteger INF=new BigInteger("9999999999999999999");
	public static void main(String[]args){
		Scanner input=new Scanner(System.in);
		BigInteger []dp=new BigInteger[600];
		BigInteger t2=new BigInteger("2");
		BigInteger t1=new BigInteger("1");
		dp[1]=BigInteger.valueOf(1);
		dp[2]=BigInteger.valueOf(3);
		for(int i=3;i<600;i++){
			dp[i]=INF;
			for(int j=1;j<i;j++){
				BigInteger tm=pow2(t2,i-j).subtract(t1);
				BigInteger tn=dp[j].multiply(t2);
				dp[i]=min(dp[i],tn.add(tm));
			}
		}
		
		while(input.hasNext()){
			int n=input.nextInt();
			System.out.println(dp[n]);
		}
	}
	
	public static BigInteger min(BigInteger a,BigInteger b){
		if(a.compareTo(b)<=0)return a;
		else return b;
	}
	
	public static BigInteger pow2(BigInteger t2,int n){
		BigInteger t=new BigInteger("2");
		for(int i=1;i<n;i++)t=t.multiply(t2);
		return t;
	}

}
