import java.util.Arrays;

public class CF23 implements Comparable {
	public static void main(String[]args){
		String s="0.(123456)";
		if(s.contains("1"));
		int i=s.indexOf("(");
		System.out.println(s.substring(2,i));
		System.out.println(s.substring(i+1,s.length()-1));
		String ts="00000123";
		System.out.println(Integer.valueOf(ts));
		int []a={1,2,4,5,6};
		Arrays.sort(a, 0, 4);
		System.out.println(Arrays.binarySearch(a, 1));
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
