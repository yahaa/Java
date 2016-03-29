import java.awt.*;
import java.awt.event.*;
public class ActionEvenTest {
	public static void main(String[]args){
		Frame f=new Frame("Test");
		Button b1=new Button("Begin");
		Button b2=new Button("End");
		Monitor bh=new Monitor();
		b1.addActionListener(bh);
		b2.addActionListener(bh);
		//b2.setActionCommand("over");
		f.add(b1, "North");
		f.add(b2,"Center");
		f.pack();
		f.setVisible(true);
	}
	
	
	private static class Monitor implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.println(e.getActionCommand());
		}
	}

}
