import java.util.*;
import java.util.Map.Entry;
import java.math.*;
public class Main{
	private static Scanner input=new Scanner(System.in);
	
	public static void main(String[]args){
		//Main b=new Main();
		//b.proL();
		//System.out.println(GCD(625,10));
		proE a=new proE();
		a.solve();
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


class proE{
	private final int max=10000;
	private int[]kind=new int[max];
	private int[]num=new int[max];
	private final long mod=1000000000+7;
	private Scanner input=new Scanner(System.in);
	private int count=0;
	
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
