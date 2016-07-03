import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
public class Main  {
	private static Scanner input=new Scanner(System.in);
	public static void main(String[]args){
		//test1();
		//test2();
		//test3();
		//test4();
		//test5();
		//test6();
		//test7();
		//test8();
		//test9();
		//test10();
		//test11();
		//test12();
		//test13();
		//test14();
		//test15();
		//test16();
		//test17();
		//test18();
		//test19();
		//test20();
		//test21();
		//test22();
		//test23();
		//test24();
		
		
		
	}
	
	public static void ccc(TTT a){
		a.setValue(123);
	}
	  
	
	public static void test1(){
		int n=input.nextInt();
		while(n-->0){
			int h1=input.nextInt();
			int m1=input.nextInt();
			int s1=input.nextInt();
			int h2=input.nextInt();
			int m2=input.nextInt();
			int s2=input.nextInt();
			int s=(s1+s2)%60;
			int m=(m1+m2+(s1+s2)/60)%60;
			int h=h1+h2+(m1+m2+(s1+s2)/60)/60;
			System.out.println(h+" "+m+" "+s);
		}
	}
	
	public static void test2(){
		Integer n;
		while(input.hasNext()){
			n=input.nextInt();
			boolean f=true;
			if(n<0)f=false;
			System.out.printf("%11d",n);
			System.out.println("-->"+((f)?(""):("-"))+Integer.toBinaryString(Math.abs(n)));
		}
	}
	
	
	public static void test3(){
		
		double k;
		while(input.hasNext()){
			k=input.nextDouble();
			double ans=0;
			int n=0;
			while(k-ans>=0){
				n+=1;
				ans+=1.0/n;
				
			}
			System.out.println(n);
		}
	}
	
	public static void test4(){
		int max=100000;
		int []a=new int[max];
		Arrays.fill(a, 1);
		for(int i=2;i<max;i++){
			if(a[i]==1){
				for(int j=2*i;j<max;j+=i){
					a[j]=0;
				}
			}
		}
		while(input.hasNext()){
			int n=input.nextInt();
			for(int i=2;i<=n;i++){
				if(a[i]==1)System.out.println(i);
			}
		}
		
	}
	
	public static void test5(){
		while(input.hasNext()){
			String s=input.nextLine();
			for(int i=s.length()-1;i>=0;i--){
				System.out.print(s.charAt(i));
				
			}
			System.out.println();
		}
	}
	
	public static void test6(){
		while(input.hasNext()){
			int n=input.nextInt();	
			int i=0;
			input.nextLine();
			while(input.hasNext()){
				String s=input.nextLine();
				if(n-->0){
					if(i++>0)System.out.println();
					System.out.println(s);
				}
				else {
					String []ss=s.split("\\s+");
					for(String sss:ss){
						if(i++>0)System.out.println();
						System.out.println(sss);
					}
				}
			}
		}
		
	}
	
	public static void test7(){
		TreeSet<Integer>set=new TreeSet<Integer>();
		while(input.hasNext()){
			set.clear();
			int n=input.nextInt();
			for(int i=0;i<n;i++){
				int t=input.nextInt();
				set.add(t);
			}
			Iterator<Integer>its=set.iterator();
			System.out.println(set.size());
			System.out.print(its.next());
			while(its.hasNext()){
				System.out.print(" "+its.next());
			}
		}
		
	}
	
	public static void test8(){
		List<Integer>a=new ArrayList<Integer>();
		while(input.hasNext()){
			int n=input.nextInt();
			a.clear();
			for(int i=0;i<n;i++){
				a.add(input.nextInt());
			}
			Collections.sort(a);
			Iterator<Integer>it=a.iterator();
			System.out.print(it.next());
			while(it.hasNext()){
				System.out.print(" "+it.next());
			}
			System.out.println();
		}
	}
	
	public static void test9(){
		ArrayList<Integer>a=new ArrayList<Integer>();
		while(input.hasNext()){
			a.clear();
			for(int i=0;i<10;i++){
				a.add(input.nextInt());
			}
			Collections.sort(a);
			Collections.reverse(a);
			for(int i=0;i<a.size();i++){
				if(i!=a.size()-1)System.out.print(a.get(i)+" ");
				else System.out.println(a.get(i));
			}
			
		}
	}
	
	public static void test10(){
		while(input.hasNext()){
			String s=input.next();
			s=s.replaceAll("[^A-Za-z]", "");
			System.out.println(s.length());
		}
	}
	
	public static void test11(){
		int max=100;
		BigInteger []a=new BigInteger[max];
		a[0]=BigInteger.valueOf(1);
		a[1]=BigInteger.valueOf(1);
		for(int i=2;i<100;i++){
			a[i]=a[i-1].add(a[i-2]);
		}
		while(input.hasNext()){
			int n=input.nextInt();
			for(int i=0;i<n;i++){
				if(i!=n-1)System.out.print(a[i]+" ");
				else System.out.println(a[i]);
			}
		}
	}
	
	public static void test12(){
		ArrayList<Integer>a=new ArrayList<Integer>();
		int t;
		while((t=input.nextInt())!=-1){
			a.add(t);
		}
		System.out.println(Collections.max(a));
	}
	
	public static void test13(){
		while(input.hasNext()){
			long ans=0;
			int n=input.nextInt();
			for(int i=1;i<=n;i++)ans+=fan(i);
			System.out.println(ans);
		}
	}
	
	public static long fan(int n){	
		long ans=1;
		for(int i=1;i<=n;i++){
			ans*=i;
		}
		return ans;
	}
	
	
	public static void test14(){
		while(input.hasNext()){
			int a=input.nextInt();
			int n=input.nextInt();
			long ans=0;
			for(int i=1;i<=n;i++){
				ans+=jaa(a,i);
			}
			System.out.println(ans);
		}
	}
	
	public static long jaa(int a,int n){
		long ans=0;
		for(int i=1;i<=n;i++){
			ans=ans*10+a;
		}
		return ans;
	}
	
	
	
	public static void test15(){
		double x1,y1,x2,y2;
		while(input.hasNext()){
			x1=input.nextDouble();
			y1=input.nextDouble();
			x2=input.nextDouble();
			y2=input.nextDouble();
			double ans=Math.sqrt(Math.pow(Math.abs(x2-x1),2)+Math.pow(Math.abs(y2-y1), 2));
			System.out.printf("%.2f\n", ans);
		}
	}
	
	public static void test16(){
		double r;
		while(input.hasNext()){
			r=input.nextDouble();
			System.out.printf("%.3f\n",4.0/3*Math.pow(r, 3)*Math.PI);
		}
	}
	
	public static void test17(){
		String s;
		while(input.hasNext()){
			s=input.next();
			boolean ans=true;
			for(int i=0,j=s.length()-1;i<j;i++,j--){
				if(s.charAt(i)!=s.charAt(j)){
					ans=false;
					break;
				}
			}
			if(ans)System.out.println("Y");
			else System.out.println("N");
		}
	}
	
	public static void test18(){
		int n=input.nextInt();
		
		while(n-->0){
			Integer s=input.nextInt();
			int ans=changes(s);
			System.out.println(ans);
		}
	}
	
	public static int changes(Integer s){
		int step=1;
		while(step<=8){
			s=s+revInt(s);
			if(isabba(s))break;
			step++;
		}
		if(step<=8)return step;
		else return 0;
	}
	
	public static boolean isabba(Integer n){
		String s=n.toString();
		boolean ans=true;
		for(int i=0,j=s.length()-1;i<j;i++,j--){
			if(s.charAt(i)!=s.charAt(j)){
				ans=false;
				break;
			}
		}
		return ans;
	}
	
	public static Integer revInt(Integer s){
		String ss=s.toString();
		int ans=0;
		for(int i=ss.length()-1;i>=0;i--){
			ans=ans*10+(int)(ss.charAt(i)-'0');
		}
		return ans;
	}
	
	public static void test19(){
		String s;
		while(input.hasNext()){
			s=input.next();
			System.out.println(s.toUpperCase());
		}
	}
	
	
	
	public static void test20(){
		TreeMap<Integer,Integer>a=new TreeMap<Integer,Integer>();
		while(input.hasNext()){
			a.clear();
			int n=input.nextInt();
			input.nextLine();
			String s=input.next();
			for(int i=0;i<s.length();i++){
				if(a.get((int)s.charAt(i))!=null){
					int value=a.get((int)s.charAt(i)).intValue();
					value++;
					a.put((int) s.charAt(i), value);
				}
				else {
					a.put((int)s.charAt(i),1);
				}
			}
			Set<Map.Entry<Integer,Integer>>it=a.entrySet();
			long t1=1;
			for(Map.Entry<Integer, Integer>xx:it){
				t1*=fan(xx.getValue());
			}
			System.out.println(fan(n)/t1);
		
		}
	}
	
	public static void test21(){
		while(input.hasNext()){
			long ans1=0;
			long ans2=0;
			int n=input.nextInt();
			int m=input.nextInt();
			for(int i=n;i<=m;i++){
				if(i%2==0){
					ans1+=i*i;
				}
				else ans2+=i*i*i;
			}
			System.out.println(ans1+" "+ans2);
		}
	}
	
	public static void test22(){
		while(input.hasNext()){
			int n=input.nextInt();
			int s=input.nextInt();
			int []a=new int[n];
			for(int i=0;i<n;i++){
				a[i]=input.nextInt();
			}
			Arrays.sort(a);
			//System.out.println(Arrays.binarySearch(a, 5));
			boolean ans=false;
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if(i!=j){
						int t=s-a[i]-a[j];
						int tindex=Arrays.binarySearch(a, t);
						if(tindex>0&&tindex!=i&&tindex!=j){
							ans=true;
							break;
						}
					}
				}
				if(ans)break;
			}
			if(ans)System.out.println("YES");
			else System.out.println("NO");
		}
	}
	
	public static void test23(){
		int n=input.nextInt();
		int []a;
		while(n-->0){
			int t=input.nextInt();
			a=new int[t];
			for(int i=0;i<t;i++){
				a[i]=input.nextInt();
			}
			boolean ans=false;
			for(int j=0;j<t;j++){
				for(int i=t-1;i>=1;i--){
					if(a[i]>a[i-1]){
						if(a[i]-a[i-1]<2)continue;
						else {
							a[i-1]++;
							a[i]--;
							int tt=a[i];
							a[i]=a[i-1];
							a[i-1]=tt;
							
						}
					}
				}
				if(isOrderr(a)){
					ans=true;
					break;
				}
			}
			
			if(ans){
				for(int i=0;i<t;i++){
					if(i!=t-1)System.out.print(a[i]+" ");
					else System.out.println(a[i]);
				}
			}
			else System.out.println("Impossible");
		}
		
	}
	
	public static boolean isOrderr(int []a){
		for(int i=0;i<a.length-1;i++){
			if(a[i]<a[i+1])return false;
		}
		return true;
	}
	
	public static void test24(){
		while(input.hasNext()){
			String a=input.next();
			int n;
			for(n=1;n<10000;n++){
				int t=(int)(Math.log((double)n)*(double)n/Math.log(10.0));
				if(t==a.length()-1)break;
			}
			Long ans=Long.valueOf(1);
			for(int i=1;i<=n;i++){
				ans*=n;
				ans%=10000000;
			}
			String end=ans.toString();
			if(a.subSequence(a.length()-end.length(), a.length()).equals(end))System.out.println(n);
			else System.out.println("NO");
			HashSet<Integer>aa=new HashSet<Integer>();
			LinkedList<Integer>aaa=new LinkedList<Integer>();
			PriorityQueue<Integer>aaaa=new PriorityQueue<Integer>();
			Vector<Integer>aaaaa=new Vector<Integer>();	
			Stack<Integer>ab=new Stack<Integer>();
			Character ta=new Character('j');
		}
	}
	
	

}


