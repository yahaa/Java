import java.util.*;
public class CFB1_17 {
	public static void main(String []args){
		Scanner input=new Scanner(System.in);
		String s="0000000001111111";
		s=s.replaceAll("0000000","*");
		System.out.println(s);
		StringBuilder bb;
		System.out.printf("%d%d",1,1);
		Integer n=10;
		Map<Integer,Integer>mp=new TreeMap<Integer,Integer>();
		
		bb=new StringBuilder(input.nextLine());
		
		Character aaa=new Character('a');
	
		while(input.hasNext()){
			long a=input.nextLong();
			long b=input.nextLong();
			String sa=new String(Long.toBinaryString(a));
			String sb=new String(Long.toBinaryString(b));
			int ans=0;
			int i,j,sa0=0,sb0=0;
			for(i=0;i<sa.length();i++)if(sa.charAt(i)=='0')sa0++;
			for(j=0;j<sb.length();j++)if(sb.charAt(j)=='0')sb0++;
			for(i=0;i<sa.length();i++)if(sa.charAt(i)=='0')break;
			for(j=0;j<sb.length();j++)if(sb.charAt(j)=='0')break;
			
			if(sa.length()==sb.length()){
				ans=j-i;                         // =   sa.length()-i-(sb.length()-j);
				if(sb0==1)ans++;
			}
			else{
				ans+=sa.length()-i;
				ans+=j-1;                       //=   sb.length()-1-(sb.length()-j)
				if(sb0==1)ans++;
				if(sb.length()-sa.length()>=2){
					ans+=(sb.length()-2+sa.length())*(sb.length()-sa.length()-1)/2;
				}
			}
			
			System.out.println(11111);
		System.out.println(ans);
	}

}
	}
