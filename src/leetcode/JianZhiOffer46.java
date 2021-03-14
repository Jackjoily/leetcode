package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer46 {
	public static void main(String[] args) {
		JianZhiOffer46 j = new JianZhiOffer46();
		char c[] = new char[26];
		for (int i = 0; i < 26; i++) {
			c[i] = (char) (i + 97);
		}
		LinkedList<Character> list = new LinkedList();
		StringBuilder sb = new StringBuilder();
		// j.f("12258".toCharArray(), 0, list, 5);
		System.out.println(translateNum1(506));
	}

	int count = 0;

	public int translateNum(int num) {
		if (num <= 9)
			return 1;
		char[] charArray = (num + "").toCharArray();
		LinkedList<Character> list = new LinkedList();
		f(charArray, 0, list, charArray.length);
		return count;
	}

	public static int translateNum1(int num) {
		if (num < 10)
			return 1;
		String str = num + "";
		int dp[] = new int[str.length()];
		Arrays.fill(dp, 1);
		dp[0] = 1;
		if (10 <= Integer.valueOf(str.substring(0, 2)) && Integer.valueOf(str.substring(0, 2)) <= 25) {
			dp[1] = 2;
		}
		for (int i = 2; i < str.length(); i++) {
			if (str.charAt(i - 1) != '0' && Integer.valueOf(str.substring(i - 1, i + 1)) <= 25) {
				dp[i] = dp[i - 1] + dp[i - 2];
			} else {
				dp[i] = dp[i - 1];
			}
		}
		return dp[str.length() - 1];
	}

	public void f(char chr[], int inx, LinkedList<Character> list, int len) {
		if (inx == len && list.size() == len) {
			count++;
		}
		for (int i = inx; i < len; i++) {
			list.add(chr[i]);
			f(chr, i + 1, list, len);
			list.removeLast();
			if (i + 1 < len && chr[i] != '0') {
				int q = (chr[i] - '0') * 10 + (chr[i + 1] - '0');
				if (q <= 25) {
					list.add(chr[i]);
					list.add(chr[i + 1]);
					f(chr, i + 2, list, len);
					list.removeLast();
					list.removeLast();
				}
			}
		}
	}

	public boolean isOkey(String substring) {
		if (substring.charAt(0) == '0') {
			return false;
		} else {
			if (substring.charAt(0) >= '3')
				return false;
			if (substring.charAt(0) == '2') {
				if (substring.charAt(1) > '5') {
					return false;
				}
			}
		}
		return true;
	}
}
