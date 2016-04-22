//import java.util.concurrent.*;
//import java.util.concurrent.locks.*;
//public class AccountText {
//	//数据成员
//	private static Account account=new Account();
//	
//	//成员函数　　
//	public static void main(String[]args){
//		ExecutorService executor=Executors.newCachedThreadPool();
//		for(int i=0;i<100;i++){
//			executor.execute(new AddMoneyTask());
//		}
//		executor.shutdown();
//		while(!executor.isTerminated()){
//			//System.out.println("what is balance "+account.getBalance());
//		}
//		System.out.println("what is balance "+account.getBalance());
//	}
//	
//	//内部类   用于创建任务
//	private static class AddMoneyTask implements Runnable{
//		public void run(){
//			//synchronized (account){//用关键字　synchronized 同步　　隐式加锁
//				account.deposit(1);
//				System.out.println(account.getBalance());
//		//	}
//		}
//	}
//	
//	//内部类　　用于创建数据成员
//	private static class Account{
//		//调用　Lock 显示加锁
//		private static Lock lock=new ReentrantLock();
//		private int balance=0;
//		public int  getBalance(){
//			return balance;
//		}
//		public void deposit(int amount){
//			lock.lock();
//			try{
//				int newBalance=balance+amount;
//				Thread.sleep(5);
//				balance =newBalance;
//			}
//			catch(InterruptedException ex){
//				ex.printStackTrace();
//			}
//			finally{
//				lock.unlock();
//			}
//			//balance+=amount;
//			
//		}
//	}
//
//}
