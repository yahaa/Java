import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedInputStream;
public class RMQT {
	public static void main(String[]args){
		POJ346 a=new POJ346();
		a.solve();
	}
}

class HDU1754{
	private Scanner input=new Scanner(new BufferedInputStream(System.in));
	private int []data;
	private int[]a;
	private int n,q,max;
	
	public void solve(){
		while(input.hasNext()){
			n=input.nextInt();
			q=input.nextInt();
			init();
			build(1,n,1);
			while(q-->0){
				String op=input.next();
				int a=input.nextInt();
				int b=input.nextInt();
				if(op.equals("Q"))System.out.println(query(a,b,1,1,n));
				else update(a,b,1,1,n);
			}
			
		}
	}
	
	private void init(){
		max=(int)Math.pow(2,(int)Math.ceil(Math.log(n)/Math.log(2))+1);
		data=new int[max];
		a=new int[n+1];
		for(int i=1;i<=n;i++)a[i]=input.nextInt();
	}
	
	private void build(int left,int right,int index){
		int mid=(left+right)/2;
		if(left==right){
			data[index]=a[left];
			return;
		}
		build(left,mid,index*2);
		build(mid+1,right,index*2+1);
		data[index]=Math.max(data[index*2], data[index*2+1]);
	}
	
	private int query(int left,int right,int start,int l,int r){
		int mid=(l+r)/2;
		if(left==l&&right==r)return data[start];
		if(right<=mid)return query(left,right,start*2,l,mid);
		if(left>mid)return query(left,right,start*2+1,mid+1,r);
		return Math.max(query(left,mid,start*2,l,mid), query(mid+1,right,start*2+1,mid+1,r));
		
	}
	
	private void update(int index,int value,int start,int l,int r){
		int mid=(l+r)/2;
		if(l==r){
			if(l==index)data[start]=value;
			return;
		}
		if(index<=mid)update(index,value,start*2,l,mid);
		else update(index,value,start*2+1,mid+1,r);
		data[start]=Math.max(data[start*2], data[start*2+1]);
	}
}


class POJ346{
	private Scanner input=new Scanner(new BufferedInputStream(System.in));
	private final int size=4*100000+10;
	private int n,q;
	private long []data=new long[size];
	private long []datb=new long[size];
	
	public void solve(){
		while(input.hasNext()){
			n=input.nextInt();
			q=input.nextInt();
			init();
			input.nextLine();
			while(q-->0){
				String op=input.next();
				if(op.equals("Q")){
					int a=input.nextInt();
					int b=input.nextInt();
					System.out.println(query(a-1,b,0,0,n));
				}
				else if(op.equals("C")){
					int a=input.nextInt();
					int b=input.nextInt();
					long c=input.nextLong();
					update(a-1,b,c,0,0,n);
				}
			}
		}
	}
	
	private void init(){
		Arrays.fill(data, 0);
		Arrays.fill(datb, 0);
		for(int i=0;i<n;i++){
			update(i,i+1,input.nextLong(),0,0,n);
		}
	}
	
	
	private void update(int a,int b,long value,int index,int l,int r){
		if(a<=l&&r<=b)data[index]+=value;
		else if(l<b&&a<r){
			System.out.println(a+" "+b);
			System.out.println(l+" "+r);
			datb[index]+=(Math.min(b, r)-Math.max(a, l))*value;
			update(a,b,value,index*2+1,l,(l+r)/2);
			update(a,b,value,index*2+2,(l+r)/2,r);
		}
	}
	
	
	private long query(int a,int b,int index,int l,int r){
		if(b<=l||r<=a)return 0;
		else if(a<=l&&r<=b)return data[index]*(r-l)+datb[index];
		else {
			long ans=(Math.min(b, r)-Math.max(a, l))*data[index];
			ans+=query(a,b,index*2+1,l,(l+r)/2);
			ans+=query(a,b,index*2+2,(l+r)/2,r);
			return ans;
		}
	}
}
