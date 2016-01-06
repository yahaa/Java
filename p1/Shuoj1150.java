
import java.util.*;
public class Shuoj1150 {
	public static void main(String[]args){
		Scanner input=new Scanner(System.in);
		int []a=new int[31];
		a[1]=1;
		for(int i=2;i<31;i++)a[i]=(a[i-1]+1)*2;
		while(input.hasNext()){
			int n=input.nextInt();
		System.out.println(a[n]);
		}
	}

}
