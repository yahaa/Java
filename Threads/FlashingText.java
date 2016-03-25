import javax.swing.*;
public class FlashingText extends JApplet implements Runnable {
	private JLabel jlblText=new JLabel("welcome",JLabel.CENTER);
	public FlashingText(){
		add(jlblText);
		new Thread(this).start();
	}
	
	public void run(){
		try{
			while(true){
				if(jlblText.getText()==null)jlblText.setText("welcome");
				else jlblText.setText(null);
				Thread.sleep(200);
			}
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
	}

}
