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
public class E_1071 {
	public static void main(String[] args) {
		System.out.println(gcdOfStrings("ABCDEFABCDEF", "ABCDEF"));
	}

	public static String gcdOfStrings(String str1, String str2) {
		StringBuilder sb = new StringBuilder();
		StringBuilder sb1 = new StringBuilder();
		if (sb.append(str1).append(str2).toString().equals(sb1.append(str2).append(str1).toString())) {
			return str1.substring(0, gcd(str1.length(), str2.length()));
		} else {
			return "";
		}
	}

	public static int gcd(int a, int b) {
		int c = 0;
		while (a % b != 0) {
			c = a % b;
			a = b;
			b = c;
		}
		return b;
	}
}
