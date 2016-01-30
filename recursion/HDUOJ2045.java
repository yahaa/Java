import java.util.*;
public class HDUOJ2045 {
	static final int max=51;
	public static void main(String[]args){
		Scanner input=new Scanner(System.in);
		long []a=new long[max];
		long []b=new long[max];
		a[1]=1;
		b[1]=0;
		for(int i=2;i<max;i++){
			a[i]=b[i-1];
			b[i]=a[i-1]*2+b[i-1];
		}
		while(input.hasNext()){
			int n=input.nextInt();
			if(n==1)System.out.println(3);
			else System.out.println(3*b[n]);
		}
	}
}
