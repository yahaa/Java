import java.io.BufferedInputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.util.List;

public class Main {

	private static Scanner input=new Scanner(System.in);
	public static void main(String []args){
		//test1();
		//test2();
//		CF19B a=new CF19B();
//		a.solve();
		
		//BigInteger a=new BigInteger("12344444445555555555555555555555555555555555555555555555555555");
		//System.out.println(a.longValue());
		Number[] nn=new Integer[2];
		nn[0]=new Double(1.4);
		System.out.println(nn[0]);
	}
}

class POJ1979{
	private String []map;
	private int [][]visit;
	private Scanner input=new Scanner(new BufferedInputStream(System.in));
	private int w,h;
	private int ans;
	
	public void solve(){
		
		while(input.hasNext()){
			w=input.nextInt();
			h=input.nextInt();
			input.nextLine();
			if(w==0&&h==0)break;
			initMap();
			getAns();
			System.out.println(ans);
		}	
	}
	
	private void initMap(){
		map=new String[h];
		visit=new int[h][w];
		for(int i=0;i<h;i++){
			map[i]=input.next();
			Arrays.fill(visit[i],0);
		}
		ans=0;
	}
	
	private void getAns(){
		int i=0,j=0;
		boolean ff=false;
		for(i=0;i<h;i++){
			for(j=0;j<w;j++){
				if(map[i].charAt(j)=='@'){
					ff=true;
					break;
				}
			}
			if(ff)break;
		}
		find(i,j);
	}
	
	private void find(int i,int j){
		if(i<0||i>=h||j<0||j>=w)return;
		if(visit[i][j]==1)return;
		if(map[i].charAt(j)=='#')return;
		visit[i][j]=1;
		ans++;
		find(i-1,j);
		find(i+1,j);
		find(i,j-1);
		find(i,j+1);
	}
	

}


class POJ3009{
	private int[][]m;
	private Scanner input=new Scanner(new BufferedInputStream(System.in));
	private int h,w;
	private int ans;
	private int starti,startj,endi,endj;
	
	
	public void solve(){
		while(input.hasNext()){
			w=input.nextInt();
			h=input.nextInt();
			if(w==0&&h==0)break;
			init();
			getAns();
			if(ans>10)ans=-1;
			System.out.println(ans);
		}
	}
	
	private void init(){
		m=new int[h][w];
		ans=100;
		for(int i=0;i<h;i++){
			for(int j=0;j<w;j++){
				m[i][j]=input.nextInt();
				if(m[i][j]==2){
					starti=i;
					startj=j;
				}
				if(m[i][j]==3){
					endi=i;
					endj=j;
				}
			}
		}
	}
	
	private void getAns(){
		find(starti,startj,0);
	}
	
	private void find(int i,int j,int step){
		if(i<0||i>=h||j<0||j>=w)return;
		if((i==endi&&j==endj)||step>10){
			ans=Math.min(ans, step);
			return;
		}
		for(int dir=1;dir<=4;dir++){
			if(dir==1){
				boolean ok=false;
				int ti=i;
				while(ti-1>=0&&m[ti-1][j]!=1){
					if(ti-1==endi&&j==endj){
						find(ti-1,j,step+1);
						ok=false;
						break;
					}
					else{
						ti--;
						ok=true;
					}
				}
				if(ok&&ti-1>=0){
					m[ti-1][j]=0;
					find(ti,j,step+1);
					m[ti-1][j]=1;
				}
			}
			if(dir==2){
				boolean ok=false;
				int tj=j;
				while(tj+1<w&&m[i][tj+1]!=1){
					if(tj+1==endj&&i==endi){
						find(i,tj+1,step+1);
						ok=false;
						break;
					}
					else {
						tj++;
						ok=true;
					}
				}
				if(ok&&tj+1<w){
					m[i][tj+1]=0;
					find(i,tj,step+1);
					m[i][tj+1]=1;
				}
			}
			
			if(dir==3){
				boolean ok=false;
				int ti=i;
				while(ti+1<h&&m[ti+1][j]!=1){
					if(ti+1==endi&&j==endj){
						find(ti+1,j,step+1);
						ok=false;
						break;
					}
					else {
						ok=true;
						ti++;
					}
				
				}
				if(ok&&ti+1<h){
					m[ti+1][j]=0;
					find(ti,j,step+1);
					m[ti+1][j]=1;
				}
			}
			
			if(dir==4){
				boolean ok=false;
				int tj=j;
				while(tj-1>=0&&m[i][tj-1]!=1){
					if(tj-1==endj&&i==endi){
						find(i,tj-1,step+1);
						ok=false;
						break;
					}
					else {
						tj--;
						ok=true;
					}
				
				}
				if(ok&&tj-1>=0){
					m[i][tj-1]=0;
					find(i,tj,step+1);
					m[i][tj-1]=1;
				}
			}
		}
		
	}
	
	
	
}


class POJ3669{
	private int [][]m=new int[305][305];
	private int n;
	private Scanner input=new Scanner(new BufferedInputStream(System.in));
	private ArrayList<Two>in;
	private class Two{
		int x,y;
	}
	
	public void solve(){
		while(input.hasNext()){
			n=input.nextInt();
			init();
			bfs(0,0,0);
		}
	}
	
	private void init(){
		
	}
	private void bfs(int i,int j,int time){
		
	}
}


class RMQ{
	public long mark;
	public long value;
	public int start,end;
}


class POJ3468{
	
	private Scanner input=new Scanner(new BufferedInputStream(System.in));
	private int n,q;
	private RMQ []a;
	
	public void solve(){
		while(input.hasNext()){
			n=input.nextInt();
			q=input.nextInt();
			input.nextLine();
			init();
			build(1,n,1);
			operator(q);
			
		}
	}
	
	private void init(){
		int max=n*4+5;
		a=new RMQ[max];
		for(int i=0;i<max;i++){
			a[i]=new RMQ();
			a[i].mark=0;
			a[i].value=0;
			a[i].start=0;
			a[i].end=0;
		}
	}
	
	private void build(int start,int end,int index){
		if(start==end){
			a[index].value=input.nextInt();
			a[index].start=a[index].end=start;
			return;
		}
		int mid=(start+end)/2;
		build(start,mid,index*2);
		build(mid+1,end,index*2+1);
		a[index].value=a[index*2].value+a[index*2+1].value;
		a[index].start=a[index*2].start;
		a[index].end=a[index*2+1].end;
	}
	
	private void operator(int times){
		String s=null;
		int a,b;
		long v;
		while(times-->0){
			s=input.next();
			if(s.equals("Q")){
				a=input.nextInt();
				b=input.nextInt();
				System.out.println(query(a,b,1,n,1));
			}
			else if(s.equals("C")){
				a=input.nextInt();
				b=input.nextInt();
				v=input.nextLong();
				update(a,b,v,1,n,1);
			}
		}
	}
	
	
	private long query(int qStart,int qEnd,int start,int end,int index){
		if(qStart==start&&qEnd==end)return a[index].value;
		putDown(index);
		int mid=(start+end)/2;
		if(qEnd<=mid)return query(qStart,qEnd,start,mid,index*2);
		if(qStart>mid)return query(qStart,qEnd,mid+1,end,index*2+1);
		return query(qStart,mid,start,mid,index*2)+query(mid+1,qEnd,mid+1,end,index*2+1);
	}
	
	
	private void update(int uStart,int uEnd,long value,int start,int end,int index){
		
		if(uStart==start&&uEnd==end){
			a[index].value+=(end-start+1)*value;
			a[index].mark+=value;
			return;
		}
		
		putDown(index);
		int mid=(start+end)/2;
		if(uEnd<=mid){
			update(uStart,uEnd,value,start,mid,index*2);
			return;
		}
		if(uStart>mid){
			update(uStart,uEnd,value,mid+1,end,index*2+1);
			return;
		}
		update(uStart,mid,value,start,mid,index*2);
		update(mid+1,uEnd,value,mid+1,end,index*2+1);
		a[index].value=a[index*2].value+a[index*2+1].value;
	}
	
	private void putDown(int index){
		if(a[index].mark>0){
			a[index*2].mark+=a[index].mark;
			a[index*2].value+=(a[index*2].end-a[index*2].start+1)*a[index].mark;
			a[index*2+1].mark+=a[index].mark;
			a[index*2+1].value+=(a[index*2+1].end-a[index*2+1].start+1)*a[index].mark;
			a[index].mark=0;
		}
	}
	
	
	
}

class Shu{
	private Scanner input=new Scanner(new BufferedInputStream(System.in));
	private int n,q;
	private String []color;
	private int []a;
	public void solve(){
		while(input.hasNext()){
			n=input.nextInt();
			q=input.nextInt();
			init();
			while(q-->0){
				int index=input.nextInt();
				String tc=input.nextLine();
				add(index,tc);
				System.out.println(query(n));
			}
		}
	}
	
	private void init(){
		color=new String[n+1];
		a=new int [n+1];
		Arrays.fill(a, 0);
		Arrays.fill(color, "0 0 0");
		int i=1;
		while(i<=n){
			a[i]+=1;
			i+=i&-i;
		}
	}
	
	private void add(int i,String col){
		while(i<=n){
			int count=0;
			if(!col.equals(color[i]))count=1;
			else count=-1;
			a[i]+=count;
			color[i]=col;
			i+=i&-i;
		}
	}
	
	private int query(int i){
		int ans=0;
		while(i>0){
			ans+=a[i];
			i-=i&-i;
		}
		return ans;
	}
}


class Shu2{
	private Scanner input=new Scanner(new BufferedInputStream(System.in));
	private int n,q;
	
	public void solve(){
		HashMap<Integer,String>index=new HashMap<Integer,String>();
		HashMap<String,Integer>colors=new HashMap<String,Integer>();
		while(input.hasNext()){
			n=input.nextInt();
			q=input.nextInt();
			index.clear();
			colors.clear();
			colors.put(" 0 0 0", n);
			int ans=1;
			while(q-->0){
				int tn=input.nextInt();
				String co=input.nextLine();
				if(!index.containsKey(tn)){
					if(!colors.containsKey(co)){
						ans++;
						colors.put(co, 1);
					}
				}
				else {
					if(!colors.containsKey(co)){
						colors.put(co,1);
						ans++;
					}
					else {
						int value=colors.get(co);
						value--;
						if(value==0){
							ans--;
							colors.remove(co);
						}
						else colors.put(co, value);
					}
				}
				index.put(tn,co);
				System.out.println(ans);
			}
		}
	}
}



class BIT{
	private Scanner input=new Scanner(new BufferedInputStream(System.in));
	private final int max=100000+1;
	private int n,q;
	private long []bit0=new long[max];
	private long []bit1=new long[max];
	
	public void solve(){
		while(input.hasNext()){
			Arrays.fill(bit0, 0);
			Arrays.fill(bit1, 0);
			n=input.nextInt();
			q=input.nextInt();
			for(int i=1;i<=n;i++){
				add(bit0,i,input.nextInt());
			}
			
			while(q-->0){
				String op=input.next();
				if(op.equals("C")){
					int a=input.nextInt();
					int b=input.nextInt();
					int v=input.nextInt();
					add(bit0,a,-v*(a-1));
					add(bit1,a,v);
					add(bit0,b+1,v*b);
					add(bit1,b+1,-v);
				}
				else{
					int a=input.nextInt();
					int b=input.nextInt();
					long ans=0;
					ans+=sum(bit0,b)+sum(bit1,b)*b;
					ans-=sum(bit0,a-1)+sum(bit1,a-1)*(a-1);
					System.out.println(ans);
				}
			}
		}
	}
	
	private void add(long[]b,int i,int v){
		while(i<=n){
			b[i]+=v;
			i+=i&-i;
		}
	}
	
	private long sum(long[]b,int i){
		long ans=0;
		while(i>0){
			ans+=b[i];
			i-=i&-i;
		}
		return ans;
	}
}


class MPS{
	private int n;
	private int[]a=new int [100];
	Scanner input=new Scanner(new BufferedInputStream(System.in));
	
	public void solve(){
		while(input.hasNext()){
			n=input.nextInt();
			int ans=0;
			Arrays.fill(a, 0);
			for(int i=0;i<n;i++){
				int t=input.nextInt();
				ans+=i-sum(t);
				add(t,1);
			}
			System.out.println(ans);
		}
	}
	
	private int sum(int i){
		int ans=0;
		while(i>0){
			ans+=a[i];
			i-=i&-i;
		}
		return ans;
	}
	
	private void add(int i,int v){
		while(i<=n){
			a[i]+=v;
			i+=i&-i;
		}
	}
}


class MS{
	private int []all;
	private int []a;
	private int max;
	private Scanner input=new Scanner(new BufferedInputStream(System.in));
	
	public void solve(){
		int t=input.nextInt();
		int n,m;
		while(t-->0){
			n=input.nextInt();
			a=new int[n+1];
			for(int i=1;i<=n;i++)a[i]=input.nextInt();
			max=(int)Math.pow(2,(int)Math.ceil(Math.log(n)/Math.log(2))+1);
			all=new int[max];
			build(1,n,1);
			m=input.nextInt();
			while(m-->0){
				int left=input.nextInt();
				int right=input.nextInt();
				System.out.println(query(left,right,1,1,n));
				
			}
		}
	}
	
	private int gcd(int a,int b){
		if(b==0)return a;
		else return gcd(b,a%b);
	}
	
	private int query(int left,int right,int start,int l,int r){
		int mid=(l+r)/2;
		if(left==l&&right==r)return all[start];
		if(right<=mid)return query(left,right,start*2,l,mid);
		if(left>mid)return query(left,right,start*2+1,mid+1,r);
		return gcd(query(left,mid,start*2,l,mid), query(mid+1,right,start*2+1,mid+1,r));
		
	}
	
	private void build(int left,int right,int index){
		int mid=(left+right)/2;
		if(left==right){
			all[index]=a[left];
			return;
		}
		build(left,mid,index*2);
		build(mid+1,right,index*2+1);
		all[index]=gcd(all[index*2], all[index*2+1]);
	}
}


class CF19A{
	private Scanner input=new Scanner(System.in);
	public void solve(){
		int n;
		while(input.hasNext()){
			n=input.nextInt();
			input.nextLine();
			String s=input.next();
			int []a=new int[n+1];
			for(int i=0;i<n;i++){
				a[i]=input.nextInt();
			}
			int t=1000000000;
			int ans=t;
			for(int i=0;i<s.length()-1;i++){
				if(s.charAt(i)=='R'&&s.charAt(i+1)=='L'){
					ans=Math.min(ans,(a[i+1]-a[i])/2);
				}
			}
			if(ans!=t)System.out.println(ans);
			else System.out.println(-1);
			
			
		}
	}
}


class CF19B{
	private Scanner input=new Scanner(new BufferedInputStream(System.in));
	private String []mp;
	private int [][]a;
	private int n,m;
	public void solve(){
	
		while(input.hasNext()){
			n=input.nextInt();
			m=input.nextInt();
			input.nextLine();
			mp=new String[n];
			a=new int[n+1][m+1];
			for(int i=0;i<n;i++)mp[i]=input.nextLine();
			for(int i=0;i<n;i++){
				int count=0;
				int j=0;
				for(j=0;j<m;j++){
					if(mp[i].charAt(j)=='*'){
						count++;
						a[i][j]++;
					}
					a[i+1][j]=a[i][j];
				}
				if(j==m)a[i][m]=count;
			}
			int to=0;
			for(int i=0;i<n;i++){
				to+=a[i][m];
			}
			boolean ans=false;
			int i=0,j=0;
			for(i=0;i<n;i++){
				for(j=0;j<m;j++){
					if(mp[i].charAt(j)=='*'){
						int tt=a[i][m]+a[n][j]-1;
						if(tt==to){
							ans=true;
							break;
						}
					}
					else {
						int tt=a[i][m]+a[n][j];
						if(tt==to){
							ans=true;
							break;
						}
					}
				}
				if(ans)break;
			}
			if(ans){
				System.out.println("YES");
				System.out.println((i+1)+" "+(j+1));
			}
			else System.out.println("NO");
			
		}
	}
	
	
}














