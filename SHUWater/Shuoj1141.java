import java.util.*;
import java.math.*;
public class Shuoj1141 {
public static void main(String[]args){
	Scanner input=new Scanner(System.in);
	System.out.println(3^5^4^5^5^6^6^7);
	System.out.println(3^7);
	
	int []a=new int [10];
	for(int i=0;i<10;i++)a[i]=input.nextInt();
	for(int aa:a){
		System.out.print(aa);
	}
	sss(1,3,4,5,6,7,8,9);
	    
	BigInteger aa=new BigInteger("12809348038290834905895869048359034859083495894038590438590348590834905890345");
	BigInteger bb=new BigInteger("111111111111111111111");
	System.out.println(aa.subtract(bb));
	BigDecimal rrrr=new BigDecimal(input.next());
	int aaa;
	double b;
	float c;
	StringBuilder sssss=new StringBuilder("1234234");
	System.out.println();
	
	
	Integer ttt=4;
	Double t1=14.2;
}

public static void sss(int...a){
	for(int i=0;i<a.length;i++){
		System.out.println(a[i]);
	}
	
}
}
