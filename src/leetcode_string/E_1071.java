package leetcode_string;

import java.util.HashMap;
import java.util.Map;

/**
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。 *
 * 
 * @author jackjoily
 *
 */
public class E_1071 {
	public static void main(String[] args) {
		System.out.println(gcd(1, 13));
	}

	public String gcdOfStrings(String str1, String str2) {
		int len1 = str1.length(), len2 = str2.length();
		for (int i = Math.min(len1, len2); i >= 1; --i) { // 从长度大的开始枚举
			if (len1 % i == 0 && len2 % i == 0) {
				String X = str1.substring(0, i);
				if (check(X, str1) && check(X, str2)) {
					return X;
				}
			}
		}
		return "";
	}

	public boolean check(String t, String s) {
		int lenx = s.length() / t.length();
		StringBuffer ans = new StringBuffer();
		for (int i = 1; i <= lenx; ++i) {
			ans.append(t);
		}
		return ans.toString().equals(s);
	}

	/**
	 * 辗转相除求余数
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int gcd(int a, int b) {
		if (a > b) {
			int c = a % b;
			while (c != 0) {
				a = b;
				b = c;
				c = a % b;
			}
			return b;
		} else {
			int c = b % a;
			while (c != 0) {
				b = a;
				a = c;
				c = b % a;
			}
			return a;
		}
	}
}
