package p1;
import java.util.*;
public class Rational extends Number implements Comparable<Rational> {
private long numerator=0;       //·Ö×Ó
private long denominator=1;     //·ÖÄ¸

public Rational(){
	this(0,1);
}

public Rational(long numerator,long denominator){
	long gcd=gcd(numerator,denominator);
	this.numerator=((numerator>0)?1:-1)*numerator/gcd;
	this.denominator=Math.abs(denominator)/gcd;
}
private static long gcd(long x,long y){
	
	if(y==0)return x;
	else return gcd(y,x%y);
}

public long getNumerator(){
	return numerator;
}

public long getDenominator(){
	return denominator;
}

public Rational add(Rational o){
	long y=o.getDenominator()*denominator;
	long x=o.getNumerator()*denominator+numerator*o.getDenominator();
	return new Rational(x,y);
}

public Rational subtract(Rational o){
	long y=denominator*o.getDenominator();
	long x=numerator*o.getDenominator()-o.getNumerator()*denominator;
	return new Rational(x,y);
}

public Rational multiply(Rational o){
	long y=denominator*o.getDenominator();
	long x=numerator*o.getNumerator();
	return new Rational(x,y);
}

public Rational divide(Rational o){
	long y=denominator*o.getNumerator();
	long x=numerator*o.getDenominator();
	return new Rational(x,y);
}

public String toString(){
	if(denominator==1)return numerator+"";
	else return numerator+"/"+denominator;
}

public boolean equals(Object other){
	if((this.subtract((Rational)(other))).getNumerator()==0)return true;
	else return false;
}

public int intValue(){
	return (int)doubleValue();
}

public double doubleValue(){
	return (double)numerator/denominator;
}

public long longValue(){
	return (long)doubleValue();
}

public float floatValue(){
	return (float)doubleValue();
}

public int compareTo(Rational o){
	if(this.subtract(o).getNumerator()>0)return 1;
	else if(this.subtract(o).getNumerator()<0)return -1;
	else return 0;
}

}












