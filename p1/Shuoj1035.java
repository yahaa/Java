import java.util.*;
import java.math.*;
public class Shuoj1035 {
	public static void main(String[]args){
		Scanner input =new Scanner(System.in);
		
		int ttt=1;
		while(input.hasNext()){
			int n=input.nextInt();
			int m=input.nextInt();
			String sss=input.nextLine();
			if(n==0&&m==0)break;
			String[]a=new String[n];
			int [][]aa=new int [n][m];
			for(int i=0;i<n;i++)a[i]=input.nextLine();
			
			for(int i=0;i<n;i++)
				for(int j=0;j<m;j++){
					if(a[i].charAt(j)!='*'){
						int  temp=0;
						if(i-1>=0&&a[i-1].charAt(j)=='*')temp++;
						if(i-1>=0&&j-1>=0&&a[i-1].charAt(j-1)=='*')temp++;
						if(i-1>=0&&j+1<m&&a[i-1].charAt(j+1)=='*')temp++;
						
						
						if(i+1<n&&a[i+1].charAt(j)=='*')temp++;
						if(i+1<n&&j-1>=0&&a[i+1].charAt(j-1)=='*')temp++;
						if(i+1<n&&j+1<m&&a[i+1].charAt(j+1)=='*')temp++;
						
						if(j-1>=0&&a[i].charAt(j-1)=='*')temp++;
						if(j+1<m&&a[i].charAt(j+1)=='*')temp++;
				       aa[i][j]=temp;
						
					}
				}
		
			System.out.println("Field #"+ttt+++":");
			for(int i=0;i<n;i++)
				for(int j=0;j<m;j++){
					if(a[i].charAt(j)=='*')System.out.print(a[i].charAt(j));
					else System.out.print(aa[i][j]);
					if(j==m-1)System.out.println("");
				}
			System.out.println("");
		}
	}

}
