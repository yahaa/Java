import java.math.BigInteger;
import java.util.*;
public class HDUOJ2067 {
	static final int  max=105;
	public static void main(String[]args){
		Scanner input=new Scanner(System.in);    //大数据求卡特兰数   通用模板
		BigInteger []a=new BigInteger[max];
		BigInteger t1=new BigInteger("1");
		BigInteger t2=new BigInteger("2");
		BigInteger t4=new BigInteger("4");
		a[0]=t1;
		a[1]=t1;
		BigInteger i=new BigInteger("2");
		BigInteger maxn=new BigInteger("101");
		int j=2;
		while(j<101){
			a[j]=a[j-1].multiply(t4.multiply(i).subtract(t2)).divide(i.add(t1));     //求卡特兰数
			i=i.add(t1);
			j++;
		}  
		
		int t=1;      //求解过程
		while(input.hasNext()){
			int n=input.nextInt();
			if(n==-1)break;
			System.out.println(t+++" "+n+" "+a[n].multiply(t2));
		}
	}
}
