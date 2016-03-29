import java.awt.*;
import java.awt.event.*;
public class MultiListenerTest implements MouseMotionListener,MouseListener{
	private Frame f=new Frame("���ؼ�����");
	private TextField tf=new TextField(30);
	public MultiListenerTest(){
		Label l=new Label("�밴�����");
		f.add(l,"North");
		f.add(tf,"Soith");
		f.setBackground(new Color(180,225,225));
		f.addMouseMotionListener(this);
		f.addMouseListener(this);
		f.setSize(300, 200);
		f.setVisible(true);
	}
	
	public static void main(String []args){
		MultiListenerTest t=new MultiListenerTest();
	}
	
	public void mouseDragged(MouseEvent e){
		String s="����϶�����λ�ã�"+e.getX()+" ,"+e.getY()+")";
		tf.setText(s);
	}
	
	public void mouseEntered(MouseEvent e){
		tf.setText("�����봰��");
	}
	
	public void mouseExited(MouseEvent e){
		tf.setText("����Ƴ�����");
	}
	
	public void mouseMoved(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
	public void mouseClicked(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}

}
