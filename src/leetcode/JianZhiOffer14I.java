package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer14I {
	public static void main(String[] args) {
		System.out.println(cuttingRope(12));
	}

	public static int cuttingRope(int n) {
		int dp[] = new int[n + 1];
		if (n == 2)
			return 1;
		if (n == 3)
			return 2;
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 1;
		for (int i = 3; i <= n; i++) {
			int max = 0;
			for (int j = 1; j <= i-1; j++) {
				max = Math.max(j*(i-j), Math.max(j * dp[i - j], max));
			}
			dp[i] = max;
		}
		System.out.println(Arrays.toString(dp));
		return dp[n];
	}
}
