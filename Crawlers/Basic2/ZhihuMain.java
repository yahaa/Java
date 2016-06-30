package Basic2;
import java.util.ArrayList;
import java.io.*;
public class ZhihuMain {
	
	public static void start(String surl){
		System.out.println("Start");
		
		String url=surl;
		String content=Spider.getWebCode(url);
		ArrayList<Zhihu>list=Spider.getZhihu(content);
		
		for(Zhihu zhihu:list){
			FileReaderWriter.writeIntoFile(zhihu.writeString(), "q_azhuihu.txt");
		}
	t 
		System.out.println("end");
	}
	
	public static void main(String[]args){
		ZhihuMain.start("http://www.zhihu.com/explore/recommendations");
	}

}
