package p1;
import java.math.*;
public class TestCourse { 
	
	public static BigInteger factorial(long n){
		BigInteger result=BigInteger.ONE;
		for(int i=1;i<=n;i++){
			result=result.multiply(new BigInteger(i+""));
		}
		return result;
	}
	
	
public static void main(String []args){
	Course course1=new Course("Data structures",2);
	Course course2=new Course("Math",100);
	course1.addStudents("zhangtao");
	course1.addStudents("laoluo");
	course1.addStudents("zihua");
	course2.addStudents("peter");
	course2.addStudents("javaer");
	System.out.println("the name of course is "+course1.getCourseName());
	System.out.println("the students in the course of Data structures is "+course1.getNumberOfStudent());
	String []students=course1.getStudent();
	System.out.println("-----------------------------------------"); 
	course1.dropStudent("zhangtao");
	course1.dropStudent("zihua");
	course1.dropStudent("laoluo");
	course1.dropStudent("kjdasljf");
	System.out.println("the students in the course of Data structures is "+course1.getNumberOfStudent());
	for(int i=0;i<course1.getNumberOfStudent();i++){
		System.out.print(students[i] +" ");;
	}
	

	System.out.println("-----------------------------------------------");
     Integer i= new Integer(2);
     Integer t=3+new Integer(4);                     //基本数据类型之间能自动进行装箱   与开箱
  
     
     System.out.println(t.intValue());
     System.out.println(i);
     System.out.println(i.intValue());
     System.out.println(i.doubleValue());
     System.out.println(i.equals(4));
     System.out.println();
     int b=Integer.parseInt("349589438");
     System.out.println(b);
BigInteger r=new BigInteger("243789574238975894237589472358974328975984237589437259874328597849327589432758942375892");
BigInteger y=new BigInteger("2");
y=y.multiply(new BigInteger("7970797897"));
System.out.println(r.multiply(y));
System.out.println(r.compareTo(y));
System.out.println(r.doubleValue());
System.out.println(r.subtract(y));
System.out.println(y.subtract(r)); 
System.out.println(r.divide(y));  
BigDecimal g= new BigDecimal("2345234542354325435432543543254325432543254367657435685675467456");
System.out.println(g.divide(g));
System.out.println("-----------------------------------------------");
System.out.println("the ans is "+factorial(8));


System.out.println("-----------------------------------------------");
String bb="alksjdflksad";     //  1
String a=new String(bb);      //  2
String cc=new String("kjds");    //3  
bb="lksdjklf";
System.out.println(bb);
bb=bb.replace('k', 'o');
bb="a b c d e f g h j k l l";
System.out.println(bb);
System.out.println("-----------------------------------------------");
String []tt=new String[100];
tt=bb.split("asd basd #csdaf dasdf #efasdf fasdfa gasdfda hasdfsda jsadf k l l");
for(int j=0;j<tt.length;j++)System.out.println(tt[j]);

}
}
