package generic;
import java.util.*;
import java.math.*;
public class GenercMethod {
	public static void main(String[]args){
		Integer []integer={1,2,3,4,5,6,7};
		int []v={1,2,3,4,5};
		String []string={"jaklsdfj","jkasldjf","uqweoiu","jdskjf"};
		print(string);
		int a=1000,b=100;
		String bb="jaklsdjfkljas";
		add(bb,b);
		ArrayList bbb=new ArrayList();
		ArrayList<String> rr=new ArrayList();     //��������ʹ�á�����Ҳ���ԡ�new ArrayList<String>(); 
		rr.add("aklsdfj");
		rr.add("jkasldfj");

		bbb.add(1);
		for(int i=0;i<bbb.size();i++)
		System.out.println(bbb.get(i));
		
		for(int i=0;i<rr.size();i++)System.out.println(rr.get(i));
		System.out.println(max("sakd","asdjklasdkl;jfkljasdfjklasklfjlskfj"));
		
	}
	
	public static <E>   //�� c++������ͬ
    void print(E[]list){
		for(E a:list)System.out.println(a);
	}
	
	public static <E>
	void add(E a,E b){
		System.out.println(a);    //���������a+b  
	}
	
	public static <E extends Object>
	void ccc(E a,E b){
		System.out.println(a);
	}
	
	
	public static <E extends Comparable<E>>
	E max(E a,E b){
		if(a.compareTo(b)>0)return a;
		else return b;
	}

}
