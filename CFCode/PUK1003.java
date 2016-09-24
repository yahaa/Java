import java.io.BufferedInputStream;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.lang.Math.*;

public class PUK1003 {
	public static void main(String []args){
		Task11 t=new Task11();
		t.solve();
	}
}

class Task11{
	Scanner input=new Scanner(new BufferedInputStream(System.in));
	Map<String,Integer>map=new TreeMap<String,Integer>();
	public void solve(){
		
		while(input.hasNext()){
			String s;
			map.clear();
			while(true){
				s=input.nextLine();
				if(s.equals("####"))break;
				s=s.replaceAll("[ ]+", "*");
				
				int n=s.length();
				for(int i=1;i<s.length()-1;i++){
					if(s.charAt(i)=='*'&&Character.isAlphabetic(s.charAt(i+1))&&Character.isAlphabetic(s.charAt(i-1))){
						int r=i+1,l=i-1;
						while(r<n&&Character.isAlphabetic(s.charAt(r)))r++;
						while(l>=0&&Character.isAlphabetic(s.charAt(l)))l--;
						String t=s.substring(l+1,r);
						t=t.replaceAll("[*]"," ");
						if(map.containsKey(t)){
							int v=map.get(t);
							v++;
							map.put(t, v);
						}
						else map.put(t, 1);
					}
				}
			}
			
			int mm=-100;
			String ms="";
			Set<Map.Entry<String, Integer>>set=map.entrySet();
			for(Map.Entry<String, Integer> en:set){
				if(en.getValue()>mm){
					mm=en.getValue();
					ms=en.getKey();
				}
			}
			
			System.out.println(ms+":"+mm);
			
			
			
		}
	}
}
