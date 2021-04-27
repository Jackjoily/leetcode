package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
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
public class M_1052 {
	public static void main(String[] args) {
		int a[] = { 4, 10, 10 };
		int b[] = { 1, 1, 0 };
		int x = 2;
		System.out.println(maxSatisfied(a, b, x));

	}

	public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
		int sum = 0;
		for (int i = 0; i < customers.length; i++) {
			if (grumpy[i] == 0) {
				sum += customers[i];
			}
		}
		int max = 0;
		int increase = 0;
		for (int i = 0; i < X; i++) {
			increase += grumpy[i] * customers[i];
			max = Math.max(increase, max);
		}

		for (int i = X; i < customers.length; i++) {
			increase = increase - grumpy[i - X] * customers[i - X] + customers[i] * grumpy[i];
			max = Math.max(increase, max);
		}
		return sum + max;
	}
}
