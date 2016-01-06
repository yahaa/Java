package p1;
import java.util.*;
public class Shuoj1153 {
	public static void main(String[]args){
		Scanner input =new Scanner(System.in);
		while(input.hasNext()){
			int n=input.nextInt();
			for(int i=1;i<=n;i++){
				if(i!=n)System.out.print(i*(i-1)/2+" ");
				else System.out.println(i*(i-1)/2);
			}
		}
	}

}
