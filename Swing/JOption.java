import javax.swing.JOptionPane;
public class JOption {
	public static void main(String[]args){
		try{
			String s=JOptionPane.showInputDialog("Enter number of apples :");
			int c=Integer.parseInt(s);
			String outs=JOptionPane.showInputDialog("Enter you number :");
			int c1=Integer.parseInt(outs);
			JOptionPane.showMessageDialog(null, "sum="+c+c1);
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		
	}

}
