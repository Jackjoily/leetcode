package leetcode_string;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312"
 * 和 "192.168@1.1" 是 无效的 IP 地址。
 * 
 *  
 * 
 * @author jackjoily
 *
 */
public class M_93 {
	public static void main(String[] args) {
		String a = "25525511135";
		char[] charArray = a.toCharArray();
		StringBuilder sb = new StringBuilder();
		f(charArray, 0, 0, sb);
	}

	public List<String> restoreIpAddresses(String s) {

		return null;
	}

	public static void f(char a[], int start, int count, StringBuilder sb) {
		if (count == 4) {
			System.out.println(sb.toString());
			return;
		} else if (count < 4&&start<a.length-3) {
			if (sb.length() == 0) {
				sb.append(a[start]);
				sb.append(".");
				f(a, start + 1, count + 1, sb);
				sb.replace(sb.length() - 1, sb.length(), a[start + 1] + "");
				sb.append(".");
				f(a, start + 2, count + 1, sb);
				sb.replace(sb.length() - 1, sb.length(), a[start + 2] + "");
				sb.append(".");
				f(a, start + 3, count + 1, sb);
			} else {
				if (count < 4) {
					if (sb.substring(sb.length() - 1, sb.length()).equals(".")) {
						if (a[start] - '0' > 2)
							return;
						else {
							sb.append(a[start]);
							sb.append(".");
							f(a, start + 1, count + 1, sb);
							sb.replace(sb.length() - 1, sb.length(), a[start + 1] + "");
							sb.append(".");
							f(a, start + 2, count + 1, sb);
							sb.replace(sb.length() - 1, sb.length(), a[start + 2] + "");
							sb.append(".");
							f(a, start + 3, count + 1, sb);
						}
					}
				}

			}
		}

	}
}
