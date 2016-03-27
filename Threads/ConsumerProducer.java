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
	//����һ�������writer������ڲ���
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
	
	//����һ�������read������ڲ���
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
	
	//����һ���ڲ���˽����
	private static class Buffer{
		//�ڲ�������ݳ�Ա
		private static final int CAPACITY=1;
		private static Lock lock=new ReentrantLock();
		private static Condition notEmpty=lock.newCondition();
		private static Condition notFull=lock.newCondition();
		private static Queue<Integer>queue=new LinkedList<Integer>();
		
		//�ڲ���ĳ�Ա������writer
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
		//�ڲ���ĳ�Ա��������read
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
