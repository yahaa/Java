import java.awt.*;
import javax.swing.*;
public class Windows {
	private JFrame jframe=new JFrame();
	private JMenuBar jmb=new JMenuBar();
	private JMenu cd1,cd2,cd3;
	//构造函数
	public Windows(String title){
		jframe.setTitle(title);
		jframe.setSize(new Dimension(300,250));
	}
	
	//添加菜单条
	public void setMbar(){
		cd1=new JMenu("文件");
		cd2=new JMenu("编辑");
		cd3=new JMenu("帮助");
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
