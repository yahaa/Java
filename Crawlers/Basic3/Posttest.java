package Basic3;

import org.apache.http.HttpRequest;
import org.apache.http.HttpVersion;
import org.apache.http.message.BasicHttpRequest;

public class Posttest {  
	public static void main(String[]args){
		HttpRequest request=new BasicHttpRequest("GET","/",HttpVersion.HTTP_1_1);
		System.out.println(request.getRequestLine().getMethod());
	}
}  
  