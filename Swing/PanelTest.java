import java.awt.*;
public class PanelTest {
	public static void main(String[]args){
		Frame f=new Frame("panel Test");
		Panel pan=new Panel();
		f.setSize(1600,1600);
		f.setBackground(Color.GRAY);
		f.setLayout(null);
		pan.setSize(800,80);
		pan.setBackground(Color.blue);
		f.add(pan);
		pan.setLocation(400,400);
		f.setVisible(true);
	}

}
