package com.client;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

import java.sql.* ;

public class LoginWin {
  private JFrame f = null;
  private JTextField username = new JTextField(10);
  private JPasswordField password = new JPasswordField(10);
  private JLabel user = null;
  private JLabel pwd = null;
  private JButton login = null;
  private JButton register = null;
  private JLabel blank1 = null;
  private JLabel blank2 = null;
  private JMenuBar menuBar = null;

  public LoginWin(){
    try{
	      BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencyAppleLike;
	      BeautyEyeLNFHelper.launchBeautyEyeLNF();
	
	      f = new JFrame("登录");
	      menuBar = createMenus();
	      f.setJMenuBar(menuBar);
	      user = new JLabel("                        用 名：");
	      pwd = new JLabel("                        密 码：");
	      blank1 = new JLabel("   ");
	      blank2 = new JLabel("   ");
	      login = new JButton("登录");
	      register = new JButton("注册");
	      login.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.green));
	      login.setForeground(Color.white);
	      register.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.lightBlue));
	      register.setForeground(Color.white);
	
	      login.addMouseListener(new MouseAdapter(){
	        @Override
	        public void mouseClicked(MouseEvent e){
	        	String user=username.getText();
	        	String pass=new String(password.getPassword());
	        	
	        	if(exist(user,pass)){
	        		JOptionPane.showMessageDialog(null, "登录成功，欢迎您：" + username.getText());
	        		f.setVisible(false);
	        		new ChatClient();
	        	}
	        	else {
	        		JOptionPane.showMessageDialog(null, "用户名或密码错误，请重新输入或者注册");
	        		return;
	        	}
		 
	        }
	      
	      });
	      
		  register.addMouseListener(new MouseAdapter(){
			  	@Override
		        public void mouseClicked(MouseEvent e){
		        	username.setText("");
		        	password.setText("");
		        }
		  });
		  
    }catch(Exception e){
    	e.printStackTrace();
    }
    
    //用户和密码面板
    JPanel p = new JPanel();
    GridLayout tt=new GridLayout(2, 3,20,10);
    p.setLayout(tt);
    user.setSize(400, 400);
    username.setSize(20, 60);
    p.add(user);
    p.add(username);
    p.add(blank1);
    p.add(pwd);
    p.add(password);
    p.add(blank2);
  //空白面板
    JPanel cent=new JPanel();
    //第三快面板
    JPanel bt = new JPanel();
    bt.setLayout(new GridLayout(1, 2));
    bt.add(login);
    bt.add(register);
    //主窗口界面
    f.add(p,BorderLayout.NORTH);
    f.add(cent);
    f.add(bt,BorderLayout.SOUTH);
    f.setSize(new Dimension(500,600));
    f.setUndecorated(true);
    f.setVisible(true);
    f.setBounds(300, 100, 500, 350);
    
  }
  
  public boolean exist(String user,String pass){
	  String tuser="";
	  String tpass="";
	  try{
          Class.forName("com.mysql.jdbc.Driver") ;
     
          String u ="jdbc:mysql://115.29.146.79:3306/study";
          Connection conn = DriverManager.getConnection(u,"yahaa","Asd147258") ;
          Statement sta=conn.createStatement();
          String sql="select * from charRoomUser where name=\""+user+"\" and "+"pass=\""+pass+"\"";
          ResultSet result=sta.executeQuery(sql);
         while(result.next()){
        	 tuser=result.getString(2);
        	 tpass=result.getString(3);
         }
          conn.close();
      }catch(Exception e){
          System.out.println("failure!!!") ;
      }
	  return user.compareTo(tuser)==0&&pass.compareTo(tpass)==0;
  }

  public JMenuBar createMenus() {
	    JMenuItem mi;
	    JMenuBar menuBar = new JMenuBar();
	    menuBar.getAccessibleContext().setAccessibleName("工具栏");
	
	    JMenu fileMenu = (JMenu) menuBar.add(new JMenu("文件"));
	    createMenuItem(fileMenu, "新建", "FileMenu.about_mnemonic", "新建文件",null);
	    createMenuItem(fileMenu, "保存", "FileMenu.about_mnemonic", "保存文件",null);
	    createMenuItem(fileMenu, "删除", "FileMenu.about_mnemonic", "删除文件",null);
	    createMenuItem(fileMenu, "另存为...", "FileMenu.about_mnemonic", "另存为...",null);
	    fileMenu.addSeparator();
	    JMenu editMenu = (JMenu) menuBar.add(new JMenu("编辑"));
	    createMenuItem(editMenu, "字体大小", "FileMenu.about_mnemonic", "字体大小",null);
	    createMenuItem(editMenu, "颜色", "FileMenu.about_mnemonic", "颜色",null);
	    createMenuItem(editMenu, "格式", "FileMenu.about_mnemonic", "格式",null);
	    fileMenu.addSeparator();
	    editMenu.addSeparator();
	    return menuBar;
  }

  public JMenuItem createMenuItem(JMenu menu, String label, String mnemonic,
                  String accessibleDescription, Action action){
	    JMenuItem mi = (JMenuItem) menu.add(new JMenuItem(label));
	    mi.setMnemonic(mnemonic.charAt(0));
	    mi.getAccessibleContext().setAccessibleDescription(accessibleDescription);
	    mi.addActionListener(action);
	    if(action == null) {
	      mi.setEnabled(false);
	    }
	    return mi;
  }

  public static void main(String[] args){
	  UIManager.put("RootPane.setupButtonVisible",false);
	  new LoginWin();
  }
}


