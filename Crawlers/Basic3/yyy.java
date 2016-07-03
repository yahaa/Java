package Basic3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class yyy {
   
    public static String post(String path,String params) throws Exception{
        HttpURLConnection httpConn=null;
        BufferedReader in=null;
        PrintWriter out=null;
        try {
            URL url=new URL(path);
            httpConn=(HttpURLConnection)url.openConnection();
            httpConn.setRequestMethod("POST");
            httpConn.setDoInput(true);
            httpConn.setDoOutput(true);
            out=new PrintWriter(httpConn.getOutputStream());
            out.println(params);
            out.flush();
             
            if(httpConn.getResponseCode()==HttpURLConnection.HTTP_OK){
                StringBuffer content=new StringBuffer();
                String tempStr="";
                in=new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
                while((tempStr=in.readLine())!=null){
                    content.append(tempStr);
                }
                return content.toString();
            }else{
                throw new Exception("请求出现了问题!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            in.close();
            out.close();
            httpConn.disconnect();
        }
        return null;
    }
    
    public static void main(String[] args) throws Exception {
       String resMessage=yyy.post("http://www.zhihu.com/node/ExploreRecommendListV2", "method=next&params=%7B%22limit%22%3A20%2C%22offset%22%3A20%7D&_xsrf=d2877bc5aa9a8ee7a15f538962ce1f33");
       System.out.println(resMessage);
    	//testSelenium();
    }
 
}
