import javax.swing.*;
import java.awt.*;
public class Jdialog extends JDialog {
	
	public Jdialog(){
		
		JDialog j=new JDialog(new Jframes(),"zhe",true);
		Container container=getContentPane();
		container.add(new JLabel("����һ���Ի���"));
		setSize(200,200);
		setVisible(true);
	}
	
	public static void main(String[]args){
		new Jdialog();
	}

	
	private class Jframes extends JFrame{
		public Jframes(){
			Container container=getContentPane();//����һ������
			container.setLayout(null);//���岼�ַ�ʽ
			JLabel jl=new JLabel("����һ��JFrame����");
			jl.setHorizontalAlignment(SwingConstants.CENTER);
			container.add(jl);
			setVisible(true);
			setBackground(Color.white);
			setSize(300,300);
			setTitle("Frame ���ⴰ��");
		}
	}

}
