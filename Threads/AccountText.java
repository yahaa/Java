//import java.util.concurrent.*;
//import java.util.concurrent.locks.*;
//public class AccountText {
//	//���ݳ�Ա
//	private static Account account=new Account();
//	
//	//��Ա��������
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
//	//�ڲ���   ���ڴ�������
//	private static class AddMoneyTask implements Runnable{
//		public void run(){
//			//synchronized (account){//�ùؼ��֡�synchronized ͬ��������ʽ����
//				account.deposit(1);
//				System.out.println(account.getBalance());
//		//	}
//		}
//	}
//	
//	//�ڲ��ࡡ�����ڴ������ݳ�Ա
//	private static class Account{
//		//���á�Lock ��ʾ����
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
