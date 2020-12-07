package leetcode_string;

import java.util.HashMap;
import java.util.Map;

/**
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。 *
 * 
 * @author jackjoily
 *
 */
public class E_696 {
	public static void main(String[] args) {
		System.out.println(countBinarySubstrings("10101"));
	}

	public static int countBinarySubstrings(String s) {
		if (s.length() == 1)
			return 0;
		char[] c = s.toCharArray();
		int res = 0;
		for (int i = 1; i < c.length; i++) {
			if (c[i] != c[i - 1]) {
				res++;
				int m = i + 1;
				int n = i - 2;
				while (n >= 0 && m < c.length && c[m] == c[i] && c[n] == c[i - 1]) {
					res++;
					n--;
					m++;
				}
			}
		}
		return res;
	}
}
