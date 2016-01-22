import java.util.*;
import java.math.*;
public class HDUOJ1753_ {
	public static void main(String[]args){
		Scanner input=new Scanner (System.in);
		while(input.hasNext()){
			BigDecimal a=input.nextBigDecimal();
			BigDecimal b=input.nextBigDecimal();
			System.out.println(a.add(b).stripTrailingZeros().toPlainString());
		}
	}

}
