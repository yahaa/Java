import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import net.sf.json.JSONObject;

import java.io.*;
public class jsoup1 {
	public static void main(String[]args){
		
//		test1();
//		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxx");
//		test2();
//		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxx");
//		test3();
//		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
//		test4();
//		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
//		//test5();
//		test6();
//		System.out.println("end");
//		System.out.println("77777777777777777777777777777777777");
		//test7();
		//test8();
		//test9();
		//test10();
		test11();
	}
	
	//����һ��html �ĵ�
	public static void test1(){
		String html="asjdklfjkljasdfjklasd"
				+"<p>woshihaoxuesheng</p>"
				+"<a herf=\"wwww.baidu.com\">baidu</a>";
		Document doc=Jsoup.parse(html);
		System.out.println(doc);
	}
	//����һ��bodyƬ��
	public static void test2(){
		String html="<div><p>woshihaoren</p>";
		Document doc=Jsoup.parseBodyFragment(html);
		Element body=doc.body();
		System.out.println(body.text());

	}
	
	//��һ��url ����һ��Document ����
	public static void test3(){
		try{
//			Document doc=Jsoup.connect("http://www.zhihu.com/").get();
			Document doc=Jsoup.connect("http://www.zhihu.com").data("query","Java")
					.userAgent("Mozilla").cookie("auth", "token").timeout(3000).get();
			String title=doc.title();
			System.out.println(title);
		}
		catch (IOException ex){
			ex.printStackTrace();
		}
	}
	
	//��һ���ļ��м���һ��Document ����
	public static void test4(){
		File file=new File("bdc.html");
		try{
			Document doc=Jsoup.parse(file,"utf-8","http��//www.baidu.com/");
			System.out.println("ooooooo");
		}
		catch (IOException ex){
			ex.printStackTrace();
		}
	}
	
	//ͨ��DOM����һ�� html �ĵ�
	public static void test5(){
		try{
			Document doc=Jsoup.connect("http://www.baidu.com/").get();
			Element content=doc.getElementById("content");
			Elements links=content.getElementsByTag("a");//����
			for(Element link:links){
				System.out.println(link.attr("href"));
			}
		}
		catch (IOException ex){
			ex.printStackTrace();
		}
	}
	
	//ʹ��ѡ�����﷨������Ԫ��
	public static void test6(){
		try{
			//FileWriter out= new FileWriter("zhc.html");
			Document doc=Jsoup.connect("https://www.zhihu.com/").get();
			//out.write(doc.toString());
			Elements links=doc.select("a[href]");
			Elements pictrues=doc.select("img[src$=.jpg]");
			for(Element link:links){
				System.out.println(link.absUrl("href"));
			}
			System.out.println("6666666666666666666666666666");
			for (Element pic:pictrues){
				System.out.println(pic.absUrl("src"));
			}
			System.out.println("77777777777777777777");
			Element masthead = doc.select("div.masthead").first();
			System.out.println(masthead);
		}
		catch (IOException ex){
			ex.printStackTrace();
		}
	}
	
	//��Ԫ�س�ȡ���ԣ��ı���HTML
	public static void test7(){
		FileWriter t77;
		String geturl=null;
		try{
			
			Document doc=Jsoup.connect("http://www.zhihu.com/explore/recommendations").get();
			Elements links=doc.select("div[class=zm-item]");
	
			System.out.println(links.size()+" ������");
			for(Element link:links){
				if(link.select("div[data-aid]").attr("data-aid")=="")continue;
				geturl="http://www.zhihu.com/r/answers/"+link.select("div[data-aid]")
				.attr("data-aid")+"/comments";
				System.out.println("���⣺"+link.select("h2").text());
				System.out.println("��������"+link.select("a[href=#][class=meta-item toggle-comment "
						+ "js-toggleCommentBox]").text());
				System.out.println("��������"+link.select("span[class=count]").text());
				System.out.println("�����ߣ�"+link.select("a[href][class=author-link]").text());
				System.out.println("�ظ����ݣ�"+link.select("div[class=zh-summary summary clearfix]").text());
				System.out.println("���"+link.select("div[data-aid]").attr("data-aid"));
				
				System.out.println("\n");
				
			}
			
		}
		catch (IOException ex){
			ex.printStackTrace();
		}
		finally {
			
		}
	}
	
	//Webclint ����
	public static void test8(){
		FileWriter t8=null;
		WebClient  webClient=new WebClient(BrowserVersion.FIREFOX_3_6);
		webClient.setCssEnabled(false);
		webClient.setJavaScriptEnabled(false);
		try{
			t8=new FileWriter("t8.html");
			HtmlPage page=webClient.getPage("http://www.zhihu.com/");
			t8.write(page.asXml());
			t8.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			webClient.closeAllWindows();
			
		}
		
	}
	
	//����WebClient
	public static void test9(){
		WebClient webClient=new WebClient(BrowserVersion.FIREFOX_3_6);
		webClient.setCssEnabled(false);
		webClient.setJavaScriptEnabled(false);
		try{
			HtmlPage page=webClient.getPage("http://www.baidu.com/");
			System.out.println(page.getTitleText());
			System.out.println(page.asText());
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
	}
	//Ԫ�ؼ��
	public static void test10(){
		WebClient webClient=new WebClient(BrowserVersion.FIREFOX_3_6);
		webClient.setCssEnabled(false);
		webClient.setJavaScriptEnabled(false);
		try{
			HtmlPage page=webClient.getPage("http://www.baidu.com");
			HtmlInput input=(HtmlInput)page.getElementById("kw");
			input.setValueAttribute("Ԭ�ӻ�");
			System.out.println(input.toString());
	        HtmlInput btn = (HtmlInput)page.getHtmlElementById("su");
	        HtmlPage page2 = btn.click();
	        System.out.println(page2.asText());
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
	}
	
	public static void test11(){
		try{
			String body = Jsoup.connect("http://www.zhihu.com/r/posts/751406/comments")
					.ignoreContentType(true).execute().body();
		       
		      System.out.println(body);
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
		


	}
	
}














