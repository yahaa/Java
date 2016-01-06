import java.util.*;
public class DisplayTime {
public static void main(String[]args){
	System.out.println("Enter an integer for second: ");
	Scanner input=new Scanner(System.in);
	int seconds=input.nextInt();
	int minutes=seconds/60;
	int remainingSeconds=seconds%60;
	System.out.print(seconds+" seconds is "+minutes+" minutes ans "+
	remainingSeconds+" seconds");
	System.out.print(Math.pow(12, 2));
	
}
}
