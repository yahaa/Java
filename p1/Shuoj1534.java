package p1;
import java.util.*;
public class Shuoj1534 {
public static void main(String[]args){
	int a,b;
	Scanner input= new Scanner(System.in);
	while(input.hasNext()){
		a=input.nextInt();
		b=input.nextInt();
		if(a*b==0)break;
		int ans=GCD(a,b*b);
		System.out.println(ans);
	}
}

public static int GCD(int a,int b){
	//b=b*b;
	if(b==0)return a;
	return GCD(b,(a%b)*(a%b));
}
}
