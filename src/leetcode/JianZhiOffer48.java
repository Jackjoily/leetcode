package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer48 {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("aaaaaaaaaaabbbbbbbbbbbbbbbbvvvvvvvvvvvvvdaffffffffdsafewwe"));
	}

	public static int lengthOfLongestSubstring(String s) {
		int max = 1;
		int len = s.length();
		char[] c = s.toCharArray();
		if (len <= 1)
			return len;
		int a[] = new int[26];
		Map<Character, Integer> map = new HashMap<>();
		int dp[] = new int[len];
		dp[0] = 1;
		map.put(c[0], 0);
		for (int i = 1; i < len; i++) {
			if (c[i] == c[i - 1])
				dp[i] = 1;
			else {
				if (map.containsKey(c[i])) {
					dp[i] = Math.min(dp[i - 1], i - map.get(c[i]) - 1) + 1;
				} else {
					dp[i] = dp[i - 1] + 1;
				}

			}
			max = Math.max(dp[i], max);
			map.put(c[i], i);
		}
		return max;
	}
}
