import java.util.*;
public class CFC {
	public static void main(String[]args){
		Scanner input=new Scanner(System.in);
		int rows,clos;
		int [][]query1;
		int [][]query2;
		String []map;
		while(input.hasNext()){
			rows=input.nextInt();
			clos=input.nextInt();
			query1=new int [rows][clos];
			query2=new int [rows][clos];
			map=new String[rows];
			for(int i=0;i<rows;i++)map[i]=input.next();
			

			for(int i=0;i<rows;i++){
				int temp=0;
			for(int j=0;j<clos;j++){
				if(map[i].charAt(j)=='.'&&(j!=map[i].length()-1&&map[i].charAt(j+1)=='.'))query1[i][j]=temp++;
				else query1[i][j]=temp;
			}
			}
			
			
			for(int j=0;j<clos;j++){
				int temp=0;
				for(int i=0;i<rows;i++){
					if(map[i].charAt(j)=='.'&&(i!=rows-1&&map[i+1].charAt(j)=='.'))query2[i][j]=temp++;
					else query2[i][j]=temp;
				}
			}
			
			
			int queries=input.nextInt();
			while(queries-->0){
				int r1=input.nextInt()-1;
				int l1=input.nextInt()-1;
				int r2=input.nextInt()-1;
				int l2=input.nextInt()-1;
				int ans=0;
				for(int i=r1;i<=r2;i++)ans+=query1[i][l2]-query1[i][l1];
				for(int j=l1;j<=l2;j++)ans+=query2[r2][j]-query2[r1][j];
				System.out.println(ans);
			}
		}
	}

}
