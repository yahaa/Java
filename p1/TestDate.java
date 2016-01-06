package p1;
import java.util.*;
public class TestDate {
public static void main(String [] args){
	Date date=new Date();
	Date date1=date;     //date 是数据域对象类型      所以   复制的是  引用           指向同一个内存  
	Date date2=(Date)(date.clone());    //date2  是date的复制品        即相当于深复制 
	System.out.println(date==date1);
	System.out.println(date==date2);     // == 比较的是地址
	System.out.println(date.equals(date2));         //equals   比较的是内容是否为相同的
}
}
