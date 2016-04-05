import javax.swing.*;
import java.awt.*;
public class JButtonD {
	public static void main(String[]args){
		JFrame f=new JFrame("ffffffffffffffff");
		f.setLayout(null);
		f.setSize(600, 400);
		f.setLocation(200,200);
		//Container c=f.getContentPane();
		
		JButton[]m=new JButton[10];
		for(int i=0;i<8;i++){
			String t="no"+i+"Button";
			m[i]=new JButton(t);
			m[i].setSize(100+i,100+i);
			m[i].setLocation(i*i,i*i);
			f.add(m[i]);
		}
	
		f.setVisible(true);
		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
