import java.util.*;
public class HDUOJ116{
	public static void main(String[]args){
		Scanner input=new Scanner(System.in);
		String s;
		while(input.hasNext()){
			s=input.nextLine();
			for(int i=0;i<s.length();i++){
				if(Character.isUpperCase(s.charAt(i)))System.out.print(Character.toLowerCase(s.charAt(i)));
				else System.out.print(s.charAt(i));
			}
			System.out.println();
		}
	}
}
