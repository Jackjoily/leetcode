package leetcode;

import java.util.Arrays;
import java.util.HashMap;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class E_38 {

	public static void main(String[] args) {
		countAndSay(20);
	}

	public static String countAndSay(int n) {
		if (n == 1)
			return "1";
		String str = "1";
		for (int i = 2; i <= n; i++) {
			int j = 0;
			StringBuilder sb = new StringBuilder();
			while (j < str.length()) {
				char c = str.charAt(j);
				j++;
				int count = 1;
				while (j < str.length() && str.charAt(j) == c) {
					j++;
					count++;
				}
				sb.append(count);
				sb.append(c);
			}
			str = sb.toString();
		}
		return str;
	}
}
