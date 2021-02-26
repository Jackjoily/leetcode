package leetcode_array;

import java.util.HashMap;
import java.util.Map;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数
 * 
 * @author jackjoily
 *
 */
public class E_9 {
	public static void main(String[] args) {
		System.out.println(isPalindrome1(12321));
	}

	public static boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		String str = x + "";
		int i = 0;
		int j = str.length() - 1;
		if (j == 0)
			return true;
		while (i < j) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public static boolean isPalindrome1(int x) {
		// 是负数以及个位数为0的情况
		if (x < 0 || (x % 10 == 0 && x != 0))
			return false;
		int revert = 0;
		// 121
		while (x > revert) {
			revert = revert * 10 + x % 10;
			x /= 10;
		}
		if (x == revert || x == revert / 10)
			return true;
		return false;
	}
}
