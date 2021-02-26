package leetcode_dp;

/**
 * 
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。 该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 */
public class E_509 {
	public static void main(String[] args) {
     System.out.println(fib(3));
	}

	public  static int fib(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		int a = 0, b = 1;
		int c = 0;
		for (int i = 2; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}
}
