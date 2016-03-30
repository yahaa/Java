import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Dimension;
import org.apache.commons.codec.digest.DigestUtils;
public class Hashs extends JApplet {
	private JButton jbt=new JButton("生成");
	private JTextField jtflimit1=new JTextField();
	private JTextField jtfResult1=new JTextField();
	
	
	public Hashs(){
		jtflimit1.setPreferredSize(new Dimension(500, 80));
		jtfResult1.setPreferredSize(new Dimension(500, 80));
		JPanel panel1=new JPanel(new GridLayout(2,1));
		panel1.setBorder(BorderFactory.createTitledBorder("Hash"));
		JPanel panel11=new JPanel();
		panel11.add(new JLabel("输入你的密码"));
		panel11.add(jtflimit1);
		panel11.add(new JLabel("@"));
		panel11.add(jtfResult1);
		JPanel panel12=new JPanel();
		panel12.add(jbt);
		panel1.add(panel11);
		panel1.add(panel12);
		
		setLayout(new GridLayout(1,2));
		add(panel1);
		jbt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new ANS(jtflimit1.getText(),jtfResult1).execute();
			}
		});
	}
	
	
	static class ANS extends SwingWorker<String,Object>{
		private String ins;
		private JTextField result;
		
		public ANS(String ins,JTextField result){
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
			return DigestUtils.md5Hex(ins);
		}
	}
	
}
