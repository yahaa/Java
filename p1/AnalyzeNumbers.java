import java.util.*;
public class AnalyzeNumbers {
	//this is the way of main
	
	public int a;
	int b;
	public static void main(String[] args){
		java.util.Scanner input=new java.util.Scanner(System.in);
		System.out.println("Enter the number of items : ");
		int n=input.nextInt();
		double sum=0;
		double []myList=new double[n];
		System.out.println("Enter the numbers: ");
		for(int i=0;i<n;i++){
			myList[i]=input.nextDouble();
			sum+=myList[i];
		}
		double average=sum/n;
		System.out.println("average = "+average);
		System.out.print("the number larag of the average is ");
		for(int i=0;i<n;i++){
			if(myList[i]>average)System.out.print(myList[i]+ " ");
		}
		
		double []ttt=new double[100];
		for(int i=0;i<100;i++){
			ttt[i]=(double)(Math.random()*100);
		}
		Arrays.sort(ttt);  
		System.out.println("cout the number of ttt ");
		printMax(ttt);
	}
	
	
	//this is the way of printMax
	public static void printMax(double...number){
		if(number.length==0){
			System.out.println("nothing !");
			return ;
		}
		else for(int i=0;i<number.length;i++){
			System.out.printf("%.2f",number[i]);
			System.out.print("\n");
		}
	}

}
