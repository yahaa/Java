
import java.util.*;
public class Shuoj1163 {
public static void main(String[]args){
	Scanner input=new Scanner(System.in);
	int n;
	int []a;
	while(input.hasNext()){
	
		n=input.nextInt();
		a=new int[n];
		for(int i=0;i<n;i++)a[input.nextInt()]++;
		int ans=a[0];
		int index=0;
		for(int i=0;i<n;i++){
			if(a[i]>ans){
				ans=a[i];
				index=i;
			}
		}
		System.out.println(index);
		System.out.println(ans);
		
	}
}
}
