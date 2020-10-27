package JianZhiOffer;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。 求所有子数组的和的最大值。 要求时间复杂度为O(n)。
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer14_1 {
	public static void main(String[] args) {
		System.out.println(cuttingRope(5));
	}

	/**
	 * 假设d[i]表示长度为i的绳子能达到的最大乘积 使用动态规划的算法
	 * 
	 * @param n
	 * @return
	 */
	public static int cuttingRope(int n) {
		if (n == 2)
			return 1;
		if (n == 3)
			return 2;
		int dp[] = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 1;
		int max = Integer.MIN_VALUE;
		for (int i = 3; i <= n; i++) {
			for (int j = 2; j <= i; j++) {
				max = Math.max(max, j * dp[i - j]);
			}
			dp[i] = max;
		}
		return dp[n];
	}
}
