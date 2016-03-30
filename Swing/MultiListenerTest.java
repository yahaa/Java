import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MultiListenerTest implements MouseMotionListener,MouseListener{
	private JFrame f=new JFrame("多重监听器");
	private TextField tf=new TextField(30);
	public MultiListenerTest(){
		Label l=new Label("请按下鼠标");
		f.add(l,"North");
		f.add(tf,"South");
		f.setBackground(new Color(180,225,225));
		f.addMouseMotionListener(this);
		f.addMouseListener(this);
		f.setSize(300, 200);
		f.setVisible(true);
		
	}
	
	public static void main(String []args){
		try{
			MultiListenerTest t=new MultiListenerTest();
		}
		catch (Exception ex){
			System.out.println(ex);
		}
		
	}
	
	public void mouseDragged(MouseEvent e){
		String s="鼠标拖动到的位置（"+e.getX()+" ,"+e.getY()+")";
		tf.setText(s);
	}
	
	public void mouseEntered(MouseEvent e){
		tf.setText("鼠标进入窗体");
	}
	
	public void mouseExited(MouseEvent e){
		tf.setText("鼠标移除窗体");
	}
	
	public void mouseMoved(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
	public void mouseClicked(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}

}
