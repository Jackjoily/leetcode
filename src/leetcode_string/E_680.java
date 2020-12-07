package leetcode_string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author jackjoily
 *
 */
public class E_680 {
	public static void main(String[] args) {
		System.out.println(validPalindrome("atbbga"));
	}

	public static boolean validPalindrome(String s) {
		int low = 0, high = s.length() - 1;
		while (low < high) {
			char c = s.charAt(low), d = s.charAt(high);
			if (c == d) {
				low++;
				high--;
			} else {
				int l1 = low;
				int h1 = high;
				l1 = low + 1;
				while (l1 < h1 && s.charAt(l1) == s.charAt(h1)) {
					l1++;
					h1--;
				}
				if (l1 >= h1) {
					return true;
				}
				l1 = low;
				h1 = high;
				h1 = high - 1;
				while (l1 < h1 && s.charAt(l1) == s.charAt(h1)) {
					l1++;
					h1--;
				}
				if (l1 >= h1) {
					return true;
				}
				low++;
				high--;
				return false;
			}
		}
		return true;
	}
}
