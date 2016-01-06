
public class TestMax {
	
public static void main(String[] args){
	int i=5;
	int j=2;
	int k=max(i,j);
	double []myList={1,3,5,6,7};
	for(double e:myList){
		System.out.print(e);
	}
	System.out.println("lkasjdfkljsd "+k);
	System.out.println(min(i,j));
}


public static int max(int i,int j){
	int result;
	if(i>j)result=i;
	else result=j;
	return result;
}


public static int min(int k,int j){
	if(j<k)return j;
	else return k;
}
public static int sign(int n){
	if(n>0)return 1;
	else if(n==0)return 0;
	else if(n<0)return -1;
	else return n;
}


}
