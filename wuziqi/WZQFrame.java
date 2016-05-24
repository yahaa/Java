import java.awt.Color;  
import java.awt.Dimension;  
import java.awt.Graphics;  
import javax.swing.JFrame;  
import javax.swing.JPanel;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;  


public class WZQFrame extends JFrame{
	public Graphics g;
	public static WZQFrame wzq;
	
	public WZQFrame(){
		this.initUI();
	}
	
	private void initUI(){
		this.setTitle("变态五子棋");
		this.setSize(new Dimension(650,650));
		this.setResizable(false);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		
		
		JPanel board=new JPanel(){
			public void paint(Graphics g) {  
                g.setColor(Color.BLACK);  
                super.paint(g);  
                // 画15行  
                for (int i = 0; i <15; i++) {  
                    g.drawLine(20,20+i*WZQConfig.SPAN,20+(WZQConfig.COLUMN-1)*WZQConfig.SPAN,20+i*WZQConfig.SPAN);  
                }  
                // 画15列  
                for (int i = 0; i < 15; i++) {  
                    g.drawLine(20+i*WZQConfig.SPAN,20,20+i*WZQConfig.SPAN,20+(WZQConfig.COLUMN-1)*WZQConfig.SPAN);  
                }  
                g.setColor(Color.black);  
               
                g.fillOval(15+160, 15+160, 10, 10);  
                g.fillOval(15+160, 15+280, 10, 10);  
                g.fillOval(15+160, 15+400, 10, 10);  
                
                g.fillOval(15+280, 15+160, 10, 10);  
                g.fillOval(15+280, 15+280, 10, 10);  
                g.fillOval(15+280, 15+400, 10,10); 
                
                g.fillOval(15+400, 15+160, 10, 10);  
                g.fillOval(15+400, 15+280, 10, 10);
                g.fillOval(15+400, 15+400, 10, 10); 
            }  
        };  
        
        //黄色背景
        board.setBackground(new Color(209, 167, 78));  
        board.setBounds(0, 0, 650, 650);  
        this.add(board);
        this.setVisible(true);  
        g = board.getGraphics();  
	}
	
	public static void main(String[]args){
		 try {
	            BeautyEyeLNFHelper.launchBeautyEyeLNF();
	            //你的代码UIManager.setLookAndFeel(....);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		WZQFrame frame=new WZQFrame();
	}

}
