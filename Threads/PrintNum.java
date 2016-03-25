
public class PrintNum implements Runnable {
	private int number;
	private int times;
	public PrintNum(int number,int times){
		this.number=number;
		this.times=times;
	}
	
	public void run(){
		try{
			for(int i=0;i<times;i++){
				System.out.print(number);
				if(i%10==0)System.out.println();
				Thread.sleep(100);
			}
		}
		catch(InterruptedException ex){
			ex.printStackTrace();
		}
		
	}
}
