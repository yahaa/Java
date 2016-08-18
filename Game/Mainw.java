import java.awt.Color;  
import java.awt.Dimension;  
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;  
import javax.swing.JPanel;  

	
public class Mainw{
	public static void main(String[]args){
		QB a=new QB();
	}
}

interface QC{
	
	public static final int ROW=15;
	public static final int COL=15;
	
	public static final int QSize=40;
	
	public static final int X=30;
	public static final int Y=60;
	
	public static final int JG=40;
}

class QB extends JFrame{
	public Graphics g;
	
	public QB(){
		initUI();
	}
	
	public void initUI(){
		this.setTitle("Give me five !");
		this.setSize(new Dimension(650,650));
		this.setResizable(false);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		
		JPanel jp=new JPanel(){
			public void paint(Graphics g){
				 g.setColor(Color.BLACK);
				 super.paint(g);
				 for(int i=0;i<15;i++){
					 int x1=20;
					 int y1=20+QC.JG*i;
					 int x2=20+(QC.COL-1)*QC.JG;
					 int y2=y1;
					 g.drawLine(x1,y1,x2,y2);
					 x1=20+QC.JG*i;
					 x2=x1;
					 y1=20;
					 y2=20+QC.JG*(QC.ROW-1);
					 g.drawLine(x1, y1, x2, y2);
				 }
				 
				 g.fillOval(133, 133, 15, 15);  
	             g.fillOval(293, 133, 15, 15);  
	             g.fillOval(453, 133, 15, 15);  
	             g.fillOval(133, 293, 15, 15);  
	             g.fillOval(293, 293, 15, 15);  
	             g.fillOval(453, 293, 15, 15);  
	             g.fillOval(133, 453, 15, 15);  
	             g.fillOval(293, 453, 15, 15);  
	             g.fillOval(453, 453, 15, 15);
			}
		};
		jp.setBackground(new Color(209, 167, 78));  
        jp.setBounds(10, 10, 602, 602);
		this.add(jp);
		this.setVisible(true);  
	    g = jp.getGraphics();
	    Mouse lis=new Mouse(g);
	    jp.addMouseListener(lis);
	}
	
}

class Mouse extends MouseAdapter{
	Graphics g;
	public Mouse(Graphics g){
		this.g=g;
	}
	public void mouseClicked(MouseEvent e){
		Random rand=new Random();
		 g.fillOval(45*rand.nextInt(10), 45*rand.nextInt(10), 30, 30);  
	}
}




