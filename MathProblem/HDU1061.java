import java.util.*;
public class HDU1061 {
	public static void main(String[]args){        //��ѧ����   �� a^a ���һλ��
		Scanner input=new Scanner(System.in);
		int tt=input.nextInt();
		while(tt-->0){
			int n=input.nextInt();
			int t=n%4+4;
			int num=n%10;
			int ans=1;
			for(int i=1;i<=t;i++)ans*=num;
			System.out.println(ans%10);
		}
	}

}
