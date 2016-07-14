import java.nio.channels.*;
import java.nio.Buffer;
import java.nio.IntBuffer;
public class TestBuffer {
	public static void main(String[]args){
		IntBuffer buffer=IntBuffer.allocate(10);
		int p=buffer.position();
		int l=buffer.limit();
		int c=buffer.capacity();
		System.out.println("init "+p+  " "+l+" "+c);
		for(int i=0;i<buffer.capacity();i++){
			buffer.put(i*2+2);
		}
		p=buffer.position();
		l=buffer.limit();
		c=buffer.capacity();
		System.out.println("last "+p+  " "+l+" "+c);
		buffer.flip();
		p=buffer.position();
		l=buffer.limit();
		c=buffer.capacity();
		System.out.println("last "+p+  " "+l+" "+c);
		while(buffer.hasRemaining()){
			System.out.println(buffer.get());
		}
		
		p=buffer.position();
		l=buffer.limit();
		c=buffer.capacity();
		System.out.println("last "+p+  " "+l+" "+c);
	}
}
