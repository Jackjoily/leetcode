package leetcode_string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度： 每个元音字母，即 'a'，'e'，'i'，'o'，'u'
 * ，在子字符串中都恰好出现了偶数次。
 * 
 * @author jackjoily
 *
 */
public class M_1371 {
	public static void main(String[] args) {
		System.out.println(findTheLongestSubstring("eleetminicoworoep"));
	}

	public static int findTheLongestSubstring(String s) {
		int n = s.length();
		int max = 0;
		int a = 0, e = 0, i = 0, o = 0, u = 0, temp = 0;
		for (int l = 0; l < n; l++) {
			a = 0;
			e = 0;
			i = 0;
			o = 0;
			u = 0;
			temp = 0;
			if (n - l < max) {
				break;
			}
			for (int j = l; j < n; j++) {
			
				char ch = s.charAt(j);
				if (ch == 'a') {
					a++;
				} else if (ch == 'e') {
					e++;
				} else if (ch == 'i') {
					i++;
				} else if (ch == 'o') {
					o++;
				} else if (ch == 'u') {
					u++;
				}
				if (a % 2 != 0 || e % 2 != 0 || i % 2 != 0 || o % 2 != 0 || u % 2 != 0) {
				} else {
					max = Math.max(j - l + 1, max);
				}

			}
		}
		return max;
	}
}
