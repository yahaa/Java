package p1;
import java.util.*;
import java.math.*;
public class Quotient {
	public static int quotient(int number1,int number2){
		if(number2==0)throw new ArithmeticException("Divisor cannot be zero");
		return number1/number2;
	}
public static void main(String []args){
	Scanner input=new Scanner(System.in);
	System.out.println("enter two  inteegers  :");
	int number1=input.nextInt();
	int number2=input.nextInt();
	try{
		int result=quotient(number1,number2);
		System.out.println(number1+"/"+number2+"is"+"="+result);
	}
	catch(ArithmeticException ex){
		System.out.println(ex);
	}
	System.out.println("Execution continues......");
	
	
	
	
	boolean continueInput=true;
	do{
		try{
			System.out.println("Enter an integer");
			int number=input.nextInt();
			System.out.println("the number is  "+number);
			continueInput=false;
		}
		catch(InputMismatchException ex){
			System.out.println(ex);
			input.nextLine();   //丢弃当前输入行  然后就可以键入新的一行
		}
	}while(continueInput);
	
	try{
		System.out.println(5/0);
	}
	catch(ArithmeticException ex){
		System.out.println(ex);
	}
	
	try{
		long value=Long.MAX_VALUE+1;
		System.out.println(value);
	}
	catch(Error ex){
		System.out.println(ex);
	}
	
	System.out.println("test the test for excample");
	try {
		System.out.println(sum(new int []{1,3,4,5,6}));
	}
	catch (Exception ex){
		ex.printStackTrace();
		System.out.println("\n1111"+ex.getMessage());
		System.out.println("\n2222"+ex.toString());
		System.out.println("\n3333Trace info Obtained form getStackTrace");
		StackTraceElement[]traceElements=ex.getStackTrace();
		for(int i=0;i<traceElements.length;i++){
			System.out.println("method "+traceElements[i].getMethodName());
			System.out.print("("+traceElements[i].getMethodName()+":");
			System.out.println(traceElements[i].getLineNumber()+")");
			
		}
	}
	
}

private static int sum(int []list){
	int result=0;
	for(int i=0;i<=list.length;i++)result+=list[i];
	return result;
}





}
