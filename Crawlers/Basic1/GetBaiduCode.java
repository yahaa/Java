package Basic1;
import java.io.*;
import java.util.regex.*;
import java.util.*;
import java.net.*;
public class GetBaiduCode {
	
	public static void main(String[]args){
		String url="http://www.baidu.com";
		String result=getWebsite(url);
		List<String>list=new ArrayList<String>();
		getLogoAddress(result,"src=\"(.+?)\"",list);
		for(String address:list){
			System.out.println(address);
		}
		
		
	}
	
	//获取网站代码
	public static String getWebsite(String url){
		BufferedReader input=null;
		String result=null;
		try{
			URL readurl=new URL(url);
			URLConnection con=readurl.openConnection();
			input=new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			String str=null;
			while((str=input.readLine())!=null){
				result+=str;
			}
		
		}
		catch(Exception e){
			System.out.println("发送请求异常!");
		}
		finally{
			try{
				if(input!=null)input.close();
			}
			catch(Exception e){
				System.out.println("不能关闭");
			}
		}
		return result;
	}
	
	//在网站代码中找到百度logo 的网址
	public static void getLogoAddress(String result,String regex,List<String>list){
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(result);
		while(matcher.find()){
			list.add(matcher.group(1));
		}
		
	}
	
	
	

}
