import java.lang.reflect.Constructor;
import java.net.URL;


public class TestBootstrap {
	public static void main(String[]args){
		Class ts=String.class;
		int i=0;
		for(java.lang.reflect.Method t:ts.getDeclaredMethods()){
			System.out.println(t);
			System.out.println(++i);
		}
	}
}
