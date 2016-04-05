import java.awt.*;
import javax.swing.*;

import javafx.scene.layout.Border;
import java.util.*;
import java.math.*;
public class SHU extends JFrame{
	//Ìí¼ÓSHU ËÑË÷¿ò
	private JPanel p=new JPanel();
	private JTextArea area=new JTextArea(3,15);
	private JLabel label=new JLabel("SHU");
	private ImageIcon image=new ImageIcon("//home//yahaa//Repository//test.jpg");
	private JLabel laimage=new JLabel(image);
	public SHU(){
		label.setSize(new Dimension(5,3));
		label.setForeground(Color.red);
		area.setBackground(Color.gray);
		p.setLayout(new FlowLayout());
		p.add(area);
		p.add(label);
		add(p);
		this.getLayeredPane().add(laimage,new Integer(Integer.MIN_VALUE) );
		//laimage.setBounds(0,0,image.getIconWidth(), im.getIconHeight());
		this.setVisible(true);
		this.setSize(200, 200);
		this.setLocation(200,200);
		this.pack();
	}
	
	public static void main(String[]args){
		new SHU();
	}

}
