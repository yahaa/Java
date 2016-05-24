import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
//import java.beans.PropertyChangeEvent;
import java.awt.Dimension;
import org.apache.commons.codec.digest.DigestUtils;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
public class Hashs extends JFrame {
	private JButton jbt=new JButton("生成");
	private JTextArea inArea=new JTextArea();
	private JTextArea outArea=new JTextArea();
	private Font x = new Font("Serif",0,25);
	
	public static void main(String[]args){
		try{
	        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
	    } 
		catch(Exception e){
			e.printStackTrace();
	    }
		Hashs y=new Hashs();
	}
	
	public Hashs(){
		
		this.setSize(500, 400);
		inArea.setWrapStyleWord(true);
		inArea.setLineWrap(true);
		
		//panel.add(scroll);
		inArea.setPreferredSize(new Dimension(8, 5));
		outArea.setPreferredSize(new Dimension(8, 5));
		inArea.setFont(x);
		outArea.setFont(x);
		inArea.setForeground(Color.red);
		outArea.setForeground(Color.green);
		inArea.setBorder(new LineBorder(Color.red));
		outArea.setBorder(new LineBorder(Color.black));
		
	
		
		JPanel panel1=new JPanel(new GridLayout(2,1));
		panel1.setBorder(BorderFactory.createTitledBorder("Hash"));
		
		//设置提示输入
		JPanel paneltishi =new JPanel();
		Font ziti=new Font("Consolad",1,30);
		JLabel shuru=new JLabel("输入你的密码");
		shuru.setFont(ziti);
		paneltishi.add(shuru);
		JPanel paneljieguo=new JPanel();
		JLabel shec=new JLabel("生成的摘要");
		shec.setFont(ziti);
		paneljieguo.add(shec);
		//设置输入框
		
		
		JPanel gro1=new JPanel();
		gro1.setLayout(new BorderLayout());
		gro1.add(paneltishi,BorderLayout.SOUTH);
		gro1.add(inArea,BorderLayout.CENTER);
		
		
		JPanel gro2=new JPanel();
		gro2.setLayout(new BorderLayout());
		gro2.add(paneljieguo,BorderLayout.SOUTH);
		gro2.add(outArea,BorderLayout.CENTER);
		
		
		JPanel panel11=new JPanel();
		panel11.setLayout(new GridLayout(1,2,20,20));
		panel11.add(gro1);
		panel11.add(gro2);
		
		JPanel panel12=new JPanel();
		panel12.add(jbt);
		
		
		panel1.add(panel11);
		panel1.add(panel12);
		setLayout(new GridLayout(1,2));
		add(panel1);
		this.setVisible(true);
		
		jbt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ANS task=new ANS(inArea.getText(),outArea);
				task.execute();
			}
		});
	}
	
	
	static class ANS extends SwingWorker<String,Object>{
		private String ins;
		private JTextArea result;
		
		public ANS(String ins,JTextArea result){
			this.ins=ins;
			this.result=result;
		}
		
		protected String doInBackground(){
			return getANS(ins);
		}
		
		protected void done(){
			try{
				result.setText(get().toString());
			}
			catch(Exception ex){
				result.setText(ex.getMessage());
			}
		}
		
		String getANS(String ins){
			String []total=ins.split("\\n");
			String ans=null;
			for(int i=0;i<total.length;i++){
				ans+=DigestUtils.md5Hex(total[i]);
				ans+="\n";
			}
			ans=ans.replace("null", "");
			return ans;
		}
	}
	
}
