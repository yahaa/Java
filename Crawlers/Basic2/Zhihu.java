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
			System.out.println("����ץȡ "+link);
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
		return "���� : "+question+"\n���� : "+description+"\n���� : "+link+"\n�ش� : "+answers.size()+"\n";
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
        result += "���⣺" + question + "\r\n";  
        result += "������" + description + "\r\n";  
        result += "���ӣ�" + link + "\r\n";  
        for (int i = 0; i < answers.size(); i++) {  
            result += "�ش�" + (i+1) + "��" + answers.get(i) + "\r\n";  
        }  
        result += "\r\n\r\n\r\n\r\n";  
        result = result.replaceAll("<br>", "\r\n");  
        result = result.replaceAll("<.*?>", " ");  
        return result;  
}  

}
