package Basic3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class TestJsoup {
	public static void main(String []args){
//		Document doc;
//		try{
//			
//			doc = Jsoup.connect("http://www.baidu.com/").get();
//			Element content=doc.select("a").first();
//			System.out.println(content);
//			
//		}
//		catch(IOException ex){
//			System.out.println(ex);
//		}
//		
		
		
		try{
			Document doc = Jsoup.connect("http://www.baidu.com/").get();
			Elements links = doc.select("a");//查找第一个a元素
			
			//System.out.println(doc);
			

			//System.out.println(doc.body().text()); // "An example link"//取得字符串中的文本
			for (Element link:links){
				//System.out.println(link.attr("href")); // "http://example.com/"//取得链接地址
				//System.out.println(link.text()); // "example""//取得链接地址中的文本

				//System.out.println(link.outerHtml()); 
				    // "<a href="http://example.com"><b>example</b></a>"
				//System.out.println(link.html()); // "<b>example</b>"//取得链接内的html内容
				//System.out.println(link.attr("abs:href"));
				System.out.println(link.absUrl("href"));
				System.out.println();
			}
		}
		catch (IOException ex){
			ex.printStackTrace();
		}
		
		
	}
}
