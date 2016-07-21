import java.util.*;
import java.io.BufferedInputStream;
public class SDP {
	public static void main(String[]args){
		Shu2011 a=new Shu2011();
		a.solve();
	}

}

class Shu2011{
	private Scanner input=new Scanner(new BufferedInputStream(System.in));
	private int [][]g;
	private int n;
	private int [][]dp;
	private int max;
	public void solve(){
		int tt=1;
		while(input.hasNext()){
			n=input.nextInt();
			input.nextLine();
			if(n==0)break;
			init();
			int ans=doit();
			if(ans!=100000)System.out.printf("Case %d: Granny can make the circuit.\n",tt++);
			else System.out.printf("Case %d: Granny can not make the circuit.\n",tt++);
		}
	}
	
	private void init(){
		g=new int[n+1][n+1];
		String s;
		for(int i=1;i<=n;i++){
			s=input.nextLine();
			for(int j=0;j<s.length();j++){
				Character c=s.charAt(j);
				if(Character.isDigit(c)){
					int t=(int)(c-'0');
					g[i][t]=1;
					g[t][i]=1;
				}
			}
		}
		max=1<<n;
		dp=new int[max][n];
		for(int i=0;i<max;i++){
			Arrays.fill(dp[i], -1);
		}
		
	}
	
	private int find(int s,int v){
		if(dp[s][v]==1)return dp[s][v];
		if(s==(1<<n)-1&&v==0){
			return dp[s][0]=1;
		}
		int ans=0;
		for(int u=0;u<n;u++){
			if((s>>n&1)==0){
				ans=(find(s|1<<u,u)+g[v][u])>0?1:0;
			}
		}
		return dp[s][v]=ans;
	}
	
	private int doit(){
		int mm=100000;
		for(int i=0;i<max;i++){
			Arrays.fill(dp[i],mm);
		}
		dp[(1<<n)-1][0]=0;
		for(int s=max-2;s>=0;s--){
			for(int v=0;v<n;v++){
				for(int u=0;u<n;u++){
					if((s>>u&1)==0){
						dp[s][v]=Math.min(dp[s][v],dp[s|1<<u][u]+g[v][u]);
					}
				}
			}
		}
		return dp[0][0];
	}
}
