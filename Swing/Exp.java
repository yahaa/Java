
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;
import org.jb2011.lnf.beautyeye.ch8_toolbar.BEToolBarUI;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.BorderUIResource;

public class Exp {
  private JFrame f = null;
  private JTextField username = new JTextField(10);
  private JPasswordField password = new JPasswordField(10);
  private JLabel user = null;
  private JLabel pwd = null;
  private JButton login = null;
  private JButton reset = null;
  private JCheckBox bas = null;
  private JCheckBox foot = null;
  private JMenuBar menuBar = null;

  public Exp(){
	  
    try {
      BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencyAppleLike;
      org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      f = new JFrame("Swing��¼����");
      menuBar = createMenus();
      f.setJMenuBar(menuBar);
      user = new JLabel("�û�����");
      pwd = new JLabel("��  �룺");
      bas = new JCheckBox("����");
      foot = new JCheckBox("����");
      login = new JButton("��¼");
      reset = new JButton("����");
      login.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.green));
      login.setForeground(Color.white);
      reset.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.lightBlue));
      reset.setForeground(Color.white);
      login.addMouseListener(new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
          if(null == username.getText() || "".equals(username.getText())) {
            JOptionPane.showMessageDialog(null, "�û�������Ϊ��");
            return;
          }
          if(null == password.getText() || "".equals(password.getText())) {
            JOptionPane.showMessageDialog(null, "���벻��Ϊ��");
            return;
          }
          if(null != username.getText() && "wbb".equals(username.getText()) && null != password.getText() && "123".equals(password.getText())) {
            JOptionPane.showMessageDialog(null, "��¼�ɹ�����ӭ����" + username.getText());
          } else {
            JOptionPane.showMessageDialog(null, "�û��������������������");
          }
        }
        @Override
        public void mousePressed(MouseEvent e) { }
        @Override
        public void mouseReleased(MouseEvent e) { }
        @Override
        public void mouseEntered(MouseEvent e) { }
        @Override
        public void mouseExited(MouseEvent e) { }
      });
      reset.addMouseListener(new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
          username.setText("");
          password.setText("");
        }
        @Override
        public void mousePressed(MouseEvent e) { }
        @Override
        public void mouseReleased(MouseEvent e) { }
        @Override
        public void mouseEntered(MouseEvent e) { }
        @Override
        public void mouseExited(MouseEvent e) { }
      });
    } catch (Exception e) {
      e.printStackTrace();
    }

    //����
    JPanel p = new JPanel();
    //��ť
    JPanel bt = new JPanel();

    //��������
    p.setLayout(new GridLayout(3, 2));
    bt.setLayout(new GridLayout(1, 2));

    p.add(user);
    p.add(username);
    p.add(pwd);
    p.add(password);
    p.add(bas);
    p.add(foot);

    bt.add(login);
    bt.add(reset);

    f.add(p, BorderLayout.NORTH);
    f.add(bt, BorderLayout.SOUTH);
//		���ô��屳��ȫ͸������ȫ����һ������ı�����
//		f.setUndecorated(true);
//		AWTUtilities.setWindowOpaque(f, false);
//		f.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
    f.setVisible(true);
    f.setBounds(800, 300, 400, 400);
    f.pack();
  }

  public JMenuBar createMenus() {
    JMenuItem mi;
    // ***** create the menubar ****
    JMenuBar menuBar = new JMenuBar();
    menuBar.getAccessibleContext().setAccessibleName("������");

    // ***** create File menu
    JMenu fileMenu = (JMenu) menuBar.add(new JMenu("�ļ�"));
    createMenuItem(fileMenu, "�½�", "FileMenu.about_mnemonic", "�½��ļ�",null);
    createMenuItem(fileMenu, "����", "FileMenu.about_mnemonic", "�����ļ�",null);
    createMenuItem(fileMenu, "ɾ��", "FileMenu.about_mnemonic", "ɾ���ļ�",null);
    createMenuItem(fileMenu, "���Ϊ...", "FileMenu.about_mnemonic", "���Ϊ...",null);
    fileMenu.addSeparator();
    JMenu editMenu = (JMenu) menuBar.add(new JMenu("�༭"));
    createMenuItem(editMenu, "�����С", "FileMenu.about_mnemonic", "�����С",null);
    createMenuItem(editMenu, "��ɫ", "FileMenu.about_mnemonic", "��ɫ",null);
    createMenuItem(editMenu, "��ʽ", "FileMenu.about_mnemonic", "��ʽ",null);
    fileMenu.addSeparator();
    editMenu.addSeparator();
    return menuBar;
  }

  public JMenuItem createMenuItem(JMenu menu, String label, String mnemonic,
                  String accessibleDescription, Action action) {
    JMenuItem mi = (JMenuItem) menu.add(new JMenuItem(label));

//		mi.setBorder(BorderFactory.createEmptyBorder());
    mi.setMnemonic(mnemonic.charAt(0));
    mi.getAccessibleContext().setAccessibleDescription(accessibleDescription);
    mi.addActionListener(action);
    if(action == null) {
      mi.setEnabled(false);
    }
    return mi;
  }

  public static void main(String[] args) {
    //�������ð�ť
    UIManager.put("RootPane.setupButtonVisible",false);
//		//����border��ɫ
//		Border bd = new BEToolBarUI.ToolBarBorder(
//				UIManager.getColor(Color.green),//Floatableʱ�������ɫ
//				UIManager.getColor(Color.yellow),//Floatableʱ�������Ӱ��ɫ
//				new Insets(6,0,11,0)					//border��Ĭ��insets
//		);
//		UIManager.put("ToolBar.border",new BorderUIResource(bd));
    new Exp();
  }
}