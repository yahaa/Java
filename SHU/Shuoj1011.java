import java.util.*;
public class Shuoj1011 {
	public static void main(String[]arg){
		Scanner input=new Scanner(System.in);
		while(input.hasNext()){
			int n,k;
			n=input.nextInt();
			k=input.nextInt();
			int []a=new int [n];
			for(int i=0;i<n;i++)a[i]=input.nextInt();
			int ans=0;
			
			
			System.out.println(ans);
					
		}
	}
	
	
	public static boolean isPrime(int a){
		int n=(int)Math.sqrt(a);
		for(int i=2;i<=n;i++)if(a%i==0)return false;
		return true;
	}

}
