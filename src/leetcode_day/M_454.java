package leetcode_day;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import leetcode_list.ListNode;

/**
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] +
 * D[l] = 0。
 * 
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1
 * 之间，最终结果不会超过 231 - 1 。
 * 
 * @author jackjoily
 *
 */

public class M_454 {
	public static void main(String[] args) {
		M_454 m = new M_454();
		int a[] = { 1, 1, -1, -1 };
		int b[] = { -1, -1, 1, 1 };
		int c[] = { 1, -1, 0, -1 };
		int d[] = { 1, 1, -1, 1 };
		System.out.println(m.fourSumCount(a, b, c, d));
	}

	public int fourSumCount(int[] a, int[] b, int[] c, int[] d) {
		int temp = 0;
		if (a.length == 0)
			return temp;
		int k = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (map.containsKey(a[i] + b[j])) {
					map.put(a[i] + b[j], map.get(a[i] + b[j])+1);
				} else {
					map.put(a[i] + b[j], 1);
				}
			}
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (map.containsKey(-(c[i] + d[j]))) {
					temp+=map.get(-(c[i] + d[j]));
				}
			}
		}
		return temp;
	}
}
