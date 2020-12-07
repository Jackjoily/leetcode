package leetcode_string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class M_91 {

	public static void main(String[] args) {
		M_91 m = new M_91();
		System.out.println(m.numDecodings2("123456"));
		System.out.println(m.numDecodings1("123456"));
		System.out.println(m.numDecodings("123456"));
	}

	public int numDecodings2(String s) {
		if (s.length() == 0 || s.charAt(0) == '0' || s.contains("00") || s.contains("30") || s.contains("40")
				|| s.contains("50") || s.contains("60") || s.contains("70") || s.contains("80") || s.contains("90")) {
			return 0;
		}
		int[] dp = new int[s.length() + 1];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= s.length(); i++) {

			if (s.charAt(i - 1) == '0') {
				dp[i] = dp[i - 2];

			} else if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7')) {
				dp[i] = dp[i - 1] + dp[i - 2];
			} else {
				dp[i] = dp[i - 1];
			}
		}
		return dp[s.length()];
	}

	public int numDecodings1(String s) {
		if (s.length() == 0 || s.charAt(0) == '0' || s.contains("00") || s.contains("30") || s.contains("40")
				|| s.contains("50") || s.contains("60") || s.contains("70") || s.contains("80") || s.contains("90")) {
			return 0;
		}
		int dp[] = new int[s.length() + 1];
		dp[0] = 1;
		dp[1] = 1;
			for (int i = 2; i <= s.length(); i++) {
				if (s.charAt(i - 1) == '0') {
					dp[i] = dp[i - 2];
				} else {
					if (s.charAt(i-2)=='1' || (s.charAt(i-2)=='2' && s.charAt(i-1)<'7')) {
						dp[i] = dp[i - 1] + dp[i - 2];
					} else {
						dp[i] = dp[i - 1];
					}
				}
			}

		return dp[s.length()];}

	Character[] map = { ' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
			'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	public int numDecodings(String s) {
		if (s.equals("0"))
			return 0;
		f(s, s.length(), 0);
		return temp;
	}

	public String isOkay(String s, int i, int j) {
		if (i == j) {
			if (s.charAt(i) - '0' == 0)
				return "0";
			return map[s.charAt(i) - '0'] + "";
		} else {
			if (s.charAt(i) == '0')
				return "0";
			int res = 0;
			for (int k = i; k <= j; k++) {
				res = res * 10 + (s.charAt(k) - '0');
			}
			if (0 < res && res <= 26) {
				return map[res] + "";
			}
			return "0";
		}
	}

	LinkedList<String> list = new LinkedList<>();
	int temp = 0;

	public void f(String s, int len, int start) {
		if (len == start) {
			temp++;
			return;
		} else if (start > len)
			return;
		else {
			for (int i = 0; i < 2; i++) {
				if ((i == 0 && s.charAt(i) == '0') || i + start >= len)
					return;
				String str = isOkay(s, start, start + i);
				if (!str.equals("0")) {
					list.add(str);
					f(s, len, start + i + 1);
					list.removeLast();
				}
			}
		}
	}
}
