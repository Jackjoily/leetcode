package leetcode_dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author jackjoily
 *
 */
public class M_322 {

	public static void main(String[] args) {
		M_322 m = new M_322();
		int a[] = { 2 };
		int coinChange = m.coinChange(a, 3);
	}

	int amount = 0;
	LinkedList<Integer> list = new LinkedList<>();
	ArrayList<Integer> list1 = new ArrayList<>();

	public int coinChange(int[] coins, int amount) {
		if (amount == 0)
			return 0;
		if (coins.length == 0)
			return -1;
		int dp[] = new int[amount + 1];

		int max = amount + 1;
		Arrays.fill(dp, max);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (!(i < coins[j])) {
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
				}
			}
		}
		return dp[amount] == amount+1 ? -1 : dp[amount];
	}

	/**
	 * 回溯法
	 * 
	 * @param coins
	 * @param sum
	 */
	public void f(int[] coins, int sum) {
		if (sum == amount) {
			list1.add(list.size());
			return;
		}
		if (sum > amount) {
			return;
		}
		for (int i = 0; i < coins.length; i++) {
			sum += coins[i];
			list.add(coins[i]);
			f(coins, sum);
			list.removeLast();
			sum -= coins[i];
		}
	}
}
