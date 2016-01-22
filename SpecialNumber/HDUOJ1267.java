import java.util.*;
public class HDUOJ1267 {
	static final int maxn=21;
	public static void main(String[]args){
		Scanner input=new Scanner(System.in);
		long [][]ans=new long[maxn][maxn];
		ans[0][0]=1;
		for(int i=1;i<maxn;i++){
			ans[i][0]=1;
			for(int j=1;j<=i;j++){
				ans[i][j]=ans[i-1][j]+ans[i][j-1];
			}
		}

		while(input.hasNext()){
			int m=input.nextInt();
			int n=input.nextInt();
			System.out.println(ans[m][n]);
		}
	}
}
