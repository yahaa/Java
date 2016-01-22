import java.util.*;
public class Shuoj1830 {
	public static void main(String []args){
		Scanner input=new Scanner(System.in);
		int caset=1;
		while(input.hasNext()){
			int a=input.nextInt();
			int b=input.nextInt();
			int c=input.nextInt();
			int x,y,z;
			
				
			for(z=100/c;z>=1;z--)
				for(y=100/c;y>=1;y--)
					for(x=100/a;x>=1;x--){
				     if(a*x+b*y+c*z==100&&x+y+3*z==100)System.out.println(x+" "+y+" "+3*z);
					}
		}
	}

}
