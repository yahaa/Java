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
			Elements links = doc.select("a");//���ҵ�һ��aԪ��
			
			//System.out.println(doc);
			

			//System.out.println(doc.body().text()); // "An example link"//ȡ���ַ����е��ı�
			for (Element link:links){
				//System.out.println(link.attr("href")); // "http://example.com/"//ȡ�����ӵ�ַ
				//System.out.println(link.text()); // "example""//ȡ�����ӵ�ַ�е��ı�

				//System.out.println(link.outerHtml()); 
				    // "<a href="http://example.com"><b>example</b></a>"
				//System.out.println(link.html()); // "<b>example</b>"//ȡ�������ڵ�html����
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
