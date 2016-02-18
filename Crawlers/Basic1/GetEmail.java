package Basic1;
import java.util.regex.*;
import java.util.*;
import java.io.*;
import java.net.*;
public class GetEmail {
	static int count=0;
	
	public static void main(String []args)throws Exception{
		System.out.println("now let's go");
		getMailAddr();
		System.out.println("we can find "+count+ " email address");
		
		//把下载下来的邮件通过屏幕打印出来
		try{
			Scanner input=new Scanner(new File("mailadderess.txt"));
			int t=1;
			while(input.hasNextLine()){
				System.out.println(t+++ " : "+input.nextLine());
			}
		}
		catch(FileNotFoundException e){
			System.out.println(e);
			System.out.println("can't open file");
		}
		
	}
	
	
	public static void getMailAddr()throws Exception{
		URL url=new URL("https://github.com/yahaa/Java/blob/master/email");
		URLConnection con=url.openConnection();
		BufferedReader bufln=new BufferedReader(new InputStreamReader(con.getInputStream()));
		BufferedWriter bufw=new BufferedWriter(new FileWriter("mailadderess.txt"));
		PrintWriter file=new PrintWriter("webFile.txt");//用于保存整个网页的源代码
		String str=null;
		String regex="[A-Za-z0-9_]{3,12}@[A-Za-z0-9]+(\\.[A-Za-z]+)+";
		
		Pattern p=Pattern.compile(regex);
		while((str=bufln.readLine())!=null){
			file.println(str);//写入
			Matcher m=p.matcher(str);
			while(m.find()){
				String ss=m.group();
				bufw.write(ss,0,ss.length());
				count++;
				bufw.newLine();
				bufw.flush();
			}
		}
	}
	

}
