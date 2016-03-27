import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.util.*;
public class ConsumerProducer {
	private static Buffer buffer=new Buffer();
	public static void main(String[]args){
		ExecutorService executor=Executors.newFixedThreadPool(2);
		executor.execute(new ReadTask());
		executor.execute(new WriterTask());
		executor.shutdown();
		System.out.println("let's start to do something");
		for(int i=0;i<=10000;i++)System.out.println(i);
		
		
	}
	//创建一个能完成writer任务的内部类
	private static class WriterTask implements Runnable{
		public void run(){
			try{
				int i=1;
				while(true){
					System.out.println("Procucer writes "+i);
					buffer.writer(i++);
					Thread.sleep((int)(Math.random()*1000));
				}
			}
			catch(InterruptedException ex){
				ex.printStackTrace();
			}
		}
	}
	
	//创建一个能完成read任务的内部类
	private static class ReadTask implements Runnable{
		public void run(){
			try{
				while(true){
					System.out.println("\t\t\tcomsumer "+buffer.read());
					Thread.sleep((int)(Math.random()*1000));
				}
			}
			catch(InterruptedException ex){
				ex.printStackTrace();
			}
		}
	}
	
	//创建一个内部的私有类
	private static class Buffer{
		//内部类的数据成员
		private static final int CAPACITY=1;
		private static Lock lock=new ReentrantLock();
		private static Condition notEmpty=lock.newCondition();
		private static Condition notFull=lock.newCondition();
		private static Queue<Integer>queue=new LinkedList<Integer>();
		
		//内部类的成员函数　writer
		public static void writer(int value){
			lock.lock();
			try{
				while(queue.size()==CAPACITY){
					System.out.println("wait for not empty");
					notFull.await();
				}
				queue.offer(value);
				notEmpty.signal();
			}
			catch(InterruptedException ex){
				ex.printStackTrace();
			}
			finally{
				lock.unlock();
			}
		}
		//内部类的成员函数　　read
		//@SuppressWarnings("finally")
		public static int read(){
			int value=0;
			lock.lock();
			try{
				while(queue.isEmpty()){
					System.out.println("wait for not empty");
					notEmpty.await();
				}
				value=queue.remove();
				notFull.signal();
			}
			catch(InterruptedException ex){
				ex.printStackTrace();
			}
			finally{
				lock.unlock();
				return value;
			}
		}
	}

}
