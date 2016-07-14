import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;

public class Main {
	public static void main(String[]args){
		
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
