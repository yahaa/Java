package Basic3;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class LoginTest implements PageProcessor {  
    private Site site = new Site().setRetryTimes(3).setSleepTime(100) 
            .setDomain("www.zhihu.com")  
            .addCookie("__utma", "51854390.11994205.1467348024.1467357984.1467358358.4")  
            .addCookie("__utmb", "51854390.16.9.1467362762060")  
            .addCookie("__utmc", "51854390")  
            .addCookie("__utmt", "1")  
            .addCookie("__utmv", "51854390.100--|2=registration_date=20160625=1^3=entry_date=20160625=1")
            .addCookie("__utmz", "51854390.1467355658.2.2.utmcsr=zhihu.com|utmccn=(referral)|utmcmd=referral|utmcct=/explore/recommendations")  
            .addCookie("za", "ea44c5c9-54a5-435b-b3b3-d42fb9fc6276")
            .addCookie("_zap", "9bd9d239-c778-449b-ba49-9bf7a5944ccc")  
            .addCookie("d_c0", "\"AGDAFgKvIQqPTkNU_Wafb2vhCx1ACfrhris=|1466839161\"")
            .addCookie("q_c1", "47072c7325934cf79a4bf1898e0fa699|1467015246000|1467015246000")
            .addCookie("_xsrf","b30dc5adafabe93f17af4368288f466b")
            .addCookie("l_cap_id","\"NjMxYmQxNzE4NWJkNDFhNWJkMTQ3MDQ0MjQzZTQ2OGI=|1467347103|4a0612afaac0c9faf45d51020b13fb4104d11335\"")
            .addCookie("cap_id","\"ZDJmZWFhOWMyZDM4NDRhOWJhMGIwN2ZjZDU1NDM2MzM=|1467347103|fd858fe7c510f1761ce62ebaea959f0da0496cb4\"")
            .addCookie("login","\"NmExYzFjNmFjY2ZlNDczZGI1NjQyYmVjYWNkMjY1MzA=|1467347116|a5d99c6900ec93a1102e145a33bf3f4388613b15\"")
            .addCookie("z_c0","Mi4wQUdEQUctYlhJUW9BWU1BV0FxOGhDaGNBQUFCaEFsVk5ySDJkVndDak5QNWgzNGNpUnJKYmJ5MkpRd3NUOFMwSDZn|1467347116|fd669397f22400c440166aa3bb1aadb3bfdc4848")
            .addCookie("n_c","1")
            .addCookie("a_t", "\"2.0AGDAG-bXIQoXAAAAFn-dVwBgwBvm1yEKAGDAFgKvIQoXAAAAYQJVTax9nVcAozT-Yd-HIkayW28tiUMLE_EtB-p0iph0YY3XgN5rgRUXYMvGYYgWgw==\"")
            .addHeader("User-Agent",  "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.106 Safari/537.36")  
            .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")  
            .addHeader("Accept-Encoding", "gzip, deflate, sdch, br")
            .addHeader("Accept-Language", "zh-CN,zh;q=0.8")  
            .addHeader("Connection", "keep-alive")
            .addHeader("Referer", "https://www.zhihu.com/topic");  
  
    @Override  
    public void process(Page page) {  
        page.putField("question", page.getHtml().xpath("///text()").all().toString());  
    }  
  
    @Override  
    public Site getSite() {  
        return site;  
    } 
    
    
   
        public static void main(String[] args) {  
            Spider.create(new LoginTest())  
                    .addUrl("https://www.zhihu.com/topic").addPipeline(new ConsolePipeline())  
                    .thread(1)  
                    .run();  
        }  
     
    
    
  
}  