import java.awt.*;
import javax.swing.*;
public class Windows {
	private JFrame jframe=new JFrame();
	private JMenuBar jmb=new JMenuBar();
	private JMenu cd1,cd2,cd3;
	//���캯��
	public Windows(String title){
		jframe.setTitle(title);
		jframe.setSize(new Dimension(300,250));
	}
	
	//��Ӳ˵���
	public void setMbar(){
		cd1=new JMenu("�ļ�");
		cd2=new JMenu("�༭");
		cd3=new JMenu("����");
		jmb.add(cd1);
		jmb.add(cd2);
		jmb.add(cd3);
		jframe.setJMenuBar(jmb);
		jframe.setVisible(true);
	}
	
	public static void main(String[]args){
		Windows windows=new Windows("wodetian");
		windows.setMbar();
	}
}
