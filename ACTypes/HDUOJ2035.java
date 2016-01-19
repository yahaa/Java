import java.util.Scanner;
public class HDUOJ2035 {
	public static void main(String[]args){
		Scanner input=new Scanner(System.in);
		
		while(input.hasNext()){
			int a=input.nextInt();
			int b=input.nextInt();
			if(a==0&&b==0)break;
			int num=a%1000;
			System.out.println(modexp(num,b));
		}
	}
	
	public static int modexp(int a,int b){
		int ans=1;
		int temp=a;
		while(b>0){
			if((b&1)>0){
				ans*=temp;
				ans%=1000;
			}
			temp*=temp;
			temp%=1000;
			b>>=1;
		}
		return ans;
	}
}
