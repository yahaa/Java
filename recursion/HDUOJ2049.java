import java.util.*;
public class HDUOJ2049 {
	static final int max=21;
    public static void main(String[]args){
        Scanner input=new Scanner(System.in);
    	long [][]C=new long[max+1][max+1];
		C[0][0] = 1;
		for (int i = 1; i < max; i++){
			C[i][0] = 1;
			for (int j = 1; j < i; j++)C[i][j] = C[i - 1][j] +C[i - 1][j - 1];
			C[i][i] = 1;
		}
        long []f=new long[max+1];
        f[1]=0;
        f[2]=1;
        for(int i=3;i<=max;i++)f[i]=(i-1)*(f[i-1]+f[i-2]);     //´íÎ»ÅÅÐòË¼Ïë
      
        int t=input.nextInt();
        while(t-->0){
        	int n=input.nextInt();
        	int m=input.nextInt();
        	System.out.println(C[n][m]*f[m]);
        }
		
	}
}
