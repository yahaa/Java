package Basic4;
import java.io.*;
import Basic3.*;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.params.*;
public class DownTool {
	
	
	
	private static String getFileNameByURL(String url,String contentType){
		url=url.substring(7);
		if (contentType.indexOf("html")!=-1){
			  url = url.replaceAll("[\\?/:*|<>\"]", "_") + ".html";
		} 
		else{
			  url = url.replaceAll("[\\?/:*|<>\"]", "_") + "."+ 
			  contentType.substring(contentType.lastIndexOf("/") + 1);
		}
			  return url;
	}
	
	
	private void saveToLocal(byte[] data, String filePath) {
		 try{
			 DataOutputStream out = new DataOutputStream(new FileOutputStream(new File(filePath)));
			 for (int i = 0; i < data.length; i++)
			  	out.write(data[i]);
		  		out.flush();
		  		out.close();
		 } 
		 catch (IOException e){
			 e.printStackTrace();
		 }
	}
	
	
	 public String downloadFile(String url) {
		
		  String filePath = null;
		  // 1.生成 HttpClinet对象并设置参数
		  HttpClient httpClient = new HttpClient();
		  // 设置 HTTP连接超时 5s
		  httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
		  // 2.生成 GetMethod对象并设置参数
		  GetMethod getMethod = new GetMethod(url);
		  // 设置 get请求超时 5s
		  getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 5000);
		  // 设置请求重试处理
		  getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,new DefaultHttpMethodRetryHandler());
		  // 3.执行GET请求
		  try {
		   int statusCode = httpClient.executeMethod(getMethod);
		   // 判断访问的状态码
		   if (statusCode != HttpStatus.SC_OK) {
		    System.err.println("Method failed: "+ getMethod.getStatusLine());
		    filePath = null;
		   }
		   // 4.处理 HTTP 响应内容
		   byte[] responseBody = getMethod.getResponseBody();// 读取为字节数组
		   // 根据网页 url 生成保存时的文件名
		   System.out.println("正在下载 "+SpiderQueue.getVistedURLCounts()+" "+url);
		   filePath ="//home//yahaa//Repository//temp//"+ getFileNameByURL(url,getMethod.getResponseHeader("Content-Type").getValue());
		   saveToLocal(responseBody, filePath);
		   SaveAllToLocal.getAll(filePath);
		  } 
		  catch (HttpException e) {
		   // 发生致命的异常，可能是协议不对或者返回的内容有问题
		   System.out.println("请检查你的http地址是否正确");
		   e.printStackTrace();
		  } 
		  catch (IOException e) {
		   // 发生网络异常
		   e.printStackTrace();
		  } 
		  finally {
		   // 释放连接
		   getMethod.releaseConnection();
		  }
		  return filePath;
	 }
	
	
}
