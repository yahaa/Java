import java.math.BigInteger;
import java.util.*;
public class HDUOJ1047 {
	public static void main(String[]args){
		Scanner input=new Scanner(System.in);
		int  n=input.nextInt();
		for(int i=0;i<n;i++){
			BigInteger sum=new BigInteger("0");
				while(input.hasNext()){
					String s=input.next();
					BigInteger temp=new BigInteger(s);
					if(s.equals("0"))break;
					sum=sum.add(temp);
				}
				System.out.println(sum);
				if(i!=n-1)System.out.println();
			}
		}			
}
