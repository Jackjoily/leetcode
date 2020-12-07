package leetcode_string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * 
 * @author jackjoily
 *
 */
public class E_415 {
	public static void main(String[] args) {
		E_415 e = new E_415();
		System.out.println(e.addStrings("408", "5"));
	}

	public String addStrings(String num1, String num2) {
		if (num1.equals("0"))
 			return num2;
		if (num2.equals("0"))
 			return num1;
		int i = num1.length() - 1;
		int j = num2.length() - 1;
		int a[] = new int[i + j + 2];
		int res = 0;
		int val = 0;
		int k = i + j + 1;
		while (i >= 0 && j >= 0) {
			res = ((num1.charAt(i) - '0') + (num2.charAt(j) - '0') + val);
			a[k] = res % 10;
			val = res / 10;
			i--;
			j--;
			k--;
		}
		if (i == j) {
			if (val != 0) {
				a[k] = val;
			}
		} else if (i < j) {
			while (j >= 0) {
				res = ((num2.charAt(j) - '0') + val);
				a[k] = res % 10;
				val = res / 10;
				k--;
				j--;
			}
			if (val != 0) {
				a[k] = val;
			}
		} else {
			while (i >= 0) {
				res = ((num1.charAt(i) - '0') + val);
				a[k] = res % 10;
				val = res / 10;
				k--;
				i--;
			}
			if (val != 0) {
				a[k] = val;
			}
		}
		StringBuilder sb = new StringBuilder();
		boolean flag = true;
		for (int l = 0; l < a.length; l++) {
			if (a[l] == 0 && flag) {
				continue;
			} else if (a[l] != 0 && flag) {
				flag = false;
				sb.append(a[l]);
			} else {
				sb.append(a[l]);
			}
		}
		return sb.toString();
	}
}
