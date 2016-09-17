import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tccc {
	public static void main(String []args) throws InterruptedException{
		Tasks task=new Tasks("yahaa");
		

		//ExecutorService server=Executors.newFixedThreadPool(5);
		ExecutorService se=Executors.newCachedThreadPool();
		for(int i=0;i<10000;i++){
			Integer t=i;
			String s=t.toString()+"haha";
			se.execute(new Tasks(s));
		}
		
	}
}

class Tasks implements Runnable{
	private String s;
	public Tasks(String s){
		this.s=s;
	}
	
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println(s);
		}
	}
}
