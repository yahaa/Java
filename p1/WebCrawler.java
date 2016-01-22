
import java.util.*;
public class WebCrawler {
	public static void main(String []args){
		java.util.Scanner input=new Scanner(System.in);
		System.out.println("Enter your URL");
		String url=input.nextLine();
		crawler(url);
	}
	
	
	public static void crawler(String url){
		ArrayList<String> listOfPendingURLs=new ArrayList<>();
		ArrayList<String> listOfTraversedURLs=new ArrayList<>();
		listOfPendingURLs.add(url);
		while(!listOfPendingURLs.isEmpty()&&listOfTraversedURLs.size()<=100){
			if(!listOfTraversedURLs.contains(url)){
				listOfTraversedURLs.add(url);
				System.out.println("crawl "+url );
				for(String s:getSubURLs(url)){
					if(!listOfTraversedURLs.contains(s))listOfPendingURLs.add(s);
				}
				
			}
		}
	}
	
	
	public static ArrayList<String> getSubURLs(String s){
		ArrayList<String> list=new ArrayList<>();
		try{
			java.net.URL url=new java.net.URL(s);
			Scanner input=new Scanner(url.openStream());
			int current=0;
			while(input.hasNext()){
				String line=input.nextLine();
				current=line.indexOf("http:",current);
				while(current>0){
					int endIndex=line.indexOf("\"",current);
					if(endIndex>0){
						list.add(line.substring(current, endIndex));
						current=line.indexOf("http:",endIndex);
					}
					else current=-1;
				}
			}
		}
		catch(Exception ex){
			System.out.println("error :"+ex.getMessage());
		}
		return list;
	}
	
	
	

}
