import java.util.*;
public class Hduoj1020 {
	public static void main(String[]args){
	Scanner input= new Scanner(System.in);
	int t=input.nextInt();
	while(t-->0){
		String s=new String(input.next());
		int i,j;
		for(i=0;i<s.length();i++){
			int temp=1;
			for(j=i+1;j<s.length();j++){
				if(s.charAt(i)==s.charAt(j))temp++;
				else break;
			}
			if(temp==1)System.out.printf("%c",s.charAt(i));
			else System.out.printf("%d%c",temp,s.charAt(i));
			i=j-1;
		}
		System.out.println("");
		
	}
	}
}
