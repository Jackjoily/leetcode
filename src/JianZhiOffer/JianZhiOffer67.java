package JianZhiOffer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import edu.princeton.cs.algs4.In;

/**
 * 
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。 不能使用 atoi 或者其他类似的库函数。
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer67 {
	public static void main(String[] args) {
		String[] split = "4193 with words".split("\\s+");
		System.out.println(strToInt("-000000000000001"));
		// String str = "123456";
		// System.out.println(str.substring(1, str.length()));
	}

	public static int strToInt(String str) {
		String[] split = str.split("\\s+");
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		for (int i = 0; i < split.length; i++) {
			String trim = split[i].trim();
			if (trim.equals("")) {
				continue;
			}
			if (('0' <= trim.charAt(0) && trim.charAt(0) <= '9') || trim.charAt(0) == '-' || trim.charAt(0) == '+') {
				sb.append(trim.charAt(0));
				for (int k = 1; k < trim.length(); k++) {
					if (('0' <= trim.charAt(k) && trim.charAt(k) <= '9')) {
						sb.append(trim.charAt(k));
						flag = true;
					} else {
						break;
					}
				}
				break;
			} else {
				break;
			}
		}
		String val = sb.toString();
		if (val.equals("") || (val.charAt(0) == '+' || val.charAt(0) == '-') && !flag) {
			return 0;
		}

		int m = 0;
		while (m < val.length() && val.charAt(m) == '0')
			m++;
		if (m != 0) {
			val = val.substring(m, val.length());
			if (val.equals("") || (val.charAt(0) == '+' || val.charAt(0) == '-') && !flag) {
				return 0;
			}
		}
		String max = Integer.MAX_VALUE + "";
		String min = Integer.MIN_VALUE + "";
		String umax = (Integer.MAX_VALUE + "").replace("+", "");
		String umin = (Integer.MIN_VALUE + "").replace("-", "");
		if (val.charAt(0) == '+') {

			String substring = val.substring(1, val.length());

			int n = 0;
			while (n < substring.length() && substring.charAt(n) == '0')
				n++;
			if (n != 0) {
				val = substring.substring(n, substring.length());
				if (val.equals("") || (substring.charAt(0) == '+' || substring.charAt(0) == '-') && !flag) {
					return 0;
				}
			}

			if (substring.length() < max.length()) {
				return Integer.valueOf(substring);
			} else if (substring.length() > max.length()) {
				return Integer.MAX_VALUE;
			} else {
				if (substring.compareTo(max) > 0)
					return Integer.MAX_VALUE;
				else {
					return Integer.valueOf(substring);
				}
			}
		} else if (val.charAt(0) == '-') {
			String substring = val.substring(1, val.length());
			int l = 0;
			while (l < substring.length() && substring.charAt(l) == '0')
				l++;
			if (l != 0) {
				substring = substring.substring(l, substring.length());
				if (substring.equals("") || (substring.charAt(0) == '+' || substring.charAt(0) == '-') && !flag) {
					return 0;
				}
			}
			substring = "-" + substring;
			if (substring.length() < min.length()) {
				return Integer.valueOf(substring);
			} else if (substring.length() > min.length()) {
				return Integer.MIN_VALUE;
			} else {
				if (substring.compareTo(min) > 0)
					return Integer.MIN_VALUE;
				else {
					return Integer.valueOf(substring);
				}
			}
		}

		if (val.length() < umax.length()) {
			return Integer.valueOf(val);
		} else if (val.length() > umax.length()) {
			return Integer.MAX_VALUE;
		} else {
			if (val.compareTo(umax) > 0)
				return Integer.MAX_VALUE;
			else {
				return Integer.valueOf(val);
			}
		}

	}
}
