import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.util.List;

public class Main {

	private static Scanner input=new Scanner(System.in);
	public static void main(String []args){
		//test1();
		//test2();
		
		
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









