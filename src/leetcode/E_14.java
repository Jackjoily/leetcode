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
public class E_14 {
	public static void main(String[] args) {
	}

	public String longestCommonPrefix(String[] strs) {
		int n = strs.length;
		if (n == 0)
			return "";
		if (n == 1) {
			return strs[0];
		}
		String str = strs[0];
		String s = " ";
		int i = 0;
		boolean flag = true;
		for (; i < str.length(); i++) {
			if (!flag) {
				break;
			}
			s = str.substring(0, i + 1);
			for (int j = 1; j < strs.length; j++) {
				if (!strs[j].startsWith(s)) {
					flag = false;
					break;
				}
			}
		}
		if (i == 0)
			return "";
		if(i==str.length()) {
			return  str;
		}else {
			return s.substring(0, i-1);
		}
	}
}
