package p1;
import java.util.*;
public class TestDate {
public static void main(String [] args){
	Date date=new Date();
	Date date1=date;     //date ���������������      ����   ���Ƶ���  ����           ָ��ͬһ���ڴ�  
	Date date2=(Date)(date.clone());    //date2  ��date�ĸ���Ʒ        ���൱����� 
	System.out.println(date==date1);
	System.out.println(date==date2);     // == �Ƚϵ��ǵ�ַ
	System.out.println(date.equals(date2));         //equals   �Ƚϵ��������Ƿ�Ϊ��ͬ��
}
}
