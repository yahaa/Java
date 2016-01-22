import java.util.*;
public class HDUOJ1050 {    //̰��     ���串����̰��
	static final int maxn=401;
	public static void main(String[]args){    
		int []a=new int[maxn];
		Scanner input=new Scanner(System.in);
		int t=input.nextInt();
		while(t-->0){
			Arrays.fill(a, 0);
			int n=input.nextInt();
			while(n-->0){
				int s=input.nextInt();
				int e=input.nextInt();
				s=(s-1)/2;
				s*=2;
				e=(e-1)/2;
				e*=2;       //�����Ĳ�������������ŵĻ������ź�ż�����Ų���ͬʱ��������
				int ts=s,te=e;
				e=Math.max(ts, te);
				s=Math.min(ts, te);
				for(int i=s;i<=e;i++)a[i]++;
			}
			int ans=-1;
			for(int i=0;i<maxn;i++)if(a[i]>ans)ans=a[i];
			System.out.println(ans*10);
		}
	}
}
