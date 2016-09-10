import java.util.*;
public class HDUOJ1042 {
    static int maxn=1000000;
    public static void main(String[]args){
        Scanner input=new Scanner(System.in);
        double aa=input.nextDouble();
        while(input.hasNext()){
            int []a=new int [maxn];
            int n=input.nextInt();
            a[0]=1;
            String s;
            Queue<Integer>qu=new LinkedList<Integer>();
            Stack<Integer>sta=new Stack<Integer>();
            ArrayList<String>aaa=new ArrayList<String>();
            Iterator<String>it=aaa.iterator();
            int []an=new int[10];
            
            int lengths=1;
            String ss="slfjas";
            for(int i=1;i<=n;i++){
                int k=0;
                for(int j=0;j<lengths;j++){
                    int temp=a[j]*i+k;
                    a[j]=temp%10;
                    k=temp/10;
                }
                while(k!=0){
                    a[lengths++]=k%10;
                    k/=10;
                }
            }
            for(int i=lengths;i>=0;i--){
                if(i==lengths&&a[i]==0)continue;
                System.out.print(a[i]);
            }
            System.out.println();
        }
    }
}