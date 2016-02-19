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
     // ���ô����������ַ�Ͷ˿�      
     //client.getHostConfiguration().setProxy("proxy_host_addr",proxy_port); 
     // ʹ�� GET ���� �������������Ҫͨ�� HTTPS ���ӣ���ֻ��Ҫ������ URL �е� http ���� https 
     HttpMethod method=new GetMethod("http://www.baidu.com");
     //ʹ��POST����
     //HttpMethod method = new PostMethod("http://java.sun.com");
     client.executeMethod(method);

      //��ӡ���������ص�״̬
     System.out.println(method.getStatusLine());
      //��ӡ���ص���Ϣ
     System.out.println(method.getResponseBodyAsString());
      //�ͷ�����
      method.releaseConnection();
   }


public static String doUploadFile(String postUrl) throws IOException {
    String response = "";
    PostMethod postMethod = new PostMethod(postUrl);
    try {
        HttpClient client = new HttpClient();
        client.getHttpConnectionManager().getParams()
                .setConnectionTimeout(50000);// ��������ʱ��
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
        // �ͷ�����
        postMethod.releaseConnection();
    }
    return response;
}



}
