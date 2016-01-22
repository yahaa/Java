import java.util.*;
import java.math.*;
public class Hduoj1021 {
	public static void main(String[]args){
		Scanner input= new Scanner(System.in);
		int n;
		while(input.hasNext()){
			n=input.nextInt();
			if((n+2)%4==0)System.out.println("yes");
			else System.out.println("no");
		}
	}

}
