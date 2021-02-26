package leetcode_day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jdk.nashorn.internal.runtime.linker.LinkerCallSite;

/**
 *
 *
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。 例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 *
 *
 *
 *
 *
 * 
 */
public class E_989 {
	public static void main(String[] args) {
		int a[] = { 1};
        int k=9;
        System.out.println(addToArrayForm(a, k));
	}

	public static List<Integer> addToArrayForm(int[] A, int K) {
		List<Integer> list = new ArrayList<>();
		String str = "" + K;
		int n = A.length;
		int m = str.length();
		int i = n - 1, j = m - 1;
		int val = 0;
		int res = 0;
		int l = 0;
		while (i >= 0 && j >= 0) {
			l = val + A[i] + (str.charAt(j) - '0');
			res = l % 10;
			// 进位
			val = l / 10;
			i--;
			j--;
			list.add(res);
		}
		if (j >= 0) {
			while (j >= 0) {
				l = val + (str.charAt(j) - '0');
				res = l % 10;
				// 进位
				val = l / 10;
				j--;
				list.add(res);
			}
		} else {
			while (i >= 0) {
				l = val + A[i];
				res = l % 10;
				// 进位
				val = l / 10;
				i--;
				list.add(res);
			}
		}
		if (val == 1) {
			list.add(val);
		}
		Collections.reverse(list);
		return list ;
	}
}
