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
public class M_698 {

	public static void main(String[] args) {
		int a[] = { 2, 2, 2, 2, 3, 4, 5 };
		System.out.println(canPartitionKSubsets(a, 4));
	}

	public static boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0;
		int max = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			max = Math.max(nums[i], max);
		}
		if (sum % k != 0)
			return false;
		int target = sum / k;
		boolean used[] = new boolean[nums.length];
		return f(nums, used, target, 0, new LinkedList<>(), 0, k);
	}

	public static boolean f(int a[], boolean used[], int target, int index, LinkedList<Integer> list, int sum, int k) {
		if (k == 1)
			return true;
		else if (sum == target) {
			return f(a, used, target, 0, new LinkedList<>(), 0, k - 1);
		} else {
			for (int i = index; i < a.length;i++) {
				if (used[i])
					continue;
				if (sum + a[i] > target)
					continue;
				used[i] = true;
				list.add(a[i]);
				if (f(a, used, target, i + 1, list, sum + a[i], k)) {
					return true;
				}
				used[i] = false;
				list.removeLast();
				while(i+1<a.length&&a[i]==a[i+1])i++;
			}
			return false;
		}
	}

}
