package leetcode_dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import edu.princeton.cs.algs4.In;

/**
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？ 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 * 
 * @author jackjoily
 *
 */
public class M_338 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(countBits(3)));
	}

	public static int[] countBits(int num) {
		if (num == 0) {
			return new int[1];
		}
		int dp[] = new int[num + 1];
		dp[0] = 0;
		dp[1] = 1;
		int k = 2;
		while (k <= num) {
			dp[k] = 1;
			for (int i = k + 1; i <= num && i < 2 * k; i++) {
				dp[i] = dp[k] + dp[i - k];
			}
			k = 2 * k;
		}
		return dp;
	}
}
