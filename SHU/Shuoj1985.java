import java.util.*;
public class Shuoj1985 {
public static void main(String[]args){
	Scanner input=new Scanner(System.in);
	while(input.hasNext()){
		int n=input.nextInt();
		int []a=new int [n];
		for(int i=0;i<n;i++)a[i]=input.nextInt();
		Arrays.sort(a);
		int ans=0;
		int i;
		for(i=n-1;i>=3;i-=2)ans+=Math.min(a[0]+2*a[1]+a[i], 2*a[0]+a[i]+a[i-1]);
		if(i==0)ans+=a[0];
		else if(i==1)ans+=a[i];
		else ans+=(a[2]+a[1]+a[0]);
		System.out.println(ans);
	}
}
}
