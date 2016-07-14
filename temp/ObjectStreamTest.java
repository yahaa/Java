
import java.io.Serializable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;


public class ObjectStreamTest {
	private static ObjectOutputStream out;
	private static ObjectInputStream input;
	public static void main(String[]args){
//		Persion p=new Persion("gouzi",1000);
//		try{
//			out=new ObjectOutputStream(new FileOutputStream("persion1.dat"));
//			out.writeObject(p);
//		}
//		catch(IOException ex){
//			ex.printStackTrace();
//		}
//		finally{
//			try {
//				out.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		Persion tp;
		try{
			input=new ObjectInputStream(new FileInputStream("persion1.dat"));
			tp=(Persion)input.readObject();
			System.out.print(tp.getName());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			try{
				input.close();
			}
			catch(IOException ex){
				ex.printStackTrace();
			}
		}
	}
}


class Persion implements Serializable{
	private String name;
	private int age;
	public Persion(String name,int age){
		this.name=name;
		this.age=age;
	}
	
	public String getName(){
		return name;
	}
	
	public int getAge(){
		return age;
	}
}
