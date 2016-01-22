
import java.util.*;
public class Hous implements Cloneable,Comparable<Hous>{      //两个接口
	private int id;
	private double area;
	private Date whenBuilt;
	
	public Hous(int id,double area){
		this.id=id;
		this.area=area;
		this.whenBuilt=new Date();
	}
	
	public int getId(){
		return id;
	}

	public double getArea(){
		return area;
	}
	
	public Date getWhenBuilt(){
		return whenBuilt;
	}

	@Override
	public Object clone()throws CloneNotSupportedException{

		return super.clone();
	}
	
	@Override
	public int compareTo(Hous o){
		if(area>o.area)return 1;
		else if(area<o.area)return -1;
		else return 0;
	}

}
