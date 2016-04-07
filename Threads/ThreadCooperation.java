//import java.math.*;
//import java.util.concurrent.*;
//import java.util.concurrent.locks.*;
//public class ThreadCooperation {
//	private static Account account=new Account();
//	public static void main(String[]args){
//		ExecutorService executor=Executors.newFixedThreadPool(2);
//		executor.execute(new DepositTask());
//		executor.execute(new WithdrawTask());
//		executor.shutdown();
//		System.out.println("Tread 1\t\tThread 2\tBalance");
//	}
//	
//	
//	private static class WithdrawTask implements Runnable{
//		public void run(){
//			int n=5;
//			while(n-->0){
//				account.withdraw((int)(Math.random()*10)+1);
//			}
//		}
//	}
//	
//	private static class DepositTask implements Runnable{
//		public void run(){
//			int n=5;
//			while(n-->0){
//				try{
//					account.deposit((int)(Math.random()*100)+1);
//					Thread.sleep(5000);
//				}
//				catch(InterruptedException ex){
//					ex.printStackTrace();
//				}
//			}
//		}
//	}
//	
//	
//	private static class Account{
//		private static Lock lock=new ReentrantLock();
//		private static Condition newDeposit=lock.newCondition();
//		private int balance=0;
//		
//		public int getBalance(){
//			return balance;
//		}
//		
//		public void withdraw(int amount){
//			lock.lock();
//			try{
//				while(balance<amount){
//					System.out.println("\t\twait for a deposit");
//					newDeposit.await();
//				}
//				balance-=amount;
//				System.out.println("\t\t\tWithdraw "+amount+"\t\t"+getBalance());
//			}
//			catch(InterruptedException ex){
//				ex.printStackTrace();
//			}
//			finally{
//				lock.unlock();
//			}
//		}
//		
//		public void deposit(int amount){
//			lock.lock();
//			try{
//				balance+=amount;
//				System.out.println("Deposit "+amount+"\t\t\t\t\t"+getBalance());
//				newDeposit.signalAll();
//			}
//			finally{
//				lock.unlock();
//			}
//		}
//	}
//
//}
