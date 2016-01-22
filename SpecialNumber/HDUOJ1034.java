import java.util.*;
import java.math.*;
public class HDUOJ1034 { 
    public static void main(String[]args){   //¿¨ÌØÀ¼Êý
        Scanner input=new Scanner(System.in);
        BigInteger []a=new BigInteger[105];
        BigInteger t1=new BigInteger("1");
        BigInteger t2=new BigInteger("2");
        BigInteger t4=new BigInteger("4");
        a[0]=t1;
        a[1]=t1;
        BigInteger i=new BigInteger("2");
        BigInteger maxn=new BigInteger("101");
        int j=2;
        while(j<101){
            a[j]=a[j-1].multiply(t4.multiply(i).subtract(t2)).divide(i.add(t1));
            i=i.add(t1);
            j++;
        }
        while(input.hasNext()){
            int n=input.nextInt();
            if(n==-1)break;
            System.out.println(a[n]);
        }
    }
}