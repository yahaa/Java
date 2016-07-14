import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileOutputStream;
public class TestChannel {
	public static void main(String[]args){
		writer();
		
	}
	
	public static void read(){
		try{
			FileInputStream fin=new FileInputStream("bdc.html");
			FileChannel fc=fin.getChannel();//��ȡͨ��
			ByteBuffer bf=ByteBuffer.allocate(1024);//����������
			fc.read(bf);//��ͨ���ж����ݵ�������
			bf.flip();
			while(bf.hasRemaining()){
				byte b=bf.get();
				System.out.println((char)b);
			}
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
	}
	
	public static void writer(){
		try{
			FileOutputStream fout=new FileOutputStream("nibb.txt");
			FileChannel fc=fout.getChannel();
			ByteBuffer bf=ByteBuffer.allocate(1024);
			for(int i=0;i<bf.capacity();i++){
				bf.put((byte)(i*3+2));
			}
			bf.flip();
			fc.write(bf);
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
		
		
	}
}
