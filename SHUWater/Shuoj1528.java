import java.util.*;
public class Shuoj1528 {
	public static void main(String[]arg){
		Scanner input=new Scanner(System.in);
		final double g=9.81;
		while(input.hasNext()){
			double w,l,s,k;
			w=input.nextDouble();
			l=input.nextDouble();
			s=input.nextDouble();
			k=input.nextDouble();
			double x2=(2*w*g+Math.sqrt(4*w*w*g*g+8*k*w*g*l))/(2*k);
			if(x2+l>=s){
				
				if(l>=s)System.out.println("D");
				else{
					double v=(2*g*s-(k/w)*(s-l)*(s-l));
					if(v>100)System.out.println("D");
					else System.out.println("Y");
				}
				
			}
			else System.out.println("S");
			
		}
	}

}
