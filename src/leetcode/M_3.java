package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * @author jackjoily
 *
 */
public class M_3 {

	/**
	 * 使用双指针
	 */
	public int lengthOfLongestSubstring1(String s) {
		char[] c = s.toCharArray();
		int n = c.length;
		if (n <= 1)
			return n;
		int max = 0;
		HashSet<Character> set = new HashSet<>();
		int left = 0, right = -1;
		while (left < n) {
			if (left != 0) {
				set.remove(c[left - 1]);
			}
			while (right + 1 < n && !set.contains(c[right + 1])) {
				set.add(c[right + 1]);
				right++;
			}
			max = Math.max(max, right - left + 1);
			left++;
		}
		return max;
	}

	/**
	 * 使用dp数组进行解答
	 * 
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring(String s) {
		char[] c = s.toCharArray();
		int n = c.length;
		if (n <= 1)
			return n;
		int dp[] = new int[n];
		Arrays.fill(dp, 1);
		int max = 1;
		Map<Character, Integer> map = new HashMap<>();
		map.put(c[0], 0);
		int i = 1;
		while (i < n) {
			if (c[i] != c[i - 1]) {
				if (map.containsKey(c[i])) {
					dp[i] = Math.min(dp[i - 1] + 1, i - map.get(c[i]));
				} else {
					dp[i] = dp[i - 1] + 1;
				}
				max = Math.max(max, dp[i]);
			}
			map.put(c[i], i);
			i++;
		}
		return max;
	}

}
