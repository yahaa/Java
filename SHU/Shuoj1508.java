import java.util.*;
public class Shuoj1508 {
	public static void main(String[]args){
		Scanner input=new Scanner(System.in);
		int t=input.nextInt();
		while(t-->0){
			String sh=input.nextLine();
			String a=input.nextLine();
			String b=input.nextLine();
			a=a.replace(" ", "");
			b=b.replace(" ", "");
			a=a.toUpperCase();
			b=b.toUpperCase();
			if(a.equals(b))System.out.println("YES");
			else System.out.println("NO");
		}
	}

}
