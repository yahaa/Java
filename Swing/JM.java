import java.io.UnsupportedEncodingException;  
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.DigestUtils;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;  
  
public class JM {  
	//把字符
	private static String toHex(byte buffer[]){  
        StringBuffer sb = new StringBuffer(buffer.length * 2);  
        for (int i = 0; i < buffer.length; i++) {  
            sb.append(Character.forDigit((buffer[i] & 240) >> 4, 16));  
            sb.append(Character.forDigit(buffer[i] & 15, 16));  
        }  
        return sb.toString();  
    }  
	
	public static String MD5(String s){
		String ans=null;
		try{
			MessageDigest messagedigest=MessageDigest.getInstance("MD5");
			messagedigest.update(s.getBytes());
			ans=toHex(messagedigest.digest());
			//ans=Base64.encode(messagedigest.digest());
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return ans;
	}
  
	
    public static String string2MD5(String inStr){
        MessageDigest md5 = null;  
        try{  
            md5 = MessageDigest.getInstance("MD5");  
        }
        catch (Exception e){  
            System.out.println(e.toString());  
            e.printStackTrace();  
            return "";  
        }  
        char[] charArray = inStr.toCharArray();  
        byte[] byteArray = new byte[charArray.length];  
  
        for (int i = 0; i < charArray.length; i++)byteArray[i] = (byte) charArray[i];  
        byte[] md5Bytes = md5.digest(byteArray);  
        StringBuffer hexValue = new StringBuffer();  
        for (int i = 0; i < md5Bytes.length; i++){  
            int val = ((int) md5Bytes[i]) & 0xff;  
            if (val < 16)hexValue.append("0");
            hexValue.append(Integer.toHexString(val));  
        }  
        return hexValue.toString();  
    }  
    
    
    public static String convertMD5(String inStr){  
        char[] a = inStr.toCharArray();  
        for (int i = 0; i < a.length; i++){  
            a[i] = (char) (a[i] ^ 't');  
        }  
        String s = new String(a);  
        return s;  
    }  
  
    // 测试主函数  
    public static void main(String args[]) {  
    	String ans=DigestUtils.md5Hex("000000");
    	System.out.println(ans.length());
    	System.out.println(ans);
    	String s="12345";
        System.out.println("原始：" + s);  
        System.out.println("MD5后：" + string2MD5(s));  
        System.out.println("加密的：" + convertMD5(s));  
        System.out.println("解密的：" + convertMD5("EFG@A"));  
        System.out.println(MD5("12345"));
  
    }
    
    
}  