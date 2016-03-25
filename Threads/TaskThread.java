import java.util.*;
public class TaskThread {
	public static void main(String[]args){
//		Runnable a=new PrintChar('a',100);
//		Runnable b=new PrintChar('b',100);
//		Runnable c=new PrintNum(12,100);
//		Thread thread1=new Thread(a);
//		Thread thread2=new Thread(b);
//		Thread thread3=new Thread(c);
//		thread1.start();
//		thread2.start();
//		thread3.start();
//		thread3.setPriority(Thread.MAX_PRIORITY);
//		System.out.println(thread1.getPriority());
//		System.out.println(thread2.getPriority());
//		System.out.println(thread3.getPriority());
//		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		FlashingText a=new FlashingText();
		Thread thread4=new Thread(a);
		thread4.start();
		
		
	}

}
