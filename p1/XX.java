import java.util.*;
public class XX {
public static void main(String []args){
	Date test=new java.util.Date(); 
	for(int i=0;i<10;i++){
	System.out.println("the elpased time since jan 1, 1970 isn "+ test.getTime()+ " milliseconds");
	System.out.println(test.toString());
	}
	Random tt=new Random(5);
	for(int i=0;i<100;i++){
		System.out.println(tt.nextInt(1000));
		System.out.println(tt.nextGaussian());
	
}
}
}
