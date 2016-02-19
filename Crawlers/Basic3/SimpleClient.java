package Basic3;
import java.io.*;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

public class SimpleClient {
	
public static void main(String[] args) throws IOException {
	HttpClient client = new HttpClient(); 
     // 设置代理服务器地址和端口      
     //client.getHostConfiguration().setProxy("proxy_host_addr",proxy_port); 
     // 使用 GET 方法 ，如果服务器需要通过 HTTPS 连接，那只需要将下面 URL 中的 http 换成 https 
     HttpMethod method=new GetMethod("http://www.baidu.com");
     //使用POST方法
     //HttpMethod method = new PostMethod("http://java.sun.com");
     client.executeMethod(method);

      //打印服务器返回的状态
     System.out.println(method.getStatusLine());
      //打印返回的信息
     System.out.println(method.getResponseBodyAsString());
      //释放连接
      method.releaseConnection();
   }


public static String doUploadFile(String postUrl) throws IOException {
    String response = "";
    PostMethod postMethod = new PostMethod(postUrl);
    try {
        HttpClient client = new HttpClient();
        client.getHttpConnectionManager().getParams()
                .setConnectionTimeout(50000);// 设置连接时间
        int status = client.executeMethod(postMethod);
        if (status == HttpStatus.SC_OK) {
            InputStream inputStream = postMethod.getResponseBodyAsStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    inputStream));
            StringBuffer stringBuffer = new StringBuffer();
            String str = "";
            while ((str = br.readLine()) != null) {
                stringBuffer.append(str);
            }
            response = stringBuffer.toString();
        } else {
            response = "fail";
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // 释放连接
        postMethod.releaseConnection();
    }
    return response;
}



}
