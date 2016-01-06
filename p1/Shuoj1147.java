package p1;
import java.util.*;
public class Shuoj1147 {
	public static void main(String[]args){
		Scanner input=new Scanner(System.in);
		int n;
		double a0;
		double an_1;
		double c[];
		while(input.hasNext()){
			n=input.nextInt();
			c=new double[n+1];
			a0=input.nextDouble();
			an_1=input.nextDouble();
			double sum=0;
			for(int i=1;i<=n;i++){
				sum+=input.nextDouble();
				c[i]=sum;
			}
			double cn=0;
			for(int i=1;i<=n;i++)cn+=c[i];
			double a1=(n*a0+an_1-2*cn)/(n+1);
			System.out.printf("%.2f\n",a1);
			
		}
	}

}
