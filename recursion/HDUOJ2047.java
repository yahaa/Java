import java.util.*;
import java.math.*;
public class HDUOJ2047 { //组合数学递推
	static final int max=41;
	public static void main(String[]args){
		Scanner input=new Scanner(System.in);
		long [][]C=new long[max+1][max+1];
		C[0][0] = 1;
		for (int i = 1; i < max; i++){
			C[i][0] = 1;
			for (int j = 1; j < i; j++)C[i][j] = C[i - 1][j] +C[i - 1][j - 1];
			C[i][i] = 1;
		}
		long []ans=new long[max];
		ans[1]=3;
		for(int i=2;i<max;i++){
			for(int j=0;j<=(i+1)/2;j++){
				ans[i]+=Math.pow(2, i-j)*C[i-j+1][j];
			}
		}
		
		while(input.hasNext()){
			System.out.println(ans[input.nextInt()]);
		}
		
	}

}
