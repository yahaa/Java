import javax.swing.*;
public class OptionDialog {
	public static void main(String[]args){
		int i=JOptionPane.showConfirmDialog(null, "�Ƿ���Ҫ��ӡ","��ʾ�� ",JOptionPane.YES_NO_CANCEL_OPTION);
		if(i==JOptionPane.OK_OPTION)System.out.println("ok");
		else System.out.println("no");
	}

}
