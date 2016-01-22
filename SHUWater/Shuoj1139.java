
import java.util.*;
import java.lang.*;
public class Shuoj1139 {
	public static void main(String[]agrs){
		
		int n,m;
		Scanner input=new Scanner(System.in);
		while(input.hasNext()){
			n=input.nextInt();
			m=input.nextInt();
			int f=0;
			for(int i=1;i<=n;i++)f=(f+m)%i;
			System.out.println(f+1);
			
		}
	}

}
