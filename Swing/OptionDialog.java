import javax.swing.*;
public class OptionDialog {
	public static void main(String[]args){
		int i=JOptionPane.showConfirmDialog(null, "是否需要打印","提示： ",JOptionPane.YES_NO_CANCEL_OPTION);
		if(i==JOptionPane.OK_OPTION)System.out.println("ok");
		else System.out.println("no");
	}

}
