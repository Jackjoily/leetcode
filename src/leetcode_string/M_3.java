package leetcode_string;

import java.util.HashMap;
import java.util.Map;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_ADDPeer;

/**
 * 最长无重复子串
 * 
 * @author jackjoily
 *
 */
public class M_3 {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring1("23423adf"));
	}

	/**
	 * 使用动态规划进行解决问题
	 * 
	 * @param s
	 * @return
	 */
	public static int lengthOfLongestSubstring(String s) {
		int length = s.length();
		if (length <= 1)
			return length;
		int max = 1;
		int dp[] = new int[s.length()];
		Map<Character, Integer> map = new HashMap<>();
		dp[0] = 1;
		map.put(s.charAt(0), 0);
		for (int i = 1; i < s.length(); i++) {
			char charAt = s.charAt(i);
			if (map.containsKey(charAt)) {
				dp[i] = Math.min(dp[i - 1] + 1, i - map.get(charAt));
			} else {
				dp[i] = dp[i - 1] + 1;
			}
			map.put(charAt, i);
			max = Math.max(dp[i], max);
		}
		return max;
	}

	/**
	 * 使用滑动窗口进行解决问题
	 * 
	 * @param s
	 * @return
	 */
	public static int lengthOfLongestSubstring1(String s) {
		int length = s.length();
		if (length <= 1)
			return length;
		int max = 1;
		int left = 0;
		Map<Character, Integer> map = new HashMap<>();
		map.put(s.charAt(0), 0);
		for (int i = 1; i < length; i++) {
			char charAt = s.charAt(i);
			if (map.containsKey(charAt)) {
				left = Math.max(left, map.get(charAt)+1);
			}
			map.put(charAt, i);
			max = Math.max(max, i - left + 1);
		}
		return max;
	}
}
