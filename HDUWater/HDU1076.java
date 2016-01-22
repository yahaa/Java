import java.util.*;
public class HDU1076 {
	public static void main(String[]args){
		Scanner input=new Scanner(System.in);
		int t=input.nextInt();
		while(t-->0){
			int start=input.nextInt();
			int n=input.nextInt();
			while(!((start%4==0&&start%100!=0)||start%400==0))start++;
			while(n>0){
				if((start%4==0&&start%100!=0)||start%400==0)n--;
				start+=4;
			}
			System.out.println(start-4);
		}
	}
}
