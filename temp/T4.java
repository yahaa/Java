import java.util.*;
import java.math.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;

public class T4 {
	private static Scanner input=new Scanner(System.in);
	public static void main(String []args){
		//test1();
		//test2();
		XXTree a=new XXTree();
		a.solve();
		
		
	}
	
	public static void test1(){
		while(input.hasNext()){
			int a=input.nextInt();
			int b=input.nextInt();
			System.out.println(a+b);
		}
	}
	
	public static void test2(){
		int n,nc;
		while(input.hasNext()){
			n=input.nextInt();
			nc=input.nextInt();
			input.nextLine();
			String s=input.nextLine();
			System.out.println(getAns(s,n));
		}
	}
	
	private static int getAns(String s,int n){
		HashMap<String,Integer>map=new HashMap<String,Integer>();
		for(int i=0;i<=s.length()-n;i++){
			String ts=s.substring(i, i+n);
			if(map.get(ts)==null)map.put(ts, 1);
		}
		return map.size();
	}
	
	public static void test3(){
		while(input.hasNext()){
			String s=input.nextLine();
			s=s.replaceAll("\\B+\\B", " ");
			System.out.println(s);
			String []t=s.split(" +");
			System.out.println(t.length);
		}
	}
	
	
}


class Matrixc{
	private String []mo;
	private String []mp;
	private int n,m,t,p,q;
	private Scanner input=new Scanner(System.in);
	
	public void solve(){
		while(input.hasNext()){
			n=input.nextInt();
			m=input.nextInt();
			t=input.nextInt();
			p=input.nextInt();
			q=input.nextInt();
			input.nextLine();
			if(n==0)break;
			String []mo=new String[n];
			for(int i=0;i<n;i++)mo[i]=input.nextLine();
			int ans=0;
			while(t-->0){
				for(int i=0;i<p;i++)mp[i]=input.nextLine();
				ans+=find(mo,mp);
			}
		}
	}
	
	public int find(String[]mo,String[]mp){
		int ans=0;
		
		return ans;
	}
}

class XTree{
	private int []all;
	private int []a;
	private int max;
	private Scanner input=new Scanner(new BufferedInputStream(System.in));
	
	public void solve(){
		int n,m;
		while(input.hasNext()){
			n=input.nextInt();
			m=input.nextInt();
			a=new int[n+1];
			for(int i=1;i<=n;i++)a[i]=input.nextInt();
			max=(int)Math.pow(2,(int)Math.ceil(Math.log(n)/Math.log(2))+1);
			all=new int[max];
			build(1,n,1);
			while(m-->0){
				String op=input.next();
				int left=input.nextInt();
				int right=input.nextInt();
				if(op.compareTo("Q")==0)System.out.println(query(left,right,1,1,n));
				else update(left,right,1,1,n);
				
			}
		}
	}
	
	
	private int query(int left,int right,int start,int l,int r){
		int mid=(l+r)/2;
		if(left==l&&right==r)return all[start];
		if(right<=mid)return query(left,right,start*2,l,mid);
		if(left>mid)return query(left,right,start*2+1,mid+1,r);
		return Math.max(query(left,mid,start*2,l,mid), query(mid+1,right,start*2+1,mid+1,r));
		
	}
	
	private void update(int index,int value,int start,int l,int r){
		int mid=(l+r)/2;
		if(l==r){
			if(l==index)all[start]=value;
			return;
		}
		if(index<=mid)update(index,value,start*2,l,mid);
		else update(index,value,start*2+1,mid+1,r);
		all[start]=Math.max(all[start*2], all[start*2+1]);
	}
	
	private void build(int left,int right,int index){
		int mid=(left+right)/2;
		if(left==right){
			all[index]=a[left];
			return;
		}
		build(left,mid,index*2);
		build(mid+1,right,index*2+1);
		all[index]=Math.max(all[index*2], all[index*2+1]);
	}
}


class XXTree{
	private int []all=new int[200020];
	private Scanner input=new Scanner(new BufferedInputStream(System.in));
	private PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out));
	
	public void solve(){
		int t=input.nextInt();
		int tt=1;
		while(t-->0){
			int n=input.nextInt();
			build(1,n,1);
			out.printf("Case %d:\n",tt++);
			while(true){
				String op=input.next();
				if(op.compareTo("End")==0)break;
				int a=input.nextInt();
				int b=input.nextInt();
				if(op.compareTo("Query")==0)out.println(query(a,b,1,1,n));
				else if(op.compareTo("Add")==0)update(a,b,1,1,n);
				else if(op.compareTo("Sub")==0)update(a,-b,1,1,n);
			}
		}
	}
	
	private int query(int start,int end,int index,int left,int right){
		if(left==start&&right==end)return all[index];
		int mid=(left+right)/2;
		if(end<=mid)return query(start,end,index*2,left,mid);
		if(start>mid)return query(start,end,index*2+1,mid+1,right);
		return (query(start,mid,index*2,left,mid)+query(mid+1,end,index*2+1,mid+1,right));
	}
	
	private void update(int aim,int value,int index,int left,int right){
		if(left==right){
			if(left==aim)all[index]+=value;
			return;
		}
		int mid=(left+right)/2;
		if(aim<=mid)update(aim,value,index*2,left,mid);
		else update(aim,value,index*2+1,mid+1,right);
		all[index]=all[index*2]+all[index*2+1];
	}
	
	private void build(int left,int right,int index){
		if(left==right){
			all[index]=input.nextInt();
			return ;
		}
		int mid=(left+right)/2;
		build(left,mid,index*2);
		build(mid+1,right,index*2+1);
		all[index]=all[index*2]+all[index*2+1];
	}
}



















