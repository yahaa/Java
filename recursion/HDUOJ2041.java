import java.util.*;
public class HDUOJ2041 {
	public static void main(String[]args){
		Scanner input=new Scanner(System.in);
		long []a=new long[45];
		a[1]=1;
		a[2]=1;
		for(int i=3;i<45;i++)a[i]=a[i-1]+a[i-2];
		int t=input.nextInt();
		while(t-->0){
			System.out.println(a[input.nextInt()]);
		}
	}

}
