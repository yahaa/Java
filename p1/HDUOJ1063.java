import java.util.*;
import java.math.*;
public class HDUOJ1063 {
	public static void main(String[]args){
		Scanner input=new Scanner(System.in);
		while(input.hasNext()){
			BigDecimal ans=new BigDecimal(input.next());
			BigDecimal t=ans;
			int n=input.nextInt();
			for(int i=1;i<n;i++)ans=ans.multiply(t);
			String s=ans.stripTrailingZeros().toPlainString();
			if(s.charAt(0)=='0')s=s.substring(1);
			System.out.println(s);
		}
	}
}
