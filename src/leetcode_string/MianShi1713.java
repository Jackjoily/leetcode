package leetcode_string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定两个字符串 s1 和 s2，请编写一个程序， 确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * 
 * @author jackjoily
 *
 */
public class MianShi1713 {
	public static void main(String[] args) {
		String[] d = { "potimzz" };
		System.out.println(respace(d, "potimzzpotimzz"));
	}

	/**
	 * 方法一 使用
	 * @param dictionary
	 * @param sentence
	 * @return
	 */
	public static int respace(String[] dictionary, String sentence) {
		Set<String> dict = new HashSet<>(Arrays.asList(dictionary));
		int n = sentence.length();
		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			dp[i] = dp[i - 1] + 1;
			for (int idx = 0; idx < i; idx++) {
				if (dict.contains(sentence.substring(idx, i))) {
					dp[i] = Math.min(dp[i], dp[idx]);
				}
			}
		}
		return dp[n];
	}
}
