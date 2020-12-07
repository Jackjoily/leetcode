package leetcode_day;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 统计所有小于非负整数 n 的质数的数量。
 *
 *
 */
public class E_204 {
	public static void main(String[] args) {
	}

	public int countPrimes(int n) {
		int[] isPrime = new int[n];
		Arrays.fill(isPrime, 1);
		int ans = 0;
		for (int i = 2; i < n; ++i) {
			if (isPrime[i] == 1) {
				ans += 1;
				if ((long) i * i < n) {
					for (int j = i * i; j < n; j += i) {
						isPrime[j] = 0;
					}
				}
			}
		}
		return ans;

	}
}
