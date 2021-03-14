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
public class E_40 {
	public int longestPalindrome(String s) {
		char[] charArray = s.toCharArray();
		int count[] = new int[128];
		for (int i = 0; i < charArray.length; i++) {
			count[charArray[i]]++;
		}
		int sum = 0;
		for (int i = 0; i < 128; i++) {
			sum += count[i] / 2 * 2;
			if (count[i] % 2 == 1 && sum % 2 == 0) {
				sum++;
			}
		}
		return sum;
	}
}
