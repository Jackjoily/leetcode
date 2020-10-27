package basic;

public class Test1 {
	public static void main(String[] args) {
		System.out.println(judge(16));
		System.out.println(judge(15));
	}

	static boolean judge(int x) {
		if (x <= 0)
			return false;
		if (lowbit(x) == x) 
			return true;
		
		return false;
	}
	//b C d

	public static int lowbit(int x) {
		return ((x) & (x+1));
	}
}
