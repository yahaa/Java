import java.util.*;
public class HDUOJ2042 {
	public static void main(String[]args){
		Scanner input=new Scanner(System.in);
		int []a=new int[31];
		a[0]=3;
		for(int i=1;i<31;i++)a[i]=(a[i-1]-1)*2;
		int t=input.nextInt();
		while(t-->0){
			System.out.println(a[input.nextInt()]);
		}
	}

}
