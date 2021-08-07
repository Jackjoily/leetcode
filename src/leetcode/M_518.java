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

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_518 {
	public static void main(String[] args) {
		M_518 m = new M_518();
		int a[] = { 1,3,5 };
		int amount = 5;
		System.out.println(m.change(amount, a));
	}

	public int change(int amount, int[] coins) {
		int dp[] = new int[amount + 1];
		dp[0] = 1;
		for (int coin : coins) {
		for (int i = 1; i <=amount; i++) {
			if (i >= coin) {
					dp[i] += dp[i - coin];
				}
			}
		}
		return dp[amount];
	}

	public static int count = 0;

	public static void f(int[] coins, int target, int inx) {
		if (target == 0) {
			count++;
		}
		for (int i = inx; i < coins.length; i++) {
			if (target - coins[i] >= 0) {
				f(coins, target - coins[i], i);
			}
		}
	}
}
