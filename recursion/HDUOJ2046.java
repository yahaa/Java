import java.util.*;
public class HDUOJ2046 {
	public static void main(String[]args){
		Scanner input=new Scanner(System.in);
		long []a=new long[55];
		a[1]=1;
		a[2]=2;
		a[3]=3;
		for(int i=4;i<55;i++)a[i]=a[i-1]+a[i-2];
		while(input.hasNext()){
			int n=input.nextInt();
			System.out.println(a[n]);
		}
	}
}
