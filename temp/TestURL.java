import java.net.*;
import java.util.List;
import java.util.Map;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;

public class TestURL {
	
	public static void main(String[]args){
		BufferedReader input = null;
		//DataOutputStream output=null;
		try{
			URL url=new URL("http://www.zhihu.com");
			HttpURLConnection con=(HttpURLConnection)url.openConnection();
			con.setConnectTimeout(3000);
			con.setRequestMethod("GET");
			con.setRequestProperty("Accept", "application/json, text/plain, */*");
			con.setRequestProperty("Accept-Encoding","gzip, deflate, sdch, br");
			con.setRequestProperty("Accept-Language","zh-CN,zh;q=0.8");
			con.setRequestProperty("Connection","keep-alive");
			con.setRequestProperty("Cookie","q_c1=074b4d8bf9714d6dad1445bb47d2e9fe|1468133117000|1468133117000; _xsrf=03b08f4dd229b83aaf5d208eee70fb18; l_cap_id=\"ZGNjOTQ5ODRmMzNkNGE2M2JiMzU5YTVjN2JiZTUzZWU=|1468133117|43b0a9a9f2fe5f4ef31001008b535d871f4ae0e3\"; cap_id=\"ODg0NWMwZTAyZjlkNGQ5MWI0NDQ1ODc1NzE0ZWUxZGI=|1468133117|9d56ff79f822ec936331668ea7c4fa5b344cc54b\"; d_c0=\"AGCA2A_3NAqPTp1Dg1GLhDqKfNxN1FmjUic=|1468133118\"; _za=1899ea12-fed1-4bd7-bad1-6eb3e610be12; _zap=763fe528-d033-4db4-9d1e-b9142529f321; login=\"YTA2N2UyNDZiMjc0NGE3OWEzYWNlOWJkZmIwNzU1NmY=|1468133138|a8aa444bba51cbc3929ccd77351d7b0231dd0e7d\"; z_c0=Mi4wQUdEQUctYlhJUW9BWUlEWURfYzBDaGNBQUFCaEFsVk5HbnlwVndCNmxzdldBOWZCLTVSUmZpWDdKRm5GbDRtM05n|1468133146|82be0c1ed309217c4869b84d248f18407c710c21; n_c=1; a_t=\"2.0AGDAG-bXIQoXAAAAT4WpVwBgwBvm1yEKAGCA2A_3NAoXAAAAYQJVTRp8qVcAepbL1gPXwfuUUX4l-yRZxZeJtzbjRdpWy3xoxuIQczxKQ7R7soSVaw==\"; __utmt=1; __utma=51854390.1094288372.1468133119.1468133119.1468135505.2; __utmb=51854390.2.10.1468135505; __utmc=51854390; __utmz=51854390.1468133119.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __utmv=51854390.100--|2=registration_date=20160625=1^3=entry_date=20160625=1");
			con.setRequestProperty("Host","www.zhihu.com");
			con.setRequestProperty("Referer","https://www.zhihu.com/");
			con.setRequestProperty("User-Agent","Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.106 Safari/537.36");
			con.setRequestProperty("X-Requested-With","XMLHttpRequest");
			con.setRequestProperty("X-Xsrftoken","03b08f4dd229b83aaf5d208eee70fb18");
			con.connect();
			Map<String,List<String>>map=con.getHeaderFields();
			
			for(String key:map.keySet()){
				System.out.println(key+"---->"+map.get(key));
			}
			
			try{
				input=new BufferedReader(new InputStreamReader(con.getInputStream(),"utf-8"));
				String result=null;
				String line=null;
				while((line=input.readLine())!=null){
					result+="\n"+line;
				}
				System.out.println(result);
			}
			catch(IOException ex){
				ex.printStackTrace();
			}
		}
		catch(Exception ex){
			System.out.println(ex);
			System.out.println("无法连接");
		}
		
	}
}
