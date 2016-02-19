package Basic4;
import Basic3.*;
import java.util.Set;
import Basic2.FileReaderWriter;
import java.util.*;
public class BfsSpider {
	// main 方法入口
	 public static void main(String[] args) {
		 System.out.println("开始下载");
		 BfsSpider crawler = new BfsSpider();
		 String []seeds=new String[]{"https://www.zhihu.com/"};
		 crawler.crawling(seeds);
		 System.out.println("结束下载");
		
	 }
 /**
  * 使用种子初始化URL队列
  */
	 private void initCrawlerWithSeeds(String[] seeds) {
		
		 for (int i = 0; i < seeds.length; i++)
			 SpiderQueue.addUVistedURL(seeds[i]);
	 }
	 
	 
 // 定义过滤器，提取以 http://www.xxxx.com开头的链接
	 public void crawling(String[] seeds){
		 
		
		 LinkFilter filter = new LinkFilter(){
			 public boolean accept(String url){
				 if (url.startsWith("https://www.zhihu.com/"))return true;
				 else return false;
			 }
		 };
 
 
  // 初始化 URL 队列
		 initCrawlerWithSeeds(seeds);
		
		
  // 循环条件：待抓取的链接不空且抓取的网页不多于 1000
		 while (SpiderQueue.isEmptyUVistedURL()&& SpiderQueue.getVistedURLCounts() <= 1000){
   // 队头 URL 出队列
			String visitUrl = (String) SpiderQueue.uVistedURLPop();
			
		 	if (visitUrl == null)continue;
		 	DownTool downLoader = new DownTool();
   // 下载网页
		 	downLoader.downloadFile(visitUrl);
   // 该 URL 放入已访问的 URL 中
		 	SpiderQueue.addVistedURL(visitUrl);
   // 提取出下载网页中的 URL
		 	Set<String> links = HtmlParserTool.extracLinks(visitUrl, filter);
   // 新的未访问的 URL 入队
		 	for (String link : links) {
		 		SpiderQueue.addUVistedURL(link);
		 	}
		}
	}
 
}
