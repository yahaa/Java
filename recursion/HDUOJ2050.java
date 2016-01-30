import java.util.*;
public class HDUOJ2050 {
	public static void main(String[]args){
		Scanner input=new Scanner(System.in);
		int []a=new int [10001];
		a[1]=2;
		for(int i=2;i<10001;i++)a[i]=a[i-1]+4*(i-1)+1;
		int t=input.nextInt();
		while(t-->0){
			int n=input.nextInt();
			System.out.println(a[n]);
		}
	}
}
