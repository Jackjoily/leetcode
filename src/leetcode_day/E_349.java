package leetcode_day;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 */
public class E_349 {
	public static void main(String[] args) {
		E_349 e = new E_349();
		int a[] = { 1, 2 };
	}

	public int[] intersection(int[] nums1, int[] nums2) {
		if (nums1.length == 0 || nums2.length == 0)
			return new int[0];
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				if (nums1[i] == nums2[j]) {
					set.add(nums1[i]);
					break;
				}
			}
		}
		int a[] = new int[set.size()];
		Iterator<Integer> iterator = set.iterator();
		int l = 0;
		while (iterator.hasNext()) {
			a[l] = iterator.next();
			l++;
		}
		return a;
	}

}
