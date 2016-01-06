import java.util.*;
public class ShowCurrentTime {
public static void main(String[] args){
	long totalMilliseconds=System.currentTimeMillis();
	long totalSeconds=totalMilliseconds/1000; 
	long currentSeconds=totalSeconds%60;
	long totalMinutes=totalSeconds/60;
	long currentMinutes=totalSeconds%60;
	long totalHours=totalMinutes/60; 
	long currentHours=totalHours%24; 
	System.out.println("current time is "+currentHours+" :"
			+currentMinutes+" :"+currentSeconds);
	
	double d=4.5; 
	int i;
	i=0;
	System.out.println(i>0);
	int t=i>0?5:6;

	 
}
}
