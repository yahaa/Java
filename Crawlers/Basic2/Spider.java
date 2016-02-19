package Basic2;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.*;
public class Spider {
	//获取网站的代码
	static String getWebCode(String url){
		String result=null;
		BufferedReader in=null;
		try{
			URL readerURL=new URL(url);
			URLConnection con=readerURL.openConnection();
			con.connect();
			in=new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
			String str=null;
			while((str=in.readLine())!=null){
				result+=str;
			}
		}
		catch(Exception e){
			System.out.println("请求GET失败");
			e.printStackTrace();
		}
		finally{
			try{
				if(in!=null)in.close();
			}
			catch (Exception e2){
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	//获取问题的列表
	public static ArrayList<Zhihu>getZhihu(String content){
		ArrayList<Zhihu>result=new ArrayList<Zhihu>();
		
		Pattern urlPattern=Pattern.compile("<h2>.+?question_link.+?href=\"(.+?)\".+?</h2>");
		Matcher urlMatcher=urlPattern.matcher(content);
	
		while(urlMatcher.find()){
			Zhihu zhihutemp=new Zhihu(urlMatcher.group(1));
			result.add(zhihutemp);
		}
		return result;
	}
}
