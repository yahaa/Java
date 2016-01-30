import java.util.*;
public class HDUOJ2044 {
	static final int max=51;
	public static void main(String[]args){
		Scanner input=new Scanner(System.in);
		long []a=new long[max];
		long []b=new long[max];
		a[1]=1;
		b[1]=1;
		for(int i=2;i<max;i++){
			a[i]=b[i-1]+a[i-1];
			b[i]=a[i]+b[i-1];
		}
		int t=input.nextInt();
		while(t-->0){
			int s=input.nextInt();
			int e=input.nextInt();
			int ans=e-s+1;
			if(ans%2==0)System.out.println(b[ans/2]);
			else System.out.println(a[(ans+1)/2]);
		}
	}
}
