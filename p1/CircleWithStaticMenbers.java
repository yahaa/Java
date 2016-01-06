
public class CircleWithStaticMenbers {
double radius;
static  int number=0;
CircleWithStaticMenbers(){
	radius=1;
	number++;
}
CircleWithStaticMenbers(double n){
	radius=n;
	number++;
	
}
static void changeNumbers(int n){
	number=1;

}
}
