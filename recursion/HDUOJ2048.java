import java.util.*;
import java.math.BigDecimal;
import java.text.*;
public class HDUOJ2048 {
    static final int max=21;
    public static void main(String[]args){
        Scanner input=new Scanner(System.in);
        long []f=new long[max+1];
        f[1]=0;
        f[2]=1;
        for(int i=3;i<=max;i++)f[i]=(i-1)*(f[i-1]+f[i-2]);     //´íÎ»ÅÅÐòË¼Ïë
        long []fe=new long[max+1];
        long ans=1;
        for(int i=1;i<max;i++){
            ans*=i;
            fe[i]=ans;
        }
        DecimalFormat forms=new DecimalFormat("0.00");
        int t=input.nextInt();
        while(t-->0){
            int n=input.nextInt();
            double aaa=f[n]*1.0/fe[n]*100;
            System.out.println(forms.format(aaa)+"%");
            
        }
    }
}