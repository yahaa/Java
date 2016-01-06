
import java.util.*;
public class Shuoj1177 {
	public static void main(String[]args){
		Scanner input=new Scanner(System.in);
		int n,m;
		while(input.hasNext()){
			n=input.nextInt();
			m=input.nextInt();
			if(n%(m+1)==0)System.out.println(1);
			else System.out.println(0);
		}
	}

}
