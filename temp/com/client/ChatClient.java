package com.client;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class ChatClient {
	//注册用户参数
	private JDialog jd = new JDialog();
	private JPanel buttonsPanel = new JPanel();
	private JLabel jb = new JLabel("请输入昵称：");
	private JTextField username = new JTextField(15);
	private JButton jok = new JButton("确定");
	private JButton jcancl = new JButton("取消");
	
	//聊天界面参数
	private JFrame jf = new JFrame("");
	private JPanel jp = new JPanel();
	private JPanel jp2 = new JPanel();
	private JLabel user = new JLabel();
	private JLabel jlabel = new JLabel("对");
	private JComboBox otherUser = new JComboBox();
	private JLabel jlabel2 =new JLabel("说：");
	private JTextField sendMessage = new JTextField(25);
	private JButton send = new JButton("发送");
	private JLabel jlabel3 = new JLabel("在线用户列表：");
	private Box box = Box.createVerticalBox();
	private JTextArea showMessage = new JTextArea(40,20);
	
	//当前用户参数
	private String workstr;
	private String systemstr;
	private Socket s = null;
	private DataOutputStream dos = null;//发送流
	private DataInputStream dis = null;//接收流
	private boolean bConnected = false;
	
	
	public static void main(String args[]) {
		ChatClient c = new ChatClient();
	}
	
	
	public ChatClient(){
		lunachLogin();
	}
 
	//登陆对话框
	public void lunachLogin(){
		jd.setTitle("输入");
		jd.setResizable(false);
		jd.setLocation(200, 300);
		Container jDialogContentPane = jd.getContentPane();
		jDialogContentPane.add(buttonsPanel, BorderLayout.SOUTH);
		jDialogContentPane.add(jb, BorderLayout.NORTH);
		jDialogContentPane.add(username, BorderLayout.CENTER);
		buttonsPanel.add(jok);
		buttonsPanel.add(jcancl);
		jd.pack();
		jd.setVisible(true);
	
		connect();//点击确定后开始连接
		jok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(username.getText().equals("")){
				}
				else{
					String str = "L" + username.getText().trim();// trim去掉两边空格
					user = new JLabel(username.getText().trim());
					try {
						dos.writeUTF(str);
						dos.flush();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					jd.setVisible(false);
					lunachWork();
				}
			}
		});
  
		jcancl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username.setText("");
			}
		});
	}
	
	
	//登陆后显示界面
	public void lunachWork(){
		jf.setLocation(400, 300);
		jf.setSize(600,300);
		Container jFramecontentPane = jf.getContentPane();
		showMessage.setEditable(false);
		JScrollPane js = new JScrollPane(showMessage);
		jp.add(user);
		jp.add(jlabel);
		jp.add(otherUser);
		jp.add(jlabel2);
		jp.add(sendMessage);
		jp.add(send);
		jp2.setLayout(new BorderLayout());
		jp2.add(jlabel3,BorderLayout.NORTH);
		jp2.add(box,BorderLayout.CENTER);
		jf.add(js,BorderLayout.CENTER);
		jf.add(jp,BorderLayout.SOUTH);
		jf.add(jp2,BorderLayout.EAST);
		jf.setVisible(true);
  
		jf.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				String str = "S" + username.getText().trim();
				try {
					dos.writeUTF(str);
					dos.flush();
   
				} 
				catch (IOException e1) {
					e1.printStackTrace();
				}
				System.exit(0);
				disconnect();
			}
		});
  
		jf.addComponentListener(new ComponentAdapter(){
			public void componentResized(ComponentEvent e) {
				int width = e.getComponent().getWidth();
				int height = e.getComponent().getHeight();
				if (width < 500)width = 500;
				if (height < 200)height = 200;
				jf.setSize(width, height);
			}
		});
	
  
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sendMessage.getText().equals("")){}
				else{
					String str = "W" + username.getText().trim()+" 说 -----> "+sendMessage.getText().trim();
					sendMessage.setText("");
					try {
						dos.writeUTF(str);
						dos.flush();
					} 
					catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		//每一个socket对应一个线程用于接收服务器传回的数据   
		//不用多线程的话数据会被阻塞
  		new Thread(new ReceiveThread()).start();
	}
 
	//连接服务器
	public void connect(){
		try {
			s= new Socket("127.0.0.1",8888);
			dos =new DataOutputStream(s.getOutputStream());
			dis =new DataInputStream(s.getInputStream());
			System.out.println("连接服务器成功！");
			bConnected=true;
		} 
		catch (UnknownHostException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//与服务器断开
	public void disconnect(){
		try {
			dis.close();
			dos.close();
			s.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
 
	class ReceiveThread implements Runnable{
		public void run() {
			try{
				while(bConnected){
					String str = dis.readUTF();
					if(str.charAt(0) == 'W'){
						workstr = str.substring(1);
						showMessage.setText(showMessage.getText()+workstr+'\n');
					}
					else if(str.charAt(0) == 'R'){
						box.removeAll();
						otherUser.removeAllItems();
						jf.setVisible(false);
						workstr = str.substring(1);
						showMessage.setText(showMessage.getText()+workstr+'\n');
					}
					else{ 
						systemstr = str.substring(1);
						JButton jb = new JButton(systemstr);
						box.add(jb);
						otherUser.addItem(systemstr);
						jf.setVisible(true);
					}
				}
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
	
	
}