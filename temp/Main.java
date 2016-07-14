import java.util.*;
import java.math.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.BufferedInputStream;
public class Main {
	private static Scanner input=new Scanner(System.in);
	public static void main(String []args){
		//test1();
		//test2();
		ProStack a=new ProStack();
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
	
	public void solve(){
		int t=input.nextInt();
		int tt=1;
		while(t-->0){
			int n=input.nextInt();
			build(1,n,1);
			System.out.printf("Case %d:\n",tt++);
			while(true){
				String op=input.next();
				if(op.compareTo("End")==0)break;
				int a=input.nextInt();
				int b=input.nextInt();
				if(op.compareTo("Query")==0)System.out.println(query(a,b,1,1,n));
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


class ProStack{
	private Scanner input=new Scanner(System.in);
	
	public void solve(){
		Stack <Character> sta=new Stack <Character>();
		int n=input.nextInt();
		String s;
		input.nextLine();
		while(n-->0){
			sta.clear();
			s=input.nextLine();
			for(int i=0;i<s.length();i++){
				if(sta.isEmpty()){
					sta.push((Character)s.charAt(i));
				}
				else{
					if((s.charAt(i)==']'&&sta.peek()=='[')||(s.charAt(i)==')'&&sta.peek()=='('))sta.pop();
					else sta.push((Character)s.charAt(i));
				}
			}
			if(sta.isEmpty())System.out.println("Yes");
			else System.out.println("No");
		}
	}
}
















