import java.io.FileWriter.*;
import java.io.PrintWriter.*;
import java.io.FileInputStream.*;
import java.io.FileOutputStream.*;
import java.io.*;
public class StreamTest {
	public static void main(String[]args){
		try{
			testDataStream();
			System.out.println("ok");
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
		
	}
	
	
	public static void testFileStream(){
		FileInputStream fin=null;
		FileOutputStream fout=null;
		try{
			fin=new FileInputStream("bbb.png");
			fout=new FileOutputStream("tttaa.pen");
			int value;
			int coun=0;
			while((value=fin.read())!=-1){
				coun++;
				fout.write(value);
			}
			System.out.println(coun);
		}
		catch (IOException ex){
			System.out.println("NOT FUND FILE");
		}
		finally{
			try {
				fin.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public static void testDataStream() throws IOException{
		DataInputStream dIn=null;
		try(DataOutputStream dOut=new DataOutputStream(new FileOutputStream("ouuu.dat"));){
			dOut.writeUTF("hahaha");
			dOut.writeLong(123514634);
		}
	}

}
