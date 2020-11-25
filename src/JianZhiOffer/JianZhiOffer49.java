package JianZhiOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 我们把只包含质因子 2、3 和 5 的数称作丑数 （Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer49 {

	public static void main(String[] args) {
		System.out.println(isUglyNumber(nthUglyNumber(222)));
	}

	/**
	 * 思路找出地推丑数的公式
	 * 
	 * @param n
	 * @return
	 */
	public static int nthUglyNumber(int n) {
		int dp[] = new int[n];
		int a = 0, b = 0, c = 0;
		int temp = 0;
		dp[0] = 1;
		for (int i = 1; i < n; i++) {
			int n1 = 2 * dp[a];
			int n2 = 3 * dp[b];
			int n3 = 5 * dp[c];
			dp[i] = Math.min(Math.min(n1, n2), n3);
			if (dp[i] == n1)
				a++;
			if (dp[i] == n2)
				b++;
			if (dp[i] == n3)
				c++;
		}
		return dp[n - 1];
	}

	public static boolean isUglyNumber(int n) {
		if (n <= 6)
			return true;
		while (n % 2 == 0)
			n = n / 2;
		while (n % 3 == 0)
			n = n / 3;
		while (n % 5 == 0)
			n = n / 5;
		if (n != 1)
			return false;
		return true;
	}
}
