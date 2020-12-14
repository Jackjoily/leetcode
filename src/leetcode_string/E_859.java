package leetcode_string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
 * 
 * 交换字母的定义是取两个下标 i 和 j （下标从 0 开始），只要 i!=j 就交换 A[i] 和 A[j] 处的字符。例如，在 "abcd" 中交换下标
 * 0 和下标 2 的元素可以生成 "cbad" 。
 * 
 * @author jackjoily
 *
 */
public class E_859 {
	public static void main(String[] args) {
		System.out.println(buddyStrings("", ""));
	}

	public static boolean buddyStrings(String A, String B) {
		char[] a = A.toCharArray();
		char[] b = B.toCharArray();
		if (a.length != b.length)
			return false;
		List<Integer> list = new ArrayList<>();
		boolean flag = false;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) {
				list.add(i);
			}
			if (!flag) {
				for (int j = i + 1; j < a.length; j++) {
					if (a[i] == a[j]) {
						flag = true;
					}
				}
			}
		}
		if (list.size() >= 3) {
			return false;
		} else if (list.size() == 2) {
			char c = a[list.get(0)];
			a[list.get(0)] = a[list.get(1)];
			a[list.get(1)] = c;
			if (new String(a).equals(B)) {
				return true;
			} else {
				return false;
			}
		} else if (list.size() == 1) {
			return false;
		} else {
			if (flag) {
				return true;
			} else {
				if (a.length <= 1)
					return false;
				if (a[a.length - 2] == a[a.length - 1]) {
					return true;
				}
			}
		}
		return false;
	}
}
