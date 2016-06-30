import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class GithubRepoPageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    @Override
    public void process(Page page) {
        page.putField("link",page.getHtml().xpath("//title/text()"));
        page.putField("question", page.getHtml().xpath("//h2/a/text()").all());
       
        
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
    	//System.out.println("start");
    	
    	Spider.create(new GithubRepoPageProcessor())
        //��"https://github.com/code4craft"��ʼץ
        .addUrl("http://www.zhihu.com/explore/recommendations")
        .addPipeline(new ConsolePipeline())
        //����5���߳�ץȡ
        .thread(5)
        //��������
        .run();
        //System.out.println("end");
    }
}