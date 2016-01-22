
import java.io.*;
import java.util.*;
public class TestFileClass {
	public static void main(String []args){
		File file=new File("D:\\JavaIDE\\ja\\Test\\src\\p1\\uuuuuuus.txt");
		
		System.out.println("1 "+"dos it exist? "+file.exists());
		System.out.println("2 "+"the file have "+file.length()+"bytes");
		System.out.println("3 "+file.getTotalSpace());
		System.out.println("4 "+file.getParent());
		System.out.println("5 "+file.toString());
		System.out.println("6 "+file.lastModified());
		System.out.println("7 "+file.getAbsolutePath());
		System.out.println("8 "+file.canWrite());
		//System.out.println("9 "+file.delete());
		System.out.println("10 "+file.exists());
		System.out.println("12 "+file.isAbsolute());
		
		try{
			
			try(PrintWriter io=new PrintWriter("D:\\JavaIDE\\ja\\Test\\src\\p1\\uuuuuuus.txt")){
				io.println("jlkasdjlkf");
				io.println("klasjdfljadlsfjlkasjdf");
				io.println("klasjdfljadlsfjlkasjdf");
				io.println("klasjdfljadlsfjlkasjdf");
				io.println("klasjdfljadlsfjlkasjdf");
				io.println("klasjdfljadlsfjlkasjdf");
				io.println("klasjdfljadlsfjlkasjdf");
				io.println("klasjdfljadlsfjlkasjdf");
				io.println("klasjdfljadlsfjlkasjdf");
				io.println("klasjdfljadlsfjlkasjdf");
				io.println("klasjdfljadlsfjlkasjdf");
				io.println("klasjdfljadlsfjlkasjdf");
				io.print(new Date());
				}
			
		}
		catch(FileNotFoundException ex){
			System.out.println("successful2222222"+ex);
			System.out.println("klsjdflkjlsakdfj");
		}
		File file1=new File("D:\\JavaIDE\\ja\\Test\\src\\p1\\test.txt");
		try{
			int sum=0;
			Scanner input=new Scanner(file1);
			input.useDelimiter("ad");
			while(input.hasNext()){
				String s=input.next();
				//sum+=input.nextInt();
				System.out.println(s);
			}
			System.out.println(sum);
		}
		catch(FileNotFoundException ex){
			System.out.println("fals"+ex);
		}
		
		
		
		
		
			
	}

}
