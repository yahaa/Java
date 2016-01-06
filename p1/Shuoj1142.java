import java.util.*;
public class Shuoj1142 {
	public static void main(String[]args){
		Scanner input=new Scanner(System.in);
		long t=input.nextLong();
		while(t-->0){
			int  n=input.nextInt();
			int  q=input.nextInt();
			long []a=new long[n+1];
			long []odda=new long [n+1];
			long []evena=new long[n+1];
			odda[0]=0;
			evena[0]=0;
			for(int i=1;i<=n;i++){
				a[i]=input.nextLong();
				if(a[i]%2==0)evena[i]=evena[i-1]+1;
				else evena[i]=evena[i-1];
				
				
				if(a[i]%2!=0)odda[i]=odda[i-1]+1;
				else odda[i]=odda[i-1];

			}
			
			
			while(q-->0){
				int  star=input.nextInt();
				int end=input.nextInt();
				System.out.println((odda[end]-odda[star-1])*(evena[end]-evena[star-1]));
			}
		}
	}

}
