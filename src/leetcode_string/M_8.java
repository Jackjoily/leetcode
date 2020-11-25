package leetcode_string;

import java.util.HashMap;
import java.util.Map;

/**
 * 
请你来实现一个 atoi 函数，使其能将字符串转换成整数。

首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：

如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。

在任何情况下，若函数不能进行有效的转换时，请返回 0 。

提示：

本题中的空白字符只包括空格字符 ' ' 。
假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * 
 * @author jackjoily
 *
 */
public class M_8 {
    public int myAtoi(String str) {
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
