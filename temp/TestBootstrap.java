import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.List;


class TET{
	private String name;
	private int age;
	
	public TET(){
		name="asd";
		age=44;
	}
	
	public TET(String name,int age){
		this.name=name;
		this.age=age;
	}
	
	public String getName(){
		return name;
	}
	
	public int getAge(){
		return age;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public void setAge(int age){
		this.age=age;
	}
	
	
}

class Tests{
	public void replace(String str,List<String>list){}
}


public class TestBootstrap {
	public static void main(String[]args)throws Exception{
		Class<TET>clazz=TET.class;
		System.out.println(clazz.getConstructor(String.class,int.class).newInstance("123",444).getAge());
		//Method m=clazz.getMethod("setName", String.class);
		System.out.println(clazz.newInstance().getName());
		//System.out.println(m.getParameterCount());
	}
}

