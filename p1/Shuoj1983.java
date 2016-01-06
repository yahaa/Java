import java.util.*;
public class Shuoj1983 {
public static void main(String[]args){
	Scanner input=new Scanner(System.in);
	long []same=new long[61];
	long []nSame=new long[61];
	same[1]=1;
	nSame[1]=0;
	for(int i=2;i<=60;i++){
		same[i]=nSame[i-1];
		nSame[i]=2*same[i-1]+nSame[i-1];
	}
	while(input.hasNext()){
		int n=input.nextInt();
		if(n==1)System.out.println(3);
		else System.out.println(3*nSame[n]);
	}
}
}
