
import java.lang.reflect.Array;
import java.util.*;
public class Shuoj1140 {
public static void main(String [] args){
	Scanner input=new Scanner(System.in);
	int n,k;
	while(input.hasNext()){
		n=input.nextInt();
		k=input.nextInt();
		int []a=new int[n];
		for(int i=0;i<n;i++)a[i]=input.nextInt();
         Arrays.sort(a);
         int maxMoney=-1000;
         int sale=a[0];
         for(int i=0;i<n;i++){
        	 if(n-i>=k){
        		 if(k*a[i]>maxMoney){
        			 maxMoney=k*a[i];
        			 sale=a[i];
        		 }
        		 
        	 }
        	 else {
        		 if((n-i)*a[i]>maxMoney){
        			 maxMoney=(n-i)*a[i];
        			 sale=a[i];
        		 }
        		
        	 }
         }
         System.out.printf("%d %d\n",sale,maxMoney);
	}
	
}
}
