package p1;
import java.util.*;
public class Shuoj1144 {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		int n;
		int b;
		Set<Integer>a=new TreeSet<Integer>();
		while(input.hasNext()){
			n=input.nextInt();
			for(int i=0;i<n;i++){
				b=input.nextInt();
				a.add(b);
			}
			System.out.println(a.size());
			int y=0;
			for(int i:a){
				if(y!=a.size())
				System.out.print(i+" ");
				else System.out.println(i);
				y++;
			}
		   }
	}

}
