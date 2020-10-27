package leetcode_dp;

/**
 * 给定一个正整数 n，将其拆分为至少两个 正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * 
 * @author jackjoily
 *
 */
public class M_343 {
	public static void main(String[] args) {
		System.out.println(integerBreak(8));
	}

	public static int integerBreak(int n) {
		int dp[] = new int[n + 1];
		dp[1] = 1;
		dp[2] = 1;
		if (n <= 2)
			return dp[n];
		for (int i = 3; i <= n; i++) {
			int max = 1;
			for (int j = i - 1; j >= 1; j--) {
				max = Math.max(Math.max(max, dp[j] * (i - j)), j*(i-j));
			}
			dp[i] = max;
		}
		return dp[n];
	}
}
