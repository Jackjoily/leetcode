package JianZhiOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer48 {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
	}

	public static int lengthOfLongestSubstring(String s) {
		int len = s.length();
		if (len == 0)
			return 0;
		if (len == 1)
			return 1;
		Map<Character, Integer> a = new HashMap<>();
		int dp[] = new int[len];
		dp[0] = 1;
		a.put(s.charAt(0), 0);
		int max = 0;
		for (int i = 1; i < s.length(); i++) {
			char charAt = s.charAt(i);
			if (charAt == s.charAt(i - 1)) {
				dp[i] = 1;
			} else {
				if (a.containsKey(charAt)) {
					dp[i] = Math.min(dp[i - 1] + 1, i - a.get(charAt));
				} else {
					dp[i] = dp[i - 1] + 1;
				}
			}
			a.put(charAt, i);
			max = Math.max(max, dp[i]);
		}
		return max;
	}

}
