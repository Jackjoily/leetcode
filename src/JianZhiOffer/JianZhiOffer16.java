package JianZhiOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现函数double Power(double base, int exponent)，
 * 求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer16 {
	public static void main(String[] args) {
		System.out.println(myPow(0.00001
				,2147483647
				));
	}

	public static double myPow(double x, int n) {
		double dp[] ;
		if (n > 0) {
			dp	= new double[n];
			dp[0] = x;
			for (int i = 1; i < n; i++) {
				dp[i] = dp[i - 1] * x;
			}
			return dp[n - 1];
		} else if (n == 0) {
			return 1;
		} else {
			n = -n;
			dp	= new double[n];
			dp[0] = x;
			for (int i = 1; i < n; i++) {
				dp[i] = dp[i - 1] * x;
			}
			return 1/dp[n - 1];
		}
	}
}
