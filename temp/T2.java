import java.util.*;
import java.util.Map.Entry;
import java.math.*;
public class T2{
	private static Scanner input=new Scanner(System.in);
	
	public static void main(String[]args){	
		TreeMap<Integer,Integer>a=new TreeMap<Integer,Integer>();
//		TreeSet<Character>aa=new TreeSet<Character>();
//		String s="jklasd";
//		
//		ProG a=new ProG();
//		a.solve();
		
		
		
		
		//Main b=new Main();
		//b.proL();
		//System.out.println(GCD(625,10));
//		proE a=new proE();
//		Thread thread=new Thread(a);
//		thread.run();
		
//		BC1 t=new BC1();
//		t.solve();

		
	}
	
	
	public static boolean isNum(String t){
		try{
			Double.parseDouble(t);
			return true;
		}
		catch(NumberFormatException ex){
			throw ex;
		}
		
		
	}
	
	
	public static int GCD(int a,int b){
		if(b==0)return a;
		else return GCD(b,a%b);
	}
	
	
	public void proL(){
		 int x1,y1,x2,y2,x3,y3,x4,y4;
		    while(input.hasNext()){
		    	x2=input.nextInt();
		    	y2=input.nextInt();
		    	x3=input.nextInt();
		    	y3=input.nextInt();
		    	x4=input.nextInt();
		    	y4=input.nextInt();
		    	if(!(x2>0||y2>0||x3>0||y3>0||x4>0||y4>0))break;
		        y1=x3+x4-y2;
		        x1=y3+y4-x2;
		        System.out.printf("Anna's won-loss record is %d-%d.\n",x1,y1);
		    }
	}
	
	
	public void proH(){
		while(input.hasNext()){
			double a=input.nextDouble();
			double b=input.nextDouble();
			double c=input.nextDouble();
			double x1=(-b+Math.sqrt(b*b-4*a*c))/(2*a);
			double x2=(-b-Math.sqrt(b*b-4*a*c))/(2*a);
			
			System.out.printf("%.2f %.2f\n",x1,x2);
			
		}
	}
	
	
	public void proD(){
	        final double g=9.81;
	        while(input.hasNext()){
	            double w,l,s,k;
	            w=input.nextDouble();
	            l=input.nextDouble();
	            s=input.nextDouble();
	            k=input.nextDouble();
	            double x2=(2*w*g+Math.sqrt(4*w*w*g*g+8*k*w*g*l))/(2*k);
	            if(x2+l>=s){
	                 
	                if(l>=s)System.out.println("D");
	                else{
	                    double v=(2*g*s-(k/w)*(s-l)*(s-l));
	                    if(v>100)System.out.println("D");
	                    else System.out.println("Y");
	                }
	                 
	            }
	            else System.out.println("S");
	        }
	        
	}
	
	
	public void proC(){
		
		TreeMap<Integer,Integer>a1=new TreeMap<Integer,Integer>(new Comparator<Integer>(){
				public int compare(Integer a,Integer b){
					return b-a;
				}
		});
		TreeMap<Integer,Integer>a2=new TreeMap<Integer,Integer>(new Comparator<Integer>(){
				public int compare(Integer a,Integer b){
					return b-a;
				}
		});
		TreeMap<Integer,Integer>a3=new TreeMap<Integer,Integer>(new Comparator<Integer>(){
			public int compare(Integer a,Integer b){
				return b-a;
			}
		});
		int to=1;
		int t=1;
		while(input.hasNext()){
			int a=input.nextInt();
			int x=input.nextInt();
			if(x!=-1){
				if(a3.containsKey(x)){
					int value=a3.get(x).intValue();
					value+=a;
					if(value==0)a3.remove(x);
					else a3.put(x, value);
				}
				else a3.put(x, a);
			}
			
			if(to==1){
				if(x==-1)to=2;
				else a1.put(x, a);
			}
			else if(to==2) {
				if(x==-1){
					System.out.println("Case "+t+++":");
					Set<Entry<Integer, Integer>>toSet1=a1.entrySet();
					for(Entry<Integer,Integer>e1:toSet1){
						if(e1.getValue()!=0)System.out.print("("+e1.getValue()+","+e1.getKey()+")");
					}
					System.out.println();
					
					Set<Entry<Integer, Integer>>toSet2=a2.entrySet();
					for(Entry<Integer,Integer>e2:toSet2){
						if(e2.getValue()!=0)System.out.print("("+e2.getValue()+","+e2.getKey()+")");
					}
					System.out.println();
					if(a3.isEmpty())System.out.println(0);
	
					else {
						Set<Entry<Integer, Integer>>toSet3=a3.entrySet();
						for(Entry<Integer,Integer>e3:toSet3){
							if(e3.getValue()!=0)System.out.print("("+e3.getValue()+","+e3.getKey()+")");
						}
						System.out.println();
					}
					to=1;
					a1.clear();
					a2.clear();
					a3.clear();
				}
				else a2.put(x, a);
			}
		}
		
		
	}
	
	
	
	
	public void proB(){
		BigInteger a,b;
		while(input.hasNext()){
			a=input.nextBigInteger();
			b=input.nextBigInteger();
			System.out.println(a+"*"+b+"="+a.multiply(b));
		}
		
	}
	
	
	
	public static boolean nextPermutation(int[] num){  
        if(num.length <= 1)return false; 
        for(int i = num.length - 2; i >= 0; i--){  
            if(num[i] < num[i+1]){  
                int j;  
                for(j = num.length - 1; j >= i; j--)if(num[i] < num[j])break;  
                num[i] = num[i] ^ num[j];  
                num[j] = num[i] ^ num[j];  
                num[i] = num[i] ^ num[j];    
                Arrays.sort(num, i+1, num.length);  
                return true;
            }  
        }  
        for(int i = 0; i < num.length / 2; i++){  
            int tmp = num[i];  
            num[i] = num[num.length - i - 1];  
            num[num.length - i - 1] = tmp;  
        }  
        return false;
    }
	
	

}


class proE implements Runnable{
	private final int max=10000;
	private int[]kind=new int[max];
	private int[]num=new int[max];
	private final long mod=1000000000+7;
	private Scanner input=new Scanner(System.in);
	private int count=0;
	public void run(){
		this.solve();
	}
	
	public void solve(){
		int t=input.nextInt();
		while(t-->0){
			init();
			int n=input.nextInt();
			int m=input.nextInt();
			gcdAll(n);
			long ans=getAns(m);
			System.out.println(ans);
		}
	}
	
	private void gcdAll(int n){
		for(int i=1;i<=(int)Math.sqrt(n);i++){
			if(n%i==0){
				kind[count++]=i;
				kind[count++]=n/i;
				if(n/i==i)count--;
			}
		}
		
		Arrays.sort(kind, 0, count);
		for(int i=count-1;i>=0;i--){
			num[i]=n/kind[i];
			for(int j=count-1;j>i;j--){
				if(kind[j]%kind[i]==0){
					num[i]-=num[j];
				}
			}
		}
		
	}
	
	
	private long getAns(int m){
		long ans=0;
		for(int i=0;i<count;i++){
			ans=(ans+num[i]*modexp(m,kind[i]))%mod;
		}
		ans=ans%mod;
		return ans;
	}
	
	private void init(){
		Arrays.fill(kind, 0);
		Arrays.fill(num,0);
		count=0;
	}
	
	public long modexp(int a,int b){   
	    long ret=1;   
	    long tmp=a;   
	    while(b>0){   
	       if((b&1)>0){
	        ret=(ret*tmp)%mod;
	      }
	       tmp=(tmp*tmp)%mod;
	       b>>=1;
	    }
	    ret=ret%mod;
	    return ret;   
	}
	
	
}


class ProG{
	private Matrix m=new Matrix(5,5);
	private Matrix l0=new Matrix(1,5);
	private Scanner input=new Scanner(System.in);
	private long n;
	private long a0,ax,ay;
	private long b0,bx,by;
	private final long mod=1000000007;


	public void solve(){
		while(input.hasNext()){
			n=input.nextLong();
			inputInit();
			if(n==0){
				System.out.println(0);
				continue;
			}
			m=modExp(m,n-1);
			l0=mul(l0,m);
			System.out.println((l0.a[0][0]));
			
		}
	}
	
	public Matrix modExp(Matrix m,long b){
			Matrix ret=new Matrix(m.getX(),m.getY());
			for(int i=0;i<ret.getX();i++)ret.a[i][i]=1;
		    Matrix tmp=m;
		    while(b>0){   
		       if((b&1)>0){
		        ret=mul(ret,tmp);
		      }
		       tmp=mul(tmp,tmp);
		       b>>=1;
		    }
		    
		    return ret;   
	}
	
	public Matrix mul(Matrix a,Matrix b){
		Matrix temp=new Matrix(a.getX(),b.getY());
		temp.init();
		for(int i=0;i<a.getX();i++){
			for(int j=0;j<b.getY();j++){
				temp.a[i][j]=0;
				for(int k=0;k<a.getY();k++){
					long tt=(a.a[i][k]*b.a[k][j])%mod;
					temp.a[i][j]=(temp.a[i][j]+tt)%mod;
				}
			}
		}
		return temp;
	}
	
	private void inputInit(){
		a0=input.nextLong();
		ax=input.nextLong();
		ay=input.nextLong();
		b0=input.nextLong();
		bx=input.nextLong();
		by=input.nextLong();
		initMa();
		initL0();
	}
	
	private void initMa(){
		m.init();
		m.a[0][0]=1;
		m.a[1][0]=1;
		m.a[1][1]=(ax*bx)%mod;
		m.a[2][1]=(ax*by)%mod;
		m.a[3][1]=(ay*bx)%mod;
		m.a[4][1]=(ay*by)%mod;
		m.a[2][2]=ax%mod;
		m.a[4][2]=ay%mod;
		m.a[3][3]=bx%mod;
		m.a[4][3]=by%mod;
		m.a[4][4]=1;
	}
	
	private void initL0(){
		l0.init();
		long a1=(a0*ax+ay)%mod;
		long b1=(b0*bx+by)%mod;
		long a2=(a1*ax+ay)%mod;
		long b2=(b1*bx+by)%mod;
		l0.a[0][0]=(a1*b1)%mod;
		l0.a[0][1]=(a2*b2)%mod;
		l0.a[0][2]=(a2)%mod;
		l0.a[0][3]=(b2)%mod;
		l0.a[0][4]=1;
	}
	
}


class Matrix{
	public int x,y;
	public long  [][]a;
	
	public Matrix(int x,int y){
		this.x=x;
		this.y=y;
		a=new long[x][y];
	}

	public void init(){
		for(int i=0;i<x;i++)Arrays.fill(a[i], 0);
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
}

class ProM{
	private Matrix m=new Matrix(5,5);
	private Matrix l1=new Matrix(1,5);
	private Scanner input=new Scanner(System.in);
	private long n;
	private long x,y;
	private long mod=10007;
	
	public void solve(){
		int t=input.nextInt();
		while(t-->0){
			n=input.nextLong();
			x=input.nextLong();
			y=input.nextLong();
			initML1();
			m=modExp(m,n-1);
			l1=mul(l1,m);
			System.out.println(l1.a[0][0]);
		}
	}
	
	
	public Matrix modExp(Matrix m,long b){
		Matrix ret=new Matrix(m.getX(),m.getY());
		for(int i=0;i<ret.getX();i++)ret.a[i][i]=1;
	    Matrix tmp=m;
	    while(b>0){   
	       if((b&1)>0){
	        ret=mul(ret,tmp);
	      }
	       tmp=mul(tmp,tmp);
	       b>>=1;
	    }
	    return ret;   
	}

	public Matrix mul(Matrix a,Matrix b){
		Matrix temp=new Matrix(a.getX(),b.getY());
		temp.init();
		for(int i=0;i<a.getX();i++){
			for(int j=0;j<b.getY();j++){
				temp.a[i][j]=0;
				for(int k=0;k<a.getY();k++){
					long tt=(a.a[i][k]*b.a[k][j])%mod;
					temp.a[i][j]=(temp.a[i][j]+tt)%mod;
				}
			}
		}
		return temp;
	}
	
	private void initML1(){
		m.init();
		l1.init();
		
		m.a[0][0]=1;
		m.a[1][0]=1;
		m.a[1][1]=((x%mod)*(x%mod))%mod;
		m.a[2][1]=((y%mod)*(y%mod)+2*(x%mod)*(x%mod)*(y%mod))%mod;
		m.a[4][1]=(2*(x%mod)*(y%mod)*(y%mod))%mod;
		m.a[1][2]=1;
		m.a[2][3]=1;
		m.a[2][4]=x%mod;
		m.a[4][4]=y%mod;
		l1.a[0][0]=1;
		l1.a[0][1]=((x%mod)*(x%mod)+(y%mod)*(y%mod)+2*(x%mod)*(y%mod))%mod;
		l1.a[0][2]=1;
		l1.a[0][3]=1;
		l1.a[0][4]=1;
	}
}

class BC1{
	private Scanner input=new Scanner(System.in);
	
	public void solve(){
		BigInteger a0=BigInteger.valueOf(0);
		int n=input.nextInt();
		while(n-->0){
			
			BigInteger a1=input.nextBigInteger();
			BigInteger a2=input.nextBigInteger();
			BigInteger a3=input.nextBigInteger();
			BigInteger a4=input.nextBigInteger();
			if(a1.compareTo(a0)==0||a2.compareTo(a0)==0||a3.compareTo(a0)==0||a4.compareTo(a0)==0){
				System.out.println("No");
				continue;
			}
			BigInteger sum1=a1.add(a2).add(a3);
			BigInteger sum2=a1.add(a2).add(a4);
			BigInteger sum3=a1.add(a3).add(a4);
			BigInteger sum4=a2.add(a3).add(a4);
			if(sum1.compareTo(a4)<0||sum2.compareTo(a3)<0||sum3.compareTo(a2)<0||sum4.compareTo(a1)<0)System.out.println("No");
			else System.out.println("Yes");
		}
	}
}







