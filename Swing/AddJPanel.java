import javax.swing.*;
import java.awt.*;
public class AddJPanel {
	public JPanel hehel(){
		JLabel JLabell;
		JPanel Panell=new JPanel();
		JLabell=new JLabel("JPanel面板的应用！",JLabel.CENTER);
		Panell.add(JLabell);
		return Panell;
	}
	
	public static void main(String[]args){
		JFrame frame=new JFrame("我添加的面板");
		AddJPanel yang=new AddJPanel();
		JPanel pp=yang.hehel();
		frame.add(pp,BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,250);
		frame.setVisible(true);
	}

}
