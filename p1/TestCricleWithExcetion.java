
public class TestCricleWithExcetion {
public static void main(String[]args){
	try{
		
		 CircleWithException cricle1=new  CircleWithException(4.5);
		 CircleWithException cricle2=new CircleWithException(5);
		
		 
	}
	
	catch(IllegalArgumentException ex){
		System.out.println(ex);
	}
	finally {
		 System.out.println("youuuuu");
	 }
	System.out.println("numbr of the objects created: "+CircleWithException.getNumberOfObjects());
	
	
}
}
