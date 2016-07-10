import java.io.UnsupportedEncodingException;
import java.net.*;
public class TestURLcoder {
	public static void main(String[]args){
		@SuppressWarnings("deprecation")
		String str;
		try {
			str = URLDecoder.decode("%e7%96%AF","utf-8");
			System.out.println(str);
			str=URLEncoder.encode("我是好人","GBK");
			System.out.println(str);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
