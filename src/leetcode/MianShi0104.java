package leetcode;

import java.util.Arrays;
import java.util.HashMap;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class MianShi0104 {
	public static void main(String[] args) {
		System.out.println(canPermutePalindrome("abcabced"));
	}

	public static boolean canPermutePalindrome(String s) {
		char[] c = s.toCharArray();
		int odd = 0;
		int a[] = new int[26];
		for (int i = 0; i < c.length; i++) {
			int j = c[i] - 'a';
			if (a[j] % 2 == 0) {
				odd++;
			} else {
				odd--;
			}
			a[j]++;
		}
		return odd > 1 ? false : true;

	}
}
