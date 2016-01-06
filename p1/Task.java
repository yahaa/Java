package p1;

public class Task {
private boolean x;
public static void main(String []args){
	Task t=new Task();
	System.out.println(t.x);
	System.out.println(t.convert());
}
private int convert(){
	return x?1:-1;
}

}
