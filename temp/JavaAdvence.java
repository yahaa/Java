import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class JavaAdvence {
	public static void main(String[]args){
		System.out.println(max("123","245"));
		String []a={"asdf","akdsjf","jaksd"};
		print(a);
		test2();
		test3();
		test4();
		test5();
		test6();
		test7();
		test8();
	}
	
	
	public static void test1(){
		
	}
	
	public static <E extends Comparable<E>>E max(E e1,E e2){
		if(e1.compareTo(e2)>0)return e1;
		else return e2;
	}
	
	public static <E>void print(E [] a){
		for(E b:a){
			System.out.println(b);
		}
	}
	
	
	public static void test2(){
		ArrayList<String> list1=new ArrayList<String>();
		ArrayList<Integer> list2=new ArrayList<Integer>();
		ArrayList<String>[]rr=(ArrayList<String>[])new ArrayList[10];
		System.out.println(list1 instanceof ArrayList);
		System.out.println(list2);
		Rational t=new Rational(2,4);
		Rational tt=new Rational(2,3);
		System.out.println(t.multiply(tt));
		System.out.println(tt.doubleValue());
	}
	
	public static void test3(){
		ArrayList dates=new ArrayList();
		dates.add(new Date());
		dates.add("jakldsj");
		
		for(int i=0;i<dates.size();i++){
			System.out.println(dates.get(i));
		}
		ArrayList <Date>dd=new ArrayList<Date>();
		dd.add(new Date());
		//dd.add(//new String());
		
		ArrayList td=new ArrayList();
		td.add(new Date());
		//Date ta=td.get(0);改为Date ta=(Date)td.get(0);
	}
	
	public static void test4(){
		System.out.println("I'm 4");
		ArrayList<String> list1=new ArrayList<String>();
		ArrayList<String> list2=new ArrayList<String>();
		list2.add("java");
		list2.add("jaksdj");
		list1.add("132");
		add(list1,list2);
		for(int i=0;i<list2.size();i++){
			System.out.println(list2.get(i));
		}
	}
	
	public static <T> void add(ArrayList<T> list1,ArrayList<T> list2){
		for(int i=0;i<list1.size();i++){
			list2.add(list1.get(i));
		}
	}
	
	
	//测试集合
	public static void test5(){
		System.out.println("I'm 5");
		java.util.Set<String>set1=new java.util.HashSet<String>();
		set1.add("jjj");
		set1.add("jjjj");
		set1.add("kkk");
		set1.add("lllll");
		System.out.println(set1);
		java.util.Set<String> set2=new java.util.HashSet<String>();
		set2.addAll(set1);
		System.out.println(set2);
		set2.add("kkkkjjjkkk");
		set2.add("ffff");
		System.out.println(set2.contains("kkk"));
		System.out.println(set2.containsAll(set1));
	}
	
	public static void test6(){
		java.util.Set<String> set1=new java.util.LinkedHashSet<String>();
		set1.add("jsdk");
		set1.add("uuu");
		set1.add("askdjf");
		System.out.println(set1);
		Iterator<String>it=set1.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	}
	
	public static void test7(){
		Set<String> set1=new HashSet<String>();
		set1.add("123");
		set1.add("1234");
		set1.add("12345");
		set1.add("123456");
		TreeSet<String> set2=new TreeSet<String>();
		set2.add("aa");
		set2.add("tt");
		set2.add("cc");
		set2.add("gg");
		set2.add("uu");
		set2.add("jj");
		set2.add("56");
		System.out.println(set1);
		System.out.println("xxxxxxxxxxxxxxxxxxxxx");
		System.out.println(set2);
		System.out.println(set2.first());
		System.out.println(set2.last());
		System.out.println(set2.headSet("gg"));
		System.out.println(set2.tailSet("gg"));
		System.out.println(set2.size());
		
		
		
	}
	
	public static void test8(){
		ArrayList<String>a=new ArrayList<String>();
		a.add("1");
		a.add("sadf");
		a.add("sadf");
		a.add("sadf");
		a.add("sadf");
		a.add("sadf");
		a.add("sadf");
		a.add("sadf");
		a.add("sadf");
		a.add("sadf");
		a.add("end");
		System.out.println(a);
		Iterator<String>it=a.listIterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		String []t=(String[]) a.toArray();
		
	}
	
}


class TT<E>{
	
}
