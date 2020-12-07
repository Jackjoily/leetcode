package leetcode_string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 
 * @author jackjoily
 *
 */
public class M_43 {
	public static void main(String[] args) {
		M_43 e = new M_43();
		System.out.println(e.multiply("123456789", "987654321"));
	}

	public String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0"))
			return "0";
		int m = num1.length();
		int n = num2.length();
		int res = 0;
		int k = 0, l = 0;
		int a[] = new int[m + n];
		for (k = m - 1; k >= 0; k--) {
			for (l = n - 1; l >= 0; l--) {
				int p1 = k + l, p2 = k + l + 1;
				res = (num1.charAt(k) - '0') * (num2.charAt(l) - '0') + a[p2];
				a[p1] += res / 10;
				a[p2] = res % 10;
			}
		}
		StringBuilder sb = new StringBuilder();
		boolean flag = true;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 0 && flag) {
				continue;
			} else if (a[i] != 0 && flag) {
				flag = false;
				sb.append(a[i]);
			} else {
				sb.append(a[i]);
			}
		}
		return sb.toString();
	}

}
