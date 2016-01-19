import java.util.*;
public class HDUoj1025 {
	public static void main(String[]args){
		Scanner input=new Scanner(System.in);
		int t=input.nextInt();
		while(t-->0){
			int n=input.nextInt();
			long sum=0;
			long maxn=-1000;
			long temp;
			for(int i=0;i<n;i++){
				temp=input.nextLong();
				sum+=temp;
				maxn=Math.max(temp, maxn);
			}
			sum-=maxn;
			if(maxn-1>sum)System.out.println("No");
			else System.out.println("Yes");
		}
	}
}
