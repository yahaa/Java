import java.util.*;
import java.math.*;
public class Shuoj1034 {
public static void main(String[]args){
	Scanner input=new Scanner(System.in);
	while(input.hasNext()){
		int star=input.nextInt();
		int end=input.nextInt();
		int ans=0;
		int a=Math.min(star,end);
		int b=Math.max(star,end);
		for(int i=a;i<=b;i++){
			ans=Math.max(ans, solve(i));
		}
		System.out.println(star+" "+end+" "+ans);
	}
}


public static int solve(int n){
	int ans=1;
	while(n!=1){
		if(n%2==0){
			n/=2;
			ans++;
		}
		else {
			ans++;
			n=n*3+1;
		}
	}
	return ans;
}
}
