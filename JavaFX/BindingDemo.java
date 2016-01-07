
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
public class BindingDemo {
public static void main(String[] args){
	DoubleProperty d1=new SimpleDoubleProperty(1);     //property 是获取属性的方法
	DoubleProperty d2=new SimpleDoubleProperty(2);
	d1.bind(d2);     //把d1  和   d2  绑定
	System.out.println("d1 is "+d1.getValue()+ " and d2 id "+d2.getValue());
	d2.setValue(70.2);
	System.out.println("d1 is "+d1.getValue()+" and d2 is "+d2.getValue());
}
} 
