import java.util.*;
import java.math.*;
public class Shuoj534 {
	public static void main(String[]args){
		Scanner input=new Scanner(System.in);
		int a,b;
		while(input.hasNext()){
			a=input.nextInt();
			b=input.nextInt();
			int ans=1;
			
			if(b<5){
				System.out.println(GCD(a,(int)Math.pow(b,b)));
			}
			else {
				for(int i=1;a>1;i++){
					if(isPrime(i)&&a%i==0){
						if(b%i==0){
							ans*=i;
						}
						a/=i;
						i=1;
					}
				}
				
				System.out.println(ans);
			}
			
		}
	}
	
	public static boolean isPrime(int a){
		int n=(int)Math.sqrt(a);
		for(int i=2;i<=n;i++)if(a%i==0)return false;
		return true;
	}
public static int GCD(int a,int b){
	if(b==0)return a;
	else return GCD(b,a%b);
}

}
