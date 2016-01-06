import java.util.*;
public class Shuoj1543 {
public static void main(String[]args){
	Scanner input=new Scanner(System.in);
	int t=input.nextInt();
	while(t-->0){
		int n=input.nextInt();
		int []a=new int [n];
		for(int i=0;i<n;i++)a[i]=input.nextInt();
		Arrays.sort(a);
		for(int i=0;i<n;i++){
			if(i!=n-1)System.out.print(a[i]+" ");
			else System.out.println(a[i]);
		}
	}
}
}
