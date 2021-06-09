package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import leetcode_list.ListNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_179 {
	public static void main(String[] args) {
		// int a[] = { 3, 30, 34, 5, 9 };
		int b[] = { 10, 2 };
		System.out.println(largestNumber(b));
	}

	public static String largestNumber(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return nums[0] + "";
		String str[] = new String[n];
		for (int i = 0; i < n; i++) {
			str[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String a = o1 + o2;
				String b = o2 + o1;
				return b.compareTo(a);
			}
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length; i++) {
			sb.append(str[i]);
		}
		String s = sb.toString();
		if (s.charAt(0) == '0' && s.length() > 1) {
			return "0";
		}
		return s;
	}
}
