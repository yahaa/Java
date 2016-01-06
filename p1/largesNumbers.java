package p1;
import java.util.*;
import java.math.*;
public class largesNumbers {
	public static void main(String [] args){
		ArrayList<Number> list=new ArrayList<>();
		list.add(45);
		list.add(3445.52);
		list.add(new BigInteger("3434343434344343434343"));
		list.add(new BigDecimal("2.3454656564747")); 
		System.out.println("the largest number is " +getLargestNumber(list));
		System.out.println("test test test "); 
		Number x=5;
		System.out.println(x.doubleValue());
		System.out.println(x.intValue());
		System.out.println(new Date());
		
	}
	
	
	
	public static Number getLargestNumber(ArrayList<Number>list){
		if(list==null||list.size()==0)return null;
		Number number=list.get(0);
		for(int i=1;i<list.size();i++){
			if(number.doubleValue()<list.get(i).doubleValue())number=list.get(i);
		}
		return number;
	}
       
	
	
	
	
}
