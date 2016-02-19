package Basic3;
import java.util.*;
public class TestQueue {
	public static void main(String []args){
		Queue<String>queue=new LinkedList<String>();
		queue.add("aa");
		queue.add("ab");
		queue.add("ac");
		queue.add("ad");
		queue.add("ae");
		queue.add("af");
		queue.add("ag");
		queue.add("ah");
		queue.add("aj");
		queue.add("ak");
		System.out.println(queue.size());
		System.out.println(queue.contains("aaa"));
		while(!queue.isEmpty()){
			System.out.println(queue.poll());
		}
	}

}
