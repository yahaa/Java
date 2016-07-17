package com.server;

import java.nio.charset.Charset;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.Channel;


public class NServer {
	private Selector selector=null;
	private final int PORT=30000;
	private Charset charset=Charset.forName("UTF-8");
	private ServerSocketChannel ssc=null;
	
	
	public void init()throws IOException{
		System.out.println("�����������ɹ�");
		//selector ����
		selector=Selector.open();
		// ssc ����
		ssc=ServerSocketChannel.open();
		InetSocketAddress address=new InetSocketAddress(PORT);
		ssc.bind(address);
		ssc.configureBlocking(false);
		ssc.register(selector,SelectionKey.OP_ACCEPT);
		checkOpt();
		
	}
	
	private void checkOpt()throws IOException{
		System.out.println("������״̬");
		while(selector.select()>0){
			for(SelectionKey key:selector.selectedKeys()){
				selector.selectedKeys().remove(key);
				//������������
				if(key.isAcceptable()){
					SocketChannel sc=ssc.accept();
					//sc ����
					sc.configureBlocking(false);
					sc.register(selector,SelectionKey.OP_READ);
					key.interestOps(SelectionKey.OP_ACCEPT);
				}
				
				//�����ȡ��������
				if(key.isReadable()){
					SocketChannel sc=(SocketChannel)key.channel();
					ByteBuffer buff=ByteBuffer.allocate(1024);
					String word="";
					try{
						while(sc.read(buff)>0){
							buff.flip();
							word+=charset.decode(buff);
						}
						System.out.println(word);
						key.interestOps(SelectionKey.OP_READ);
						if(word.length()<=0)key.cancel();
						
					}
					catch(IOException ex){
						key.cancel();
						if(key.channel()!=null)key.channel().close();
						ex.printStackTrace();
					}
					
					//����Ϣ�������е��û�
					if(word.length()>0){
						for(SelectionKey tkey:selector.keys()){
							Channel sendTo=tkey.channel();
							if(sendTo instanceof SocketChannel){
								//System.out.println(word);
								((SocketChannel) sendTo).write(charset.encode(word));
							}
						}
					}
					
				}
			}
		}
	}
	
	
	public static void main(String[]args){
		NServer a=new NServer();
		try{
			a.init();
		}
		catch(IOException ex){
			System.out.println("IO����");
			ex.printStackTrace();
		}
	}
	
}
