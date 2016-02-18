package Basic2;
import java.util.ArrayList;
import java.io.*;
public class Main {
	
	public static void main(String[]args){
		System.out.println("Start");
		try{
			PrintWriter result=new PrintWriter("zhihu_question_answers.txt");
			String url= "http://www.zhihu.com/explore/recommendations";
			String content=Spider.getWebCode(url);
			ArrayList<Zhihu>list=Spider.getZhihu(content);
			for(Zhihu t:list){
				result.write(t.toString());
			}
			result.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		System.out.println("end");
	}

}
