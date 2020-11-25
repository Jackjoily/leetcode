package leetcode_string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 * 
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * 
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 * 
 * countAndSay(1) = "1" countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 * 前五项如下：
 * 
 * 
 * @author jackjoily
 *
 */
public class E_30 {
	public static void main(String[] args) {
		E_30 e = new E_30();
		System.out.println(e.countAndSay(4));
	}

	public String countAndSay(int n) {
		if (n == 1)
			return "1";
		String dp[] = new String[n];
		dp[0] = "1";
		for (int i = 1; i < n; i++) {
			dp[i] = transfer(dp[i - 1]);
		}
		return dp[n - 1];
	}

	public String transfer(String a) {
		char[] c = a.toCharArray();
		int temp = 1;
		boolean f;
		char b = 0;
		int j;
		int i;
		StringBuilder sb = new StringBuilder();
		for (i = 0; i < c.length - 1;) {
			temp = 1;
			b = c[i];
			f = true;
			for (j = i + 1; j < c.length && f; j++) {
				if (c[j] == c[i]) {
					temp++;
				} else {
					f = false;
				}
			}
			i = j - 1;
			sb.append(temp).append(b - '0');
		}
		if (i >= 1) {
			if (c[i] != c[i - 1]) {
				sb.append(1).append(c[i] - '0');
			}
		} else {
			return sb.append(1).append(c[0]).toString();
		}
		return sb.toString();
	}
}
