package p1;
import java.util.*;
public class Shuoj1141mima {
public static void main(String[] args){
	int m;
	Scanner input=new Scanner(System.in);
	String s;
	m=input.nextInt();
	int a,b,c,d;
	while(m-->0){
		a=b=c=d=0;
		s=input.next();
		if(s.length()>=8){
			for(int i=0;i<s.length();i++){
				if(s.charAt(i)>='A'&&s.charAt(i)<='Z')a++;
				else if(s.charAt(i)>='a'&&s.charAt(i)<='z')b++;
				else if(s.charAt(i)>='0'&&s.charAt(i)<='9')c++;
				else if(s.charAt(i)=='~'||s.charAt(i)=='!'||
						s.charAt(i)=='@'||s.charAt(i)=='#'||
						s.charAt(i)=='$'||s.charAt(i)=='%'||
						s.charAt(i)=='^')d++;
			}
		int ans=0;
		if(a>0)ans++;
		if(b>0)ans++;
		if(c>0)ans++;
		if(d>0)ans++;
		if(ans>=3)System.out.println("YES");
		else System.out.println("NO");
		}
		else System.out.println("NO");

	}
	
}
}
