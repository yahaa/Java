
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * ʹ��Jsoupģ���½Iteye
 * 
 * 
 * ����˼·����:
 * 
 * ��һ�������½ҳ�棬��ȡҳ����Ϣ����������Ϣ����cookie���������Ҫ�����ò�������ģ���½����
 * 
 * 
 * �ڶ��ε�½�������û��������룬�ѵ�һ�ε�cooking���Ž�ȥ������
 * 
 * ��ôȷ���Ƿ��½�ɹ���
 * 
 * ��½�󣬴�ӡҳ�棬�ῴ����ӭxxx������֤��
 * 
 * 
 * @date 2014��6��27��
 * @author qindongliang
 * 
 * 
 * **/
public class JsoupLogin {
  
  public static void main(String[] args)throws Exception {
    
    JsoupLogin jli=new JsoupLogin();
    jli.login("1477765176@qq.com", "Asd147258");//����Iteye���û�����������
    
  }
  /**
   * ģ���½Iteye
   * 
   * @param userName �û���
   * @param pwd ����
   * 
   * **/
  public void login(String userName,String pwd)throws Exception{
    
    //��һ������
    Connection con=Jsoup.connect("http://www.iteye.com/login");//��ȡ����
    con.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:29.0) Gecko/20100101 Firefox/29.0");//����ģ�������
        Response rs= con.execute();//��ȡ��Ӧ
        Document d1=Jsoup.parse(rs.body());//ת��ΪDom��
 	    List<Element> et= d1.select("#login_form");//��ȡform��������ͨ���鿴ҳ��Դ������֪
 	    
 	   //��ȡ��cooking�ͱ����ԣ�����map���postʱ������ 
       Map<String, String> datas=new HashMap<>();
     for(Element e:et.get(0).getAllElements()){
       if(e.attr("name").equals("name")){
         e.attr("value", userName);//�����û���
       }
       
       if(e.attr("name").equals("password")){
         e.attr("value",pwd); //�����û�����
       }
       
       if(e.attr("name").length()>0){//�ų���ֵ������
         datas.put(e.attr("name"), e.attr("value"));  
       }
     }
 	    
     
     /**
      * �ڶ�������post�����ݣ��Լ�cookie��Ϣ
      * 
      * **/
     Connection con2=Jsoup.connect("http://www.iteye.com/login");
     con2.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:29.0) Gecko/20100101 Firefox/29.0");
     //����cookie��post�����map����
 	   Response login=con2.ignoreContentType(true).method(Method.POST).data(datas).cookies(rs.cookies()).execute();
 	   //��ӡ����½�ɹ������Ϣ
 	   System.out.println(login.body());
 	   
 	   //��½�ɹ����cookie��Ϣ�����Ա��浽���أ��Ժ��½ʱ��ֻ��һ�ε�½����
 	   Map<String, String> map=login.cookies();
 	   for(String s:map.keySet()){
 		   System.out.println(s+"      "+map.get(s));
 	   }
 	
  }
  
  
  

  
  
}