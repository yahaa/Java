import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class GithubRepoPageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    @Override
    public void process(Page page) {
    	System.out.println(page.getUrl());
//        page.putField("link",page.getHtml().xpath("//title/text()"));
//        page.putField("question", page.getHtml().xpath("//h2/a/text()").all());
//        page.addTargetRequest("http://www.zhihu.com/node/ExploreRecommendListV2");
    	page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
        page.putField("name", page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
        if (page.getResultItems().get("name") == null) {
            //skip this page
            page.setSkip(true);
        }
        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));

        // ����������ҳ�淢�ֺ�����url��ַ��ץȡ
        page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/\\w+/\\w+)").all());
       
       
        
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
    	//System.out.println("start");
    	String url="http://www.zhihu.com/explore/recommendations";
    	Spider.create(new GithubRepoPageProcessor())
        //��"https://github.com/code4craft"��ʼץ
        .addPipeline(new ConsolePipeline())
        //����5���߳�ץȡ
        .thread(5)
        //��������
        .run();
        //System.out.println("end");
    }
}