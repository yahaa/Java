package Basic3;
import java.util.*;
public class TestPriorityQueue {
	public static void main(String[]args){
		PriorityQueue<String>queue=new PriorityQueue<String>();
		queue.offer("aaaaaaa");
		queue.offer("ab");
		queue.offer("c");
		queue.offer("dggggggg");
		queue.offer("aff");
		queue.offer("h");
		queue.offer("i");
		queue.offer("b");
		while(!queue.isEmpty()){
			System.out.println(queue.remove());
		}
		
	}

}
