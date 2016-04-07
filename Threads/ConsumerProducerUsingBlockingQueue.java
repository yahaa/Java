//import java.util.concurrent.*;
//public class ConsumerProducerUsingBlockingQueue {
//	private static ArrayBlockingQueue<Integer>buffer=new ArrayBlockingQueue<Integer>(2);
//	public static void main(String[]args){
//		ExecutorService executor=Executors.newFixedThreadPool(2);
//		executor.execute(new ReadTask());
//		executor.execute(new WriterTask());
//		executor.shutdown();
//		System.out.println("let's start to do something");
//		for(int i=0;i<=10000;i++)System.out.println(i);
//		
//		
//	}
//	//创建一个能完成writer任务的内部类
//	private static class WriterTask implements Runnable{
//		public void run(){
//			try{
//				int i=1;
//				while(true){
//					System.out.println("Procucer writes "+i);
//					buffer.put(i++);
//					Thread.sleep((int)(Math.random()*1000));
//				}
//			}
//			catch(InterruptedException ex){
//				ex.printStackTrace();
//			}
//		}
//	}
//	
//	//创建一个能完成read任务的内部类
//	private static class ReadTask implements Runnable{
//		public void run(){
//			try{
//				while(true){
//					System.out.println("\t\t\tcomsumer "+buffer.take());
//					Thread.sleep((int)(Math.random()*1000));
//				}
//			}
//			catch(InterruptedException ex){
//				ex.printStackTrace();
//			}
//		}
//	}
//
//}
