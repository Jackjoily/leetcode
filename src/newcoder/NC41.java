package newcoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import leetcode_tree.TreeNode;
import leetcode_tree.TreeUtils;

public class NC41 {
	public static void main(String[] args) {
		int a[] = { 2, 2, 3, 4, 3 };
		System.out.println(maxLength1(a));
	}

	public static int maxLength1(int[] arr) {
		int pos[] = new int[1000005];
		int start = 0;
		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			start = Math.max(start, pos[arr[i]]);
			res = Math.max(res, i - start + 1);
			pos[arr[i]] = i + 1;
		}
		return res;
	}

	public static int maxLength(int[] arr) {
		int n = arr.length;
		if (n <= 1)
			return n;
		int left = 0;
		int right = 0;
		int max = 0;
		LinkedList<Integer> list = new LinkedList<>();
		while (right < n) {
			if (list.size() == 0) {
				list.add(arr[right]);
				right++;
				max = Math.max(max, right - left);
			} else {
				if (!list.contains(arr[right])) {
					list.add(arr[right]);
					right++;
					max = Math.max(max, right - left);
				} else {
					while (list.size() != 0 && list.contains(arr[right])) {
						list.poll();
						left++;
					}
				}
			}
		}
		return max;
	}
}
