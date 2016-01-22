
import java.util.*;
public class Shuoj1145 {
public static void main(String[] args){
	int n,m;
	Scanner input=new Scanner(System.in);
	int sum=0;
	while(input.hasNext()){
		n=input.nextInt();
		m=input.nextInt();
		for(int i=n;i<=m;i++){
			if(i%3==1&&i%5==3)sum+=i;
		}
		System.out.println(sum);
	}
}
}
