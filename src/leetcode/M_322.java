package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.omg.PortableInterceptor.INACTIVE;

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_322 {
	public static void main(String[] args) {
		int a[] = { 1, 2, 5 };
		System.out.println(coinChange2(a, 11));
		int b[] = { 2 };
		coinChange2(b, 3);
	}

	static int min = Integer.MAX_VALUE;

	public static int coinChange(int[] coins, int amount) {
		LinkedList<Integer> list = new LinkedList<>();
		Arrays.sort(coins);
		f(coins, amount, coins.length - 1, list);
		return min == Integer.MAX_VALUE ? -1 : min;
	}

	public static void f(int a[], int target, int begin, LinkedList<Integer> list) {
		if (target == 0) {
			min = Math.min(min, list.size());
			return;
		}
		if (target < 0)
			return;
		for (int i = begin; i >= 0; i--) {
			list.add(a[i]);
			f(a, target - a[i], i, list);
			list.removeLast();
		}
	}

	/**
	 * 使用dp的方式进行解答
	 * 
	 * @param coins
	 * @param amount
	 * @return
	 */
	public static int coinChange2(int[] coins, int amount) {
		int dp[] = new int[amount + 1];
		int max = amount + 1;
		Arrays.fill(dp, max);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i) {
					dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
				}
			}
		}
		return dp[amount] > amount ? -1 : dp[amount];
	}
}
