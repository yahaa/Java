
import java.util.*;
import java.io.*;
public class ReadFileFromURL {
	public static void main(String[]args){
		File file=new File("D:\\JavaIDE\\ja\\Test\\src\\p1\\uuuuuuus.txt");
		try{
			PrintWriter io=new PrintWriter(file);
			System.out.println("Enter a URL");
			String urlString=new Scanner(System.in).next();
			try{
				java.net.URL url=new java.net.URL(urlString);
				int count=0;
				Scanner input=new Scanner(url.openStream());
				while(input.hasNext()){
					String line=input.nextLine();
					io.println(line);
					count+=line.length();
				}
				System.out.println("the file size is "+count+" characters");
			}
			catch(java.net.MalformedURLException ex){
				System.out.println("invalid URL");
			}
			catch (java.io.IOException ex){
				System.out.println("I/O error");
			}
		}
		catch(FileNotFoundException ex){
			System.out.println("file"+file.exists());
		}
		
	}

}
