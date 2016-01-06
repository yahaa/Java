
import java.util.*;
public class Shuoj1138 {
	public static void main(String []args){
		int []a=new int [101];
		a[0]=2;
		for(int i=1;i<101;i++)a[i]=a[i-1]+2;
		Scanner input=new Scanner(System.in);
		int n,m;
		while(input.hasNext()){
			n=input.nextInt();
			m=input.nextInt();
			int ti=n%m;
			if(ti==0){
				for(int i=0;i<n-ti;i++){
					int sum=0,j;
					for(j=i;j<i+m;j++){
						sum+=a[j];
					}
					if(i!=n-ti)System.out.print(sum/m+" ");
					else System.out.println(sum/m);
					i=j-1;
				}
			}
			else {
				for(int i=0;i<n-ti;i++){
					int sum=0,j;
					for(j=i;j<i+m;j++){
						sum+=a[j];
					}
					System.out.print(sum/m+" ");
					i=j-1;
				}
				int sum=0;
				for(int j=n-ti;j<n;j++)sum+=a[j];
				System.out.println(sum/ti);
			}
			
          }
	}
}
