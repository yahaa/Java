package Basic4;
import java.util.*;
public class SpiderQueue {
	private static Set<Object> vistedURL=new HashSet<>();
	private static Queue<Object>uVistedURL=new LinkedList<>();
	
	public static void addVistedURL(String url){
		vistedURL.add(url);
	}
	
	public static void removedVistedURL(String url){
		vistedURL.remove(url);
	}
	
	public static int getVistedURLCounts(){
		return vistedURL.size();
	}
	
	public static Queue uVistedURLQueue(){
		return uVistedURL;
	}
	
	public static Object uVistedURLPop(){
		return uVistedURL.remove();
	}
	
	public static void addUVistedURL(String url){
		if(url!=null&&!url.trim().equals("")&&!vistedURL.contains(url)&&!uVistedURL.contains(url)){
			uVistedURL.add(url);
		}
	}
	
	public static boolean isEmptyUVistedURL(){
		return !uVistedURL.isEmpty();

	}

}
