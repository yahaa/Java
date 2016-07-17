package com.client;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.charset.Charset;
import java.nio.channels.SocketChannel;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedInputStream;


public class NClient {
	private Selector selector=null;
	private final int POST=30000;
	private Charset charset=Charset.forName("UTF-8");
	private SocketChannel sc=null;
	private Scanner input=new Scanner(new BufferedInputStream(System.in));
	private String name;
	
	public NClient(){
		Random rand=new Random();
		name="yahaa"+rand.nextInt()+" :";
	}
	
	
	public void init(){
		try{
			selector=Selector.open();
			InetSocketAddress address=new InetSocketAddress(POST);
			sc=SocketChannel.open(address);
			sc.configureBlocking(false);
			sc.register(selector, SelectionKey.OP_READ);
			System.out.println("�ɹ����ӵ�������.......");
			Thread a=new Thread(new Client());
			a.start();
			while(input.hasNextLine()){
				String word=input.nextLine();
				System.out.println(word.length());
				sc.write(charset.encode(name+word));
			}
		}
		catch(IOException ex){
			ex.printStackTrace();
			System.out.println("�޷����ӵ�������.......");
		}
		
		
		
	}
	
	private class Client implements Runnable {
		public void run(){
			try{
				while(selector.select()>0){
					for(SelectionKey key:selector.selectedKeys()){
						selector.selectedKeys().remove(key);
						if(key.isReadable()){
							SocketChannel tsc=(SocketChannel)key.channel();
							ByteBuffer buff=ByteBuffer.allocate(1024);
							String receiveWord="";
							while(tsc.read(buff)>0){
								buff.flip();
								receiveWord+=charset.decode(buff);
							}
							receiveWord=receiveWord.replaceAll("null", "");
							System.out.println(receiveWord);
							key.interestOps(SelectionKey.OP_READ);
						}
					}
				}
			}
			catch(IOException ex){
				System.out.println("������Ϣ����.......");
			}
			
		}
		
	}
	
	public static void main(String[]args){
		NClient a=new NClient();
		a.init();
	}
	
}
