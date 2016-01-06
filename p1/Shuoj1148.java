package p1;
import java.util.*;
public class Shuoj1148 {
public static void main(String []args){
	int n;
	Scanner input=new Scanner(System.in);
	Integer []a= new Integer [1000];
	while(input.hasNext()){
		n=input.nextInt();
		if(n==0)break;
		else {
			for(int i=0;i<n;i++)a[i]=input.nextInt();
			int temp;
			for(int i=1;i<n;i++)
				for(int j=0;j<n-i;j++)
					if(Math.abs(a[j])<Math.abs(a[j+1])){
						temp=a[j];
						a[j]=a[j+1];
						a[j+1]=temp;
					}
			
			for(int i=0;i<n;i++){
				if(i!=n-1)System.out.print(a[i]+" ");
				else System.out.println(a[i]);
			}
		}
			
		}
	}

}

