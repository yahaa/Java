package p1;
import java.util.*;

public class TestCalender {
	public static void main(String[] args){
		Calendar calender=new GregorianCalendar();
	//	System.out.println("");
		System.out.println("Current time is  "+new Date());
		System.out.println("year :"+calender.get(Calendar.YEAR));
		System.out.println("month :"+calender.get(Calendar.MONTH));
		System.out.println("day :"+calender.get(Calendar.DATE));
		System.out.println("hour :"+calender.get(Calendar.HOUR));
		System.out.println("HOUR_OF_DAY :"+calender.get(Calendar.HOUR_OF_DAY));
		System.out.println("minute :"+calender.getFirstDayOfWeek());
		System.out.println(calender.get(Calendar.AM_PM));
		System.out.println(calender.get(Calendar.DAY_OF_MONTH));
		System.out.println(calender.get(Calendar.DECEMBER));
		System.out.println(calender.get(Calendar.DST_OFFSET));
		System.out.println(calender.clone());
	}
}
