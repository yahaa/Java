import java.awt.*;
public class FlowLayoutTest {
	public static void main(String[]args){
		Frame f=new Frame("FlowLayout");
		Button button1=new Button("no.1");
		Button button2=new Button("no.2");
		Button button3=new Button("no.3");
		f.setLayout(new FlowLayout());
		f.add(button1);
		f.add(button2);
		f.add(button3);
		f.setSize(100,100);
		f.setLocation(250, 250);
		f.setBackground(Color.PINK);
		f.setVisible(true);
	}

}
