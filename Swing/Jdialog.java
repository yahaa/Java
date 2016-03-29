import javax.swing.*;
import java.awt.*;
public class Jdialog extends JDialog {
	
	public Jdialog(){
		
		JDialog j=new JDialog(new Jframes(),"zhe",true);
		Container container=getContentPane();
		container.add(new JLabel("这是一个对话框"));
		setSize(200,200);
		setVisible(true);
	}
	
	public static void main(String[]args){
		new Jdialog();
	}

	
	private class Jframes extends JFrame{
		public Jframes(){
			Container container=getContentPane();//定义一个容器
			container.setLayout(null);//定义布局方式
			JLabel jl=new JLabel("这是一个JFrame窗体");
			jl.setHorizontalAlignment(SwingConstants.CENTER);
			container.add(jl);
			setVisible(true);
			setBackground(Color.white);
			setSize(300,300);
			setTitle("Frame 主题窗口");
		}
	}

}
