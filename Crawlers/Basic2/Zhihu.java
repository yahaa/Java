package Basic2;
import java.util.ArrayList;
import java.util.regex.*;
public class Zhihu {
	public String question;
	public String description;
	public String link;
	public ArrayList<String>answers;
	
	
	public Zhihu(String url){
		
		link=null;
		question=null;
		description=null;
		answers=new ArrayList<String>();
		if(getURL(url)){
			System.out.println("正在抓取 "+link);
			String content=Spider.getWebCode(link);
			
			Pattern pattern=Pattern.compile("zh-question-title.+?<h2.+?>(.+?)</h2>");
			Matcher matcher=pattern.matcher(content);
			if(matcher.find())question=matcher.group(1);
			
			pattern = Pattern.compile("zh-question-detail.+?<div.+?>(.*?)</div>");
			matcher = pattern.matcher(content);
			if (matcher.find())description = matcher.group(1);
			
			 pattern = Pattern.compile("/answer/content.+?<div.+?>(.*?)</div>");
			matcher = pattern.matcher(content);
			boolean isFind = matcher.find();
			while (isFind){
				answers.add(matcher.group(1));
				isFind = matcher.find();
				}
		}
	}
	
	public String toString(){
		return "问题 : "+question+"\n描述 : "+description+"\n链接 : "+link+"\n回答 : "+answers.size()+"\n";
	}
	
	boolean getURL(String url){
		Pattern pattern=Pattern.compile("question/(.*?)/");
		Matcher matcher=pattern.matcher(url);
		if(matcher.find()){
			link="http://www.zhihu.com/question/" + matcher.group(1);
		}
		else return false;
		return true;
	}
	
	public String writeString() {  
        String result = "";  
        result += "问题：" + question + "\r\n";  
        result += "描述：" + description + "\r\n";  
        result += "链接：" + link + "\r\n";  
        for (int i = 0; i < answers.size(); i++) {  
            result += "回答" + (i+1) + "：" + answers.get(i) + "\r\n";  
        }  
        result += "\r\n\r\n\r\n\r\n";  
        result = result.replaceAll("<br>", "\r\n");  
        result = result.replaceAll("<.*?>", " ");  
        return result;  
}  

}
