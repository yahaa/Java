import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
public class TestCharset {
	public static  void main(String[]args){
		SortedMap<String, Charset>m=Charset.availableCharsets();
		for(String it:m.keySet())System.out.println(it+" --->"+m.get(it));
		Path p=Paths.get(".");
		Object a=new String("sdlfk");
		Object b=new Object();
	}

}
