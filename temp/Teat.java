import java.math.BigInteger;
import java.util.*;
public class Teat {

	public static void main(String[] args) {
		ArrayList<String>a=new ArrayList<String>();
		Object[]ta=a.toArray();
		a.add("asdf");
		a.add("jalskdj");
		String ts="asjdjfkj      faklsdjfa";
		
		ts=ts.replaceAll("[ ]+"," ");
		String []ass=ts.split(" ");
		int []ab=new int[10];
		BigInteger ae=new BigInteger("1234567");
		BigInteger bg=BigInteger.valueOf(0);
		System.out.println(ass.length);
		System.out.println(ass[0]);
		TreeMap<Character,Integer>mp=new TreeMap<Character,Integer>();
		
		
		Iterator<String>it=a.iterator();
		
		while(it.hasNext()){
			String tt=it.next();
			System.out.println(tt);
		}

	}

}
