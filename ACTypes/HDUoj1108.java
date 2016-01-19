import java.util.*;
public class HDUoj1108 {
	public static void main(String[]args){
		Scanner input=new Scanner(System.in);
		while(input.hasNext()){
			int a=input.nextInt();
			int b=input.nextInt();
			System.out.println(a*b/GCD(a,b));
		}
	}
	
	public static int GCD(int a,int b){
		if(b==0)return a;
		else return GCD(b,a%b);
	}
}
