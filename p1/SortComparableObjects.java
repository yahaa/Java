
import java.util.*;
import java.math.*;
public class SortComparableObjects {
	public static void main(String[]args){
		String []cities={"beijing","shanghai","guangxi","guangdong"};
		Arrays.sort(cities);
		for(String city:cities){
			System.out.println(city);
		}     
		BigInteger []hugeNumbers={new BigInteger("1234354365236")
				,new BigInteger("23454235")
				,new BigInteger("1934758432")};
		Arrays.sort(hugeNumbers);
		for(BigInteger it:hugeNumbers){
			System.out.println(it);
		}
		
	}

}
