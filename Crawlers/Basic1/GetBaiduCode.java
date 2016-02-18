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
	
	//��ȡ��վ����
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
			System.out.println("���������쳣!");
		}
		finally{
			try{
				if(input!=null)input.close();
			}
			catch(Exception e){
				System.out.println("���ܹر�");
			}
		}
		return result;
	}
	
	//����վ�������ҵ��ٶ�logo ����ַ
	public static void getLogoAddress(String result,String regex,List<String>list){
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(result);
		while(matcher.find()){
			list.add(matcher.group(1));
		}
		
	}
	
	
	

}
