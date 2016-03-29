import java.awt.*;
public class CardLayoutTest {
	public static void main(String[]args){
		Frame f=new Frame("CardLayout");
		CardLayout cl=new CardLayout();
		f.setLayout(cl);
		Button []b=new Button[4];
		for(int i=0;i<4;i++){
			b[i]=new Button("ÄãµÄµÚ"+i+"ÒÑËÀ");
			f.add(b[i], "pege"+i);
			b[i].setSize(40,40);
		}
		b[0].setBackground(Color.gray);
		b[1].setBackground(Color.green);
		b[2].setBackground(Color.red);
		b[3].setBackground(Color.pink);
		
		f.setSize(200,200);
		f.setLocation(200, 200);
		f.pack();
		f.setVisible(true);
		while(true){
			try{
				Thread.sleep(100);
			}
			catch(InterruptedException ex){
				ex.printStackTrace();
			}
			cl.next(f);
		}
	}

}
