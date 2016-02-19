package Basic4;
import Basic3.*;
import java.util.Set;
import Basic2.FileReaderWriter;
import java.util.*;
public class BfsSpider {
	// main �������
	 public static void main(String[] args) {
		 System.out.println("��ʼ����");
		 BfsSpider crawler = new BfsSpider();
		 String []seeds=new String[]{"https://www.zhihu.com/"};
		 crawler.crawling(seeds);
		 System.out.println("��������");
		
	 }
 /**
  * ʹ�����ӳ�ʼ��URL����
  */
	 private void initCrawlerWithSeeds(String[] seeds) {
		
		 for (int i = 0; i < seeds.length; i++)
			 SpiderQueue.addUVistedURL(seeds[i]);
	 }
	 
	 
 // �������������ȡ�� http://www.xxxx.com��ͷ������
	 public void crawling(String[] seeds){
		 
		
		 LinkFilter filter = new LinkFilter(){
			 public boolean accept(String url){
				 if (url.startsWith("https://www.zhihu.com/"))return true;
				 else return false;
			 }
		 };
 
 
  // ��ʼ�� URL ����
		 initCrawlerWithSeeds(seeds);
		
		
  // ѭ����������ץȡ�����Ӳ�����ץȡ����ҳ������ 1000
		 while (SpiderQueue.isEmptyUVistedURL()&& SpiderQueue.getVistedURLCounts() <= 1000){
   // ��ͷ URL ������
			String visitUrl = (String) SpiderQueue.uVistedURLPop();
			
		 	if (visitUrl == null)continue;
		 	DownTool downLoader = new DownTool();
   // ������ҳ
		 	downLoader.downloadFile(visitUrl);
   // �� URL �����ѷ��ʵ� URL ��
		 	SpiderQueue.addVistedURL(visitUrl);
   // ��ȡ��������ҳ�е� URL
		 	Set<String> links = HtmlParserTool.extracLinks(visitUrl, filter);
   // �µ�δ���ʵ� URL ���
		 	for (String link : links) {
		 		SpiderQueue.addUVistedURL(link);
		 	}
		}
	}
 
}
