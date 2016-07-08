import java.net.*;
import java.io.*;
public class TestInetAddress {
	public static void main(String[]args){
		try{
			InetAddress add=InetAddress.getByName("www.jingdong.com");
			InetAddress me=InetAddress.getLocalHost();
			System.out.println(add.getHostAddress());
			byte[]ass=add.getAddress();
			if(ass.length==4){
				System.out.println(4);
			}
			else System.out.println(6);
			
			NetworkInterface ni=NetworkInterface.getByName("eth0");
			System.out.println(ni.toString());
		}
		catch (Exception ex){
			System.out.println("Could not find");
		}
	}
}
