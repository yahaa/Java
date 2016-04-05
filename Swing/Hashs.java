import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
//import java.beans.PropertyChangeEvent;
import java.awt.Dimension;
import org.apache.commons.codec.digest.DigestUtils;
public class Hashs extends JApplet {
	private JButton jbt=new JButton("生成");
	private JTextArea jtflimit1=new JTextArea();
	private JTextArea jtfResult1=new JTextArea();
	private Font x = new Font("Serif",0,25);
	private JProgressBar pro=new JProgressBar();
	
	
	public Hashs(){
		pro.setStringPainted(true);
		pro.setValue(0);
		pro.setMaximum(100);
		
		jtflimit1.setWrapStyleWord(true);
		jtflimit1.setLineWrap(true);
		
		//panel.add(scroll);
		jtflimit1.setPreferredSize(new Dimension(8, 5));
		jtfResult1.setPreferredSize(new Dimension(8, 5));
		jtflimit1.setFont(x);
		jtfResult1.setFont(x);
		jtflimit1.setForeground(Color.red);
		jtfResult1.setForeground(Color.green);
		jtflimit1.setBorder(new LineBorder(Color.red));
		jtfResult1.setBorder(new LineBorder(Color.black));
		
	
		
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
		gro1.add(jtflimit1,BorderLayout.CENTER);
		
		
		JPanel gro2=new JPanel();
		gro2.setLayout(new BorderLayout());
		gro2.add(paneljieguo,BorderLayout.SOUTH);
		gro2.add(jtfResult1,BorderLayout.CENTER);
		
		
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
		
		jbt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ANS task=new ANS(jtflimit1.getText(),jtfResult1);
				task.execute();
//				task.addPropertyChangeListener(new PropertyChangeListener(){
//					public void propertyChange(PropertyChangeEvent e){
//						if("progress".equals(e.getPropertyName())){
//							pro.setValue((Integer)e.getNewValue());
//						}
//					}
//				});
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
		
//		protected void process(java.util.List<Integer> list){
//			
//		}
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
