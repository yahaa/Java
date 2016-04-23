import javax.swing.*;
import java.awt.event.*;
public class TestSourceListener {
	public static void main(String[]args){
		JFrame frame=new JFrame("Test");
		JButton jbt=new JButton("OK");
		frame.add(jbt);
		frame.setSize(200, 200);
		frame.setVisible(true);
		jbt.addActionListener(new M());
	}
	
	
	public static class M implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.println("66666");
		}
	}

}
